package me.bed0.jWynn.api;

import me.bed0.jWynn.config.WynncraftAPIConfig;

public abstract class APIMidpoint {

    private long rateLimitResetTime = 0;
    private int rateLimitRemaining = 0;
    private int rateLimitMax = 0;

    public synchronized void updateRateLimit(long resetTime, int remaining, int max) {
        if (remaining < rateLimitRemaining || resetTime > rateLimitResetTime) {
            this.rateLimitResetTime = resetTime;
            this.rateLimitRemaining = remaining;
            this.rateLimitMax = max;
        }
    }

    public long getRateLimitReset() {
        return rateLimitResetTime;
    }

    public int getRateLimitRemaining() {
        return rateLimitRemaining;
    }

    public int getRateLimitMax() {
        return rateLimitMax;
    }

    public boolean isRateLimited() {
        return !getAPIConfig().isHandleRatelimits() || ((rateLimitRemaining <= 0) && (rateLimitResetTime > System.currentTimeMillis()));
    }

    public synchronized void decrementRateLimit() {
        this.rateLimitRemaining -= 1;
    }

    public abstract WynncraftAPIConfig getAPIConfig();
}
