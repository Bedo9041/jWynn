package me.bed0.jWynn.api.v2.player.global;

public class WynncraftPlayerGlobalLevel {

    private int combat;
    private int profession;
    private int combined;

    public WynncraftPlayerGlobalLevel(int combat, int profession, int combined) {
        this.combat = combat;
        this.profession = profession;
        this.combined = combined;
    }

    public int getCombat() {
        return combat;
    }

    public int getProfession() {
        return profession;
    }

    public int getCombined() {
        return combined;
    }
}
