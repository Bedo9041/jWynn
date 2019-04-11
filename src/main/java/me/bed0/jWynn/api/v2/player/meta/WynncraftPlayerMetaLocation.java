package me.bed0.jWynn.api.v2.player.meta;

public class WynncraftPlayerMetaLocation {

    public boolean online;
    public String server;

    public WynncraftPlayerMetaLocation(boolean online, String server) {
        this.online = online;
        this.server = server;
    }

    public boolean isOnline() {
        return online;
    }

    public String getServer() {
        return server;
    }
}
