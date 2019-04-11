package me.bed0.jWynn.config;

public class WynncraftAPIConfig {

    private String baseURL;
    private boolean handleRatelimits;

    public WynncraftAPIConfig() {
        this("https://api.wynncraft.com/", true);
    }

    public WynncraftAPIConfig(String baseURL, boolean handleRatelimits) {
        this.baseURL = baseURL;
        this.handleRatelimits = handleRatelimits;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public boolean isHandleRatelimits() {
        return handleRatelimits;
    }
}
