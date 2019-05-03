package me.bed0.jWynn.api.v2.player;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.common.GuildRank;
import me.bed0.jWynn.api.v1.endpoints.APIV1GuildStats;

public class WynncraftPlayerGuild {

    private String name;
    private GuildRank rank;

    public WynncraftPlayerGuild(String name, GuildRank rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public GuildRank getRank() {
        return rank;
    }

    @CheckReturnValue
    public APIV1GuildStats getDetails() {
        return WynncraftAPI.getApi().v1().guildStats(name);
    }
}
