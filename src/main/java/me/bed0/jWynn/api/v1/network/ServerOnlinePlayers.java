package me.bed0.jWynn.api.v1.network;

public class ServerOnlinePlayers {

    private String server;
    private String[] players;

    public ServerOnlinePlayers(String server, String[] players) {
        this.server = server;
        this.players = players;
    }

    public String getServer() {
        return server;
    }

    public String[] getPlayers() {
        return players;
    }
}
