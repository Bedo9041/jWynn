package me.bed0.jWynn.api.v1.leaderboard;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.v2.endpoints.APIV2PlayerStats;
import me.bed0.jWynn.api.v2.player.PlayerRank;
import me.bed0.jWynn.api.v2.player.PlayerTag;

public class PlayerLeaderboardPos {

    private String name;
    private String uuid;
    private int kills;
    private int level;
    private long xp;
    private int minPlayed;
    private PlayerTag tag;
    private PlayerRank rank;
    private boolean displayTag;
    private boolean veteran;
    private String guildTag;
    private String guild;
    private int num;

    public PlayerLeaderboardPos(String name, String uuid, int kills, int level, long xp, int minPlayed, PlayerTag tag, PlayerRank rank, boolean displayTag, boolean veteran, String guildTag, String guild, int num) {
        this.name = name;
        this.uuid = uuid;
        this.kills = kills;
        this.level = level;
        this.xp = xp;
        this.minPlayed = minPlayed;
        this.tag = tag;
        this.rank = rank;
        this.displayTag = displayTag;
        this.veteran = veteran;
        this.guildTag = guildTag;
        this.guild = guild;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    public int getKills() {
        return kills;
    }

    public int getLevel() {
        return level;
    }

    public long getXp() {
        return xp;
    }

    public int getMinPlayed() {
        return minPlayed;
    }

    public PlayerTag getTag() {
        return tag;
    }

    public PlayerRank getRank() {
        return rank;
    }

    public boolean isDisplayTag() {
        return displayTag;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public String getGuildTag() {
        return guildTag;
    }

    public String getGuild() {
        return guild;
    }

    public int getNum() {
        return num;
    }

    @CheckReturnValue
    public APIV2PlayerStats getDetailsRequest() {
        return WynncraftAPI.getApi().v2().player().stats(name);
    }
}
