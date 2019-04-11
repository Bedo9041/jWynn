package me.bed0.jWynn.api.v2.player.classes;

public class WynncraftPlayerClassPvp {

    private int kills;
    private int deaths;

    public WynncraftPlayerClassPvp(int kills, int deaths) {
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
