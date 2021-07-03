package me.bed0.jWynn.api.v2.player.classes;

import me.bed0.jWynn.api.v2.player.classes.professions.WynncraftPlayerClassProfessions;

public class WynncraftPlayerClass {

    private String name;
    private int level;
    private WynncraftPlayerClassDungeonCollection dungeons;
    private WynncraftPlayerClassQuests quests;
    private int itemsIdentified;
    private int mobsKilled;
    private WynncraftPlayerClassPvp pvp;
    private int chestsFound;
    private long blocksWalked;
    private int logins;
    private int deaths;
    private int playtime;
    private WynncraftPlayerClassSkills skills;
    private WynncraftPlayerClassProfessions professions;
    private int discoveries;
    private int eventsWon;
    private boolean preEconomyUpdate;
    private WynncraftPlayerClassRaidCollection raids;

    public WynncraftPlayerClass(String name, int level, WynncraftPlayerClassDungeonCollection dungeons, WynncraftPlayerClassQuests quests, int itemsIdentified, int mobsKilled, WynncraftPlayerClassPvp pvp, int chestsFound, long blocksWalked, int logins, int deaths, int playtime, WynncraftPlayerClassSkills skills, WynncraftPlayerClassProfessions professions, int discoveries, int eventsWon, boolean preEconomyUpdate, WynncraftPlayerClassRaidCollection raids) {
        this.name = name;
        this.level = level;
        this.dungeons = dungeons;
        this.quests = quests;
        this.itemsIdentified = itemsIdentified;
        this.mobsKilled = mobsKilled;
        this.pvp = pvp;
        this.chestsFound = chestsFound;
        this.blocksWalked = blocksWalked;
        this.logins = logins;
        this.deaths = deaths;
        this.playtime = playtime;
        this.skills = skills;
        this.professions = professions;
        this.discoveries = discoveries;
        this.eventsWon = eventsWon;
        this.preEconomyUpdate = preEconomyUpdate;
        this.raids = raids;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public WynncraftPlayerClassDungeonCollection getDungeons() {
        return dungeons;
    }

    public WynncraftPlayerClassQuests getQuests() {
        return quests;
    }

    public int getItemsIdentified() {
        return itemsIdentified;
    }

    public int getMobsKilled() {
        return mobsKilled;
    }

    public WynncraftPlayerClassPvp getPvp() {
        return pvp;
    }

    public int getChestsFound() {
        return chestsFound;
    }

    public long getBlocksWalked() {
        return blocksWalked;
    }

    public int getLogins() {
        return logins;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getPlaytime() {
        return playtime;
    }

    public WynncraftPlayerClassSkills getSkills() {
        return skills;
    }

    public WynncraftPlayerClassProfessions getProfessions() {
        return professions;
    }

    public int getDiscoveries() {
        return discoveries;
    }

    public int getEventsWon() {
        return eventsWon;
    }

    public boolean isPreEconomyUpdate() {
        return preEconomyUpdate;
    }

    public WynncraftPlayerClassRaidCollection getRaids() {
        return raids;
    }

    /**
     * Get the URL of the image representing this class from Wynncraft's CDN.
     * <b>Once downloaded, this image should be cached.</b>
     */
    public String getImageURL() {
        return "https://cdn.wynncraft.com/img/stats/classes/" + getBaseClass() + ".png";
    }

    /**
     * Get the base class for this class, (i.e. this will always be one of the four classes
     * that are not a cosmetic reskin)
     */
    public String getBaseClass() {
        String replacedName = name.replaceAll("\\d", "");
        switch (replacedName) {
            case "darkwizard": return "mage";
            case "ninja": return "assassin";
            case "knight": return "warrior";
            case "hunter": return "archer";
            default: return replacedName;
        }
    }
}
