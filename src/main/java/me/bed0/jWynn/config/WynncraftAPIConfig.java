package me.bed0.jWynn.config;

import me.bed0.jWynn.WynncraftAPI;

public class WynncraftAPIConfig {

    private String baseURL;
    private String baseURLLegacy;
    private boolean handleRatelimits;
    private String defaultUserAgent;
    private int defaultConnectionTimeout;

    public WynncraftAPIConfig() {
        this("https://api.wynncraft.com/", "https://api-legacy.wynncraft.com/", true, "jWynn/v" + WynncraftAPI.VERSION, 10000);
    }

    @Deprecated
    public WynncraftAPIConfig(String baseURL, boolean handleRatelimits, String defaultUserAgent, int defaultConnectionTimeout) {
        this(baseURL, "https://api-legacy.wynncraft.com/", handleRatelimits, defaultUserAgent, defaultConnectionTimeout);
    }

    public WynncraftAPIConfig(String baseURL, String baseURLLegacy, boolean handleRatelimits, String defaultUserAgent, int defaultConnectionTimeout) {
        this.baseURL = baseURL;
        this.baseURLLegacy = baseURLLegacy;
        this.handleRatelimits = handleRatelimits;
        this.defaultUserAgent = defaultUserAgent;
        this.defaultConnectionTimeout = defaultConnectionTimeout;
    }

    public String getBaseURL() {
        return baseURL;
    }

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
