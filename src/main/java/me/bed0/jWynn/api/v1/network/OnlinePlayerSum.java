package me.bed0.jWynn.api.v1.network;

public class OnlinePlayerSum {

    private int players_online;

    public OnlinePlayerSum(int players_online) {
        this.players_online = players_online;
    }

    public int getPlayersOnline() {
        return players_online;
    }
}
