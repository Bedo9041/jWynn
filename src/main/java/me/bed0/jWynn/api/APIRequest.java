package me.bed0.jWynn.api;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.exceptions.APIConnectionException;
import me.bed0.jWynn.exceptions.APIRateLimitExceededException;
import me.bed0.jWynn.exceptions.APIRequestException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class APIRequest<T> {

    private String requestURL;
    private List<Header> requestHeaders;
    private String userAgent;
    private int timeout;
    private boolean ignoreRateLimit;

    private APIMidpoint midpoint;

    public APIRequest(String requestURL, APIMidpoint midpoint) {
        this(requestURL, new ArrayList<>(), "jWynn/" + WynncraftAPI.VERSION, 10000, midpoint, false);
    }

    public APIRequest(String requestURL, List<Header> requestHeaders, String userAgent, int timeout, APIMidpoint midpoint, boolean ignoreRateLimit) {
        this.requestURL = requestURL;
        this.requestHeaders = requestHeaders;
        this.userAgent = userAgent;
        this.timeout = timeout;
        this.midpoint = midpoint;
        this.ignoreRateLimit = ignoreRateLimit;
    }

    public abstract T run();

    public abstract APIResponse<T> runIncludeMeta();

    public APIRequest<T> withHeader(Header header) {
        this.requestHeaders.add(header);
        return this;
    }

    public APIRequest<T> toURL(String requestURL) {
        this.requestURL = requestURL;
        return this;
    }

    public APIRequest<T> asAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public APIRequest<T> withTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public APIRequest<T> ignoreRateLimit() {
        this.ignoreRateLimit = true;
        return this;
    }

    protected String getReponse() {
        if (!ignoreRateLimit && midpoint.isRateLimited())
            throw new APIRateLimitExceededException("Cannot execute request " + requestURL + ", rate limit exceeded", midpoint.getRateLimitReset(), false);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(timeout).setSocketTimeout(timeout).build();
        try (CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(requestConfig).build()) {
            HttpGet httpGet = new HttpGet(requestURL);
            Header[] requestHeaders = new Header[this.requestHeaders.size()];
            httpGet.setHeaders(this.requestHeaders.toArray(requestHeaders));
            httpGet.setHeader("user-agent", userAgent);
            ResponseHandler<String> handler = httpResponse -> {
                long rateLimitReset = Long.parseLong(httpResponse.getFirstHeader("x-ratelimit-reset").getValue());
                int rateLimitMax = Integer.parseInt(httpResponse.getFirstHeader("x-ratelimit-limit").getValue());
                int rateLimitRemaining = Integer.parseInt(httpResponse.getFirstHeader("x-ratelimit-remaining").getValue());
                midpoint.updateRateLimit(rateLimitReset, rateLimitRemaining, rateLimitMax);
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status == HttpStatus.SC_OK) {
                    HttpEntity entity = httpResponse.getEntity();
                    String returnStr = entity != null ? EntityUtils.toString(entity) : null;
                    if (returnStr == null)
                        throw new APIRequestException("No body in request response for " + requestURL);
                    if (returnStr.matches("\\{\"message\":\".*\"}")) {
                        throw new APIRequestException("API error when requesting " + requestURL + ": " + returnStr.split("\"message\":")[1].replace("\"", "").replace("}", ""));
                    } else if (returnStr.matches("\\{\"error\":\".*\"}")) {
                        throw new APIRequestException("API error when requesting " + requestURL + ": " + returnStr.split("\"error\":")[1].replace("\"", "").replace("}", ""));
                    }
                    return returnStr;
                } else {
                    throw new APIConnectionException("Unexpected status code " + status + " returned by API for request " + requestURL);
                }
            };
            return client.execute(httpGet, handler);
        } catch (IOException ex) {
            throw new APIConnectionException(ex);
        }
    }
}
