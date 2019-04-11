package me.bed0.jWynn.api.v2.player.global;

public class WynncraftPlayerGlobal {

    private int chestsFound;
    private long blocksWalked;
    private int itemsIdentified;
    private int mobsKilled;
    private WynncraftPlayerGlobalLevel totalLevel;
    private WynncraftPlayerGlobalPvp pvp;
    private int logins;
    private int deaths;
    private int discoveries;
    private int eventsWon;

    public WynncraftPlayerGlobal(int chestsFound, long blocksWalked, int itemsIdentified, int mobsKilled, WynncraftPlayerGlobalLevel totalLevel, WynncraftPlayerGlobalPvp pvp, int logins, int deaths, int discoveries, int eventsWon) {
        this.chestsFound = chestsFound;
        this.blocksWalked = blocksWalked;
        this.itemsIdentified = itemsIdentified;
        this.mobsKilled = mobsKilled;
        this.totalLevel = totalLevel;
        this.pvp = pvp;
        this.logins = logins;
        this.deaths = deaths;
        this.discoveries = discoveries;
        this.eventsWon = eventsWon;
    }

    public int getChestsFound() {
        return chestsFound;
    }

    public long getBlocksWalked() {
        return blocksWalked;
    }

    public int getItemsIdentified() {
        return itemsIdentified;
    }

    public int getMobsKilled() {
        return mobsKilled;
    }

    public WynncraftPlayerGlobalLevel getTotalLevel() {
        return totalLevel;
    }

    public WynncraftPlayerGlobalPvp getPvp() {
        return pvp;
    }

    public int getLogins() {
        return logins;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getDiscoveries() {
        return discoveries;
    }

    public int getEventsWon() {
        return eventsWon;
    }
}
