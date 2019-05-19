package me.bed0.jWynn.api;

import me.bed0.jWynn.exceptions.*;
import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.annotation.CheckReturnValue;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public abstract class APIRequest<T> {

    private String requestURL;
    private List<Header> requestHeaders;
    private String userAgent;
    private int timeout;
    private boolean ignoreRateLimit;
    private File fallbackFile;

    private APIMidpoint midpoint;

    public APIRequest(String requestURL, APIMidpoint midpoint) {
        this(requestURL, new ArrayList<>(), midpoint.getAPIConfig().getDefaultUserAgent(), midpoint.getAPIConfig().getDefaultConnectionTimeout(), midpoint, false, null);
    }

    public APIRequest(String requestURL, List<Header> requestHeaders, String userAgent, int timeout, APIMidpoint midpoint, boolean ignoreRateLimit, File fallbackFile) {
        this.requestURL = requestURL;
        this.requestHeaders = requestHeaders;
        this.userAgent = userAgent;
        this.timeout = timeout;
        this.midpoint = midpoint;
        this.ignoreRateLimit = ignoreRateLimit;
        this.fallbackFile = fallbackFile;
    }

    /**
     * Run this request, getting the response data directly (therefore destroying meta data)
     */
    public abstract T run();

    /**
     * Run this request, the data returned is wrapped inside a APIResponse object, that also
     * contains the request meta data
     */
    public abstract APIResponse<T> runIncludeMeta();

    /**
     * When this request is run, the specified HTTP header will be included with the request
     */
    @CheckReturnValue
    public APIRequest<T> withHeader(Header header) {
        this.requestHeaders.add(header);
        return this;
    }

    /**
     * When this request is run, it will instead be sent to the specified URL
     */
    @CheckReturnValue
    public APIRequest<T> toURL(String requestURL) {
        this.requestURL = requestURL;
        return this;
    }

    /**
     * When this request is run, the user agent the request would normally be made as is
     * replaced with this agent
     */
    @CheckReturnValue
    public APIRequest<T> asAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    /**
     * When this request is run, instead of timing-out the request with the timeout specified
     * by the API config, instead timeout the request after this amount of time (milliseconds)
     */
    @CheckReturnValue
    public APIRequest<T> withTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    /**
     * When this request is run, don't do any rate limit management. The internal rate limits will
     * not be checked and won't be updated after the response is received
     */
    @CheckReturnValue
    public APIRequest<T> ignoreRateLimit() {
        this.ignoreRateLimit = true;
        return this;
    }

    /**
     * When this request is run, if it is successful, the response data is saved to the specified file,
     * if the request fails, attempt to load the request data stored in that file
     */
    @CheckReturnValue
    public APIRequest<T> fallbackFile(File file) {
        this.fallbackFile = file;
        return this;
    }

    protected String getResponse() {
        if (!ignoreRateLimit && midpoint.isRateLimited())
            throw new APIRateLimitExceededException("Cannot execute request " + requestURL + ", rate limit would be exceeded", midpoint.getRateLimitReset(), false);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout).build();
        try (CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(requestConfig).build()) {
            HttpGet httpGet = new HttpGet(requestURL);
            Header[] requestHeaders = new Header[this.requestHeaders.size()];
            httpGet.setHeaders(this.requestHeaders.toArray(requestHeaders));
            httpGet.setHeader("user-agent", userAgent);
            ResponseHandler<String> handler = httpResponse -> {
                if (midpoint.getAPIConfig().isHandleRatelimits()) {
                    try {
                        long rateLimitReset = Long.parseLong(httpResponse.getFirstHeader("x-ratelimit-reset").getValue());
                        int rateLimitMax = Integer.parseInt(httpResponse.getFirstHeader("x-ratelimit-limit").getValue());
                        int rateLimitRemaining = Integer.parseInt(httpResponse.getFirstHeader("x-ratelimit-remaining").getValue());
                        midpoint.updateRateLimit(rateLimitReset, rateLimitRemaining, rateLimitMax);
                    } catch (NumberFormatException | NullPointerException ignored) {
                        midpoint.decrementRateLimit();
                    }
                }
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status == HttpStatus.SC_OK) {
                    HttpEntity entity = httpResponse.getEntity();
                    String returnStr = entity != null ? EntityUtils.toString(entity) : null;
                    if (returnStr == null)
                        throw new APIResponseException("No body in request response for " + requestURL, -1);
                    if (returnStr.matches("\\{\"message\":\".*\"}")) {
                        throw new APIResponseException("API error when requesting " + requestURL + ": " + returnStr.split("\"message\":")[1].replace("\"", "").replace("}", ""), -1);
                    } else if (returnStr.matches("\\{\"error\":\".*\"}")) {
                        throw new APIResponseException("API error when requesting " + requestURL + ": " + returnStr.split("\"error\":")[1].replace("\"", "").replace("}", ""), -1);
                    }
                    if (!entity.getContentType().getValue().contains("application/json"))
                        throw new APIResponseException("Unexpected content type (not application/json): " + entity.getContentType().getValue(), -1);
                    if (fallbackFile != null && !fallbackFile.isDirectory()) {
                        fallbackFile.getParentFile().mkdirs();
                        FileUtils.writeStringToFile(fallbackFile, returnStr, StandardCharsets.UTF_8);
                    }
                    return returnStr;
                } else if (status == HttpStatus.SC_BAD_REQUEST) {
                    throw new APIRequestException("400: Bad Request for " + requestURL);
                } else if (status == 429 /* Too Many Requests */) {
                    long resetTime;
                    try {
                        resetTime = Long.parseLong(httpResponse.getFirstHeader("x-ratelimit-reset").getValue());
                    } catch (NumberFormatException ex) {
                        resetTime = -1;
                    }
                    throw new APIRateLimitExceededException("429: Too Many Requests for " + requestURL, resetTime, true);
                } else if (status == HttpStatus.SC_NOT_FOUND) {
                    throw new APIResponseException("404: Not Found for " + requestURL, 404);
                } else if (status == HttpStatus.SC_SERVICE_UNAVAILABLE) {
                    throw new APIResponseException("503: Service Unavailable " + requestURL, 503);
                } else {
                    throw new APIResponseException("Unexpected status code " + status + " returned by API for request " + requestURL, status);
                }
            };
            return client.execute(httpGet, handler);
        } catch (IOException ex) {
            if (fallbackFile == null) {
                throw new APIConnectionException(ex);
            }
            try {
                return FileUtils.readFileToString(fallbackFile, StandardCharsets.UTF_8);
            } catch (IOException ex2) {
                throw new APIConnectionException(ex);
            }
        } catch (APIException ex) {
            if (fallbackFile == null) {
                throw ex;
            }
            try {
                return FileUtils.readFileToString(fallbackFile, StandardCharsets.UTF_8);
            } catch (IOException ex2) {
                throw ex;
            }
        }
    }
}
