package me.bed0.jWynn.api.v2.player.rankings.player;

public class WynncraftPlayerRankingPlayerOverall {

    private int all;
    private int combat;
    private int profession;

    public WynncraftPlayerRankingPlayerOverall(int all, int combat, int profession) {
        this.all = all;
        this.combat = combat;
        this.profession = profession;
    }

    public int getAll() {
        return all;
    }

    public int getCombat() {
        return combat;
    }

    public int getProfession() {
        return profession;
    }
}
