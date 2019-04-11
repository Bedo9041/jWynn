package me.bed0.jWynn.api.v2.player.rankings.player;

public class WynncraftPlayerRankingPlayer {

    private WynncraftPlayerRankingPlayerSolo solo;
    private WynncraftPlayerRankingPlayerOverall overall;

    public WynncraftPlayerRankingPlayer(WynncraftPlayerRankingPlayerSolo solo, WynncraftPlayerRankingPlayerOverall overall) {
        this.solo = solo;
        this.overall = overall;
    }

    public WynncraftPlayerRankingPlayerSolo getSolo() {
        return solo;
    }

    public WynncraftPlayerRankingPlayerOverall getOverall() {
        return overall;
    }
}
