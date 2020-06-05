package me.bed0.jWynn.config;

import me.bed0.jWynn.WynncraftAPI;

public class WynncraftAPIConfig {

    private String baseURL;
    private String baseURLLegacy;
    private boolean handleRatelimits;
    private String defaultUserAgent;
    private int defaultConnectionTimeout;

    public WynncraftAPIConfig() {
        this("https://api.wynncraft.com/", true, "jWynn/v" + WynncraftAPI.VERSION, 10000);
    }

    public WynncraftAPIConfig(String baseURL, boolean handleRatelimits, String defaultUserAgent, int defaultConnectionTimeout) {
        this.baseURL = baseURL;
        this.baseURLLegacy = baseURL;
        this.handleRatelimits = handleRatelimits;
        this.defaultUserAgent = defaultUserAgent;
        this.defaultConnectionTimeout = defaultConnectionTimeout;
    }

    /**
     * @deprecated For a short period during May-June 2020, the Wynncraft API had separate URLs for the legacy and v2 APIs, this was removed and therefore this constructor is no longer needed
     */
    @Deprecated
    public WynncraftAPIConfig(String baseURL, String baseURLLegacy, boolean handleRatelimits, String defaultUserAgent, int defaultConnectionTimeout) {
        this(baseURL, handleRatelimits, defaultUserAgent, defaultConnectionTimeout);
        this.baseURLLegacy = baseURLLegacy;
    }

    public String getBaseURL() {
        return baseURL;
    }

    /**
     * @deprecated For a short period during May-June 2020, the Wynncraft API had separate URLs for the legacy and v2 APIs, this was removed and therefore this method is no longer needed
     */
    @Deprecated
    public String getBaseURLLegacy() {
        return baseURLLegacy;
    }

    public boolean isHandleRatelimits() {
        return handleRatelimits;
    }

    public String getDefaultUserAgent() {
        return defaultUserAgent;
    }

    public int getDefaultConnectionTimeout() {
        return defaultConnectionTimeout;
    }
}
