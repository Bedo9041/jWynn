package me.bed0.jWynn.api.v2.player.rankings;

import me.bed0.jWynn.api.v2.player.rankings.player.WynncraftPlayerRankingPlayer;

public class WynncraftPlayerRanking {

    private int guild;
    private WynncraftPlayerRankingPlayer player;
    private int pvp;

    public WynncraftPlayerRanking(int guild, WynncraftPlayerRankingPlayer player, int pvp) {
        this.guild = guild;
        this.player = player;
        this.pvp = pvp;
    }

    public int getGuild() {
        return guild;
    }

    public WynncraftPlayerRankingPlayer getPlayer() {
        return player;
    }

    public int getPvp() {
        return pvp;
    }
}
