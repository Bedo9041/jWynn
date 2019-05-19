package me.bed0.jWynn.api.v2.player;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.v2.endpoints.APIV2PlayerStats;
import me.bed0.jWynn.api.v2.player.classes.WynncraftPlayerClass;
import me.bed0.jWynn.api.v2.player.global.WynncraftPlayerGlobal;
import me.bed0.jWynn.api.v2.player.meta.WynncraftPlayerMeta;
import me.bed0.jWynn.api.v2.player.rankings.WynncraftPlayerRanking;

import javax.annotation.CheckReturnValue;

public class WynncraftPlayer {

    private String username;
    private String uuid;
    private PlayerRank rank;
    private WynncraftPlayerMeta meta;
    private WynncraftPlayerClass[] classes;
    private WynncraftPlayerGuild guild;
    private WynncraftPlayerGlobal global;
    private WynncraftPlayerRanking ranking;

    public WynncraftPlayer(String username, String uuid, PlayerRank rank, WynncraftPlayerMeta meta, WynncraftPlayerClass[] classes, WynncraftPlayerGuild guild, WynncraftPlayerGlobal global, WynncraftPlayerRanking ranking) {
        this.username = username;
        this.uuid = uuid;
        this.rank = rank;
        this.meta = meta;
        this.classes = classes;
        this.guild = guild;
        this.global = global;
        this.ranking = ranking;
    }

    public String getUsername() {
        return username;
    }

    public String getUuid() {
        return uuid;
    }

    public PlayerRank getRank() {
        return rank;
    }

    public WynncraftPlayerMeta getMeta() {
        return meta;
    }

    public WynncraftPlayerClass[] getClasses() {
        return classes;
    }

    public WynncraftPlayerGuild getGuild() {
        return guild;
    }

    public WynncraftPlayerGlobal getGlobal() {
        return global;
    }

    public WynncraftPlayerRanking getRanking() {
        return ranking;
    }

    @CheckReturnValue
    public APIV2PlayerStats getRefreshRequest() {
        return WynncraftAPI.getApi().v2().player().stats(username);
    }
}
