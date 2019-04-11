package me.bed0.jWynn.api.v1.search;

public class StatsSearchResult {

    private String[] guilds;
    private String[] players;

    public StatsSearchResult(String[] guilds, String[] players) {
        this.guilds = guilds;
        this.players = players;
    }

    public String[] getGuilds() {
        return guilds;
    }

    public String[] getPlayers() {
        return players;
    }
}
