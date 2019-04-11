package me.bed0.jWynn.api.v2.player.meta;

import me.bed0.jWynn.api.v2.player.PlayerTag;

import java.util.Date;

public class WynncraftPlayerMeta {

    private Date firstJoin;
    private Date lastJoin;
    private WynncraftPlayerMetaLocation location;
    private int playtime;
    private WynncraftPlayerMetaTag tag;
    private boolean veteran;

    public WynncraftPlayerMeta(Date firstJoin, Date lastJoin, WynncraftPlayerMetaLocation location, int playtime, WynncraftPlayerMetaTag tag, boolean veteran) {
        this.firstJoin = firstJoin;
        this.lastJoin = lastJoin;
        this.location = location;
        this.playtime = playtime;
        this.tag = tag;
        this.veteran = veteran;
    }

    public Date getFirstJoin() {
        return firstJoin;
    }

    public Date getLastJoin() {
        return lastJoin;
    }

    public int getPlaytime() {
        return playtime;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public WynncraftPlayerMetaLocation getLocation() {
        return location;
    }

    public WynncraftPlayerMetaTag getTag() {
        return tag;
    }
}
