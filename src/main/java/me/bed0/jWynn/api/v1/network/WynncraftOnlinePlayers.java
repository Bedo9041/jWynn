package me.bed0.jWynn.api.v1.network;

public class WynncraftOnlinePlayers {

    private WynncraftServerOnlinePlayers[] onlinePlayers;

    public WynncraftOnlinePlayers(WynncraftServerOnlinePlayers[] onlinePlayers) {
        this.onlinePlayers = onlinePlayers;
    }

    public WynncraftServerOnlinePlayers[] getOnlinePlayers() {
        return onlinePlayers;
    }
}
