package me.bed0.jWynn.api.v2.player.classes.professions;

public class WynncraftPlayerClassProfessionArmouring {

    private int level;
    private float xp;

    public WynncraftPlayerClassProfessionArmouring(int level, float xp) {
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
