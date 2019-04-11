package me.bed0.jWynn.api.v2.player.global;

public class WynncraftPlayerGlobalPvp {

    private int kills;
    private int deaths;

    public WynncraftPlayerGlobalPvp(int kills, int deaths) {
        this.kills = kills;
        this.deaths = deaths;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }
}
