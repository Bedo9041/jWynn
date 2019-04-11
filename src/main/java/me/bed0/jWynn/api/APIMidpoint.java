package me.bed0.jWynn.api;

import me.bed0.jWynn.utils.Util;

public class APIMidpoint {

    private long rateLimitResetTime = 0;
    private int rateLimitRemaining = 0;
    private int rateLimitMax = 0;
    protected boolean v2;

    public void updateRateLimit(long resetTime, int remaining, int max) {
        this.rateLimitResetTime = resetTime;
        this.rateLimitRemaining = remaining;
        this.rateLimitMax = max;
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
        if ((rateLimitRemaining <= 0) && rateLimitResetTime > Util.getUnixTimestamp())
            return true;
        return false;
    }

    public boolean isV2() {
        return v2;
    }
}
