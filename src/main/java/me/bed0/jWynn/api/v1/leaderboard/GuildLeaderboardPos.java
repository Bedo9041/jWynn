package me.bed0.jWynn.api.v1.leaderboard;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.common.WynncraftGuildReward;
import me.bed0.jWynn.api.v1.endpoints.APIV1GuildStats;

import javax.annotation.CheckReturnValue;
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
    private int warCount;
    private String[] badges;
    private WynncraftGuildReward[] rewards;

    public GuildLeaderboardPos(String name, String prefix, long xp, int level, Date created, int territories, int membersCount, int num, int warCount, String[] badges, WynncraftGuildReward[] rewards) {
        this.name = name;
        this.prefix = prefix;
        this.xp = xp;
        this.level = level;
        this.created = created;
        this.territories = territories;
        this.membersCount = membersCount;
        this.num = num;
        this.warCount = warCount;
        this.badges = badges;
        this.rewards = rewards;
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

    public String[] getBadges() {
        return badges;
    }

    public WynncraftGuildReward[] getRewards() {
        return rewards;
    }

    @CheckReturnValue
    public APIV1GuildStats getDetailsRequest() {
        return WynncraftAPI.getApi().v1().guildStats(name);
    }
}
