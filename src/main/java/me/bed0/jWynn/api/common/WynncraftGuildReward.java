package me.bed0.jWynn.api.common;

import java.util.Date;

public class WynncraftGuildReward {
    private WynncraftGuildRewardType type;
    private int amount;
    private Date acquired;

    public WynncraftGuildReward(WynncraftGuildRewardType type, int amount, Date acquired) {
        this.type = type;
        this.amount = amount;
        this.acquired = acquired;
    }

    public WynncraftGuildRewardType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public Date getAcquired() {
        return acquired;
    }
}
