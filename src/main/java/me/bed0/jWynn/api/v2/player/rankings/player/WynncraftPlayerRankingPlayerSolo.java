package me.bed0.jWynn.api.v2.player.rankings.player;

public class WynncraftPlayerRankingPlayerSolo {

    private int combat;
    private int woodcutting;
    private int mining;
    private int fishing;
    private int farming;
    private int alchemism;
    private int armouring;
    private int cooking;
    private int jeweling;
    private int scribing;
    private int tailoring;
    private int weaponsmithing;
    private int woodworking;
    private int profession;
    private int overall;

    public WynncraftPlayerRankingPlayerSolo(int combat, int woodcutting, int mining, int fishing, int farming, int alchemism, int armouring, int cooking, int jeweling, int scribing, int tailoring, int weaponsmithing, int woodworking, int profession, int overall) {
        this.combat = combat;
        this.woodcutting = woodcutting;
        this.mining = mining;
        this.fishing = fishing;
        this.farming = farming;
        this.alchemism = alchemism;
        this.armouring = armouring;
        this.cooking = cooking;
        this.jeweling = jeweling;
        this.scribing = scribing;
        this.tailoring = tailoring;
        this.weaponsmithing = weaponsmithing;
        this.woodworking = woodworking;
        this.profession = profession;
        this.overall = overall;
    }

    public int getCombat() {
        return combat;
    }

    public int getWoodcutting() {
        return woodcutting;
    }

    public int getMining() {
        return mining;
    }

    public int getFishing() {
        return fishing;
    }

    public int getFarming() {
        return farming;
    }

    public int getAlchemism() {
        return alchemism;
    }

    public int getArmouring() {
        return armouring;
    }

    public int getCooking() {
        return cooking;
    }

    public int getJeweling() {
        return jeweling;
    }

    public int getScribing() {
        return scribing;
    }

    public int getTailoring() {
        return tailoring;
    }

    public int getWeaponsmithing() {
        return weaponsmithing;
    }

    public int getWoodworking() {
        return woodworking;
    }

    public int getProfession() {
        return profession;
    }

    public int getOverall() {
        return overall;
    }
}
