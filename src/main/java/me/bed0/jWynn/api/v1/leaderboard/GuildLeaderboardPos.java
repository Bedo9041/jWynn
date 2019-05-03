package me.bed0.jWynn.api.v1.leaderboard;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.v1.endpoints.APIV1GuildStats;

import java.util.Date;

public class GuildLeaderboardPos {

    private String name;
    private String prefix;
    private long xp;
    private int level;
    private Date created;
    //TODO: private Banner banner;
    private int territories;
    private int membersCount;
    private int num;

    public GuildLeaderboardPos(String name, String prefix, long xp, int level, Date created, int territories, int membersCount, int num) {
        this.name = name;
        this.prefix = prefix;
        this.xp = xp;
        this.level = level;
        this.created = created;
        this.territories = territories;
        this.membersCount = membersCount;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public String getPrefix() {
        return prefix;
    }

    public long getXp() {
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

    public int getMembersCount() {
        return membersCount;
    }

    public int getNum() {
        return num;
    }

    @CheckReturnValue
    public APIV1GuildStats getDetailsRequest() {
        return WynncraftAPI.getApi().v1().guildStats(name);
    }
}
