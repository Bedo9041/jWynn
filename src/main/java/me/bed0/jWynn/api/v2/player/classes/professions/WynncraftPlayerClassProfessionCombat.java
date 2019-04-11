package me.bed0.jWynn.api.v2.player.classes.professions;

public class WynncraftPlayerClassProfessionCombat {

    private int level;
    private float xp;

    public WynncraftPlayerClassProfessionCombat(int level, float xp) {
        this.level = level;
        this.xp = xp;
    }

    public int getLevel() {
        return level;
    }

    public float getXp() {
        return xp;
    }
}
