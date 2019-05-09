package me.bed0.jWynn.api.v1.network;

public class WynncraftOnlinePlayerSum {

    private int players_online;

    public WynncraftOnlinePlayerSum(int players_online) {
        this.players_online = players_online;
    }

    public int getPlayersOnline() {
        return players_online;
    }
}
