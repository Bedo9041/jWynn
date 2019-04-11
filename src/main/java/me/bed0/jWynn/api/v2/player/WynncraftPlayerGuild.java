package me.bed0.jWynn.api.v2.player;

import me.bed0.jWynn.api.common.GuildRank;

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
}
