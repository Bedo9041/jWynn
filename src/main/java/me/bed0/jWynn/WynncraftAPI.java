package me.bed0.jWynn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.APIResponseV1;
import me.bed0.jWynn.api.v1.APIV1GuildList;
import me.bed0.jWynn.api.v1.APIV1TerritoryList;
import me.bed0.jWynn.api.v1.APIVersion1;
import me.bed0.jWynn.api.v1.guild.GuildList;
import me.bed0.jWynn.api.v1.territory.WynncraftTerritory;
import me.bed0.jWynn.api.v2.APIVersion2;
import me.bed0.jWynn.api.v2.player.PlayerRank;
import me.bed0.jWynn.config.WynncraftAPIConfig;

public class WynncraftAPI {

    private WynncraftAPIConfig config;
    private APIVersion1 v1;
    private APIVersion2 v2;

    public static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(PlayerRank.class, new PlayerRank.PlayerRankDeserializer())
            .registerTypeAdapter(WynncraftTerritory[].class, new WynncraftTerritory.WynncraftTerritoryListDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<WynncraftTerritory[]>>(){}.getType(), new APIV1TerritoryList.APIV1TerritoryResponseDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<GuildList>>(){}.getType(), new APIV1GuildList.APIV1GuildListResponseDeserializer())
            .create();

    public static final String VERSION = "0.0.1";

    public WynncraftAPI() {
        this(new WynncraftAPIConfig());
    }

    public WynncraftAPI(WynncraftAPIConfig config) {
        this.config = config;
        this.v1 = new APIVersion1(this);
        this.v2 = new APIVersion2(this);
    }

    public APIVersion1 v1() {
        return v1;
    }

    public APIVersion2 v2() {
        return v2;
    }

    public WynncraftAPIConfig getConfig() {
        return config;
    }
}
