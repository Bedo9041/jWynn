package me.bed0.jWynn.api.v1.guild;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.v1.endpoints.APIV1GuildStats;

import java.util.Date;

public class WynncraftGuild {

    private String name;
    private String prefix;
    private WynncraftGuildMember[] members;
    private float xp;
    private int level;
    private Date created;
    private int territories;

    public WynncraftGuild(String name, String prefix, WynncraftGuildMember[] members, float xp, int level, Date created, int territories) {
        this.name = name;
        this.prefix = prefix;
        this.members = members;
        this.xp = xp;
        this.level = level;
        this.created = created;
        this.territories = territories;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public WynncraftGuildMember[] getMembers() {
        return members;
    }

    public float getXp() {
        return xp;
    }

    public int getLevel() {
        return level;
    }

    public Date getCreated() {
        return created;
    }

    public int getTerritories() {
        return territories;
    }

    @CheckReturnValue
    public APIV1GuildStats getRerunRequest() {
        return WynncraftAPI.getApi().v1().guildStats(name);
    }
}
