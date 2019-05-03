package me.bed0.jWynn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import me.bed0.jWynn.api.v1.APIResponseV1;
import me.bed0.jWynn.api.v1.APIVersion1;
import me.bed0.jWynn.api.v1.endpoints.*;
import me.bed0.jWynn.api.v1.guild.GuildList;
import me.bed0.jWynn.api.v1.guild.WynncraftGuild;
import me.bed0.jWynn.api.v1.item.ItemTier;
import me.bed0.jWynn.api.v1.item.WynncraftItem;
import me.bed0.jWynn.api.v1.map.WynncraftMapLocation;
import me.bed0.jWynn.api.v1.network.OnlinePlayerSum;
import me.bed0.jWynn.api.v1.search.StatsSearchResult;
import me.bed0.jWynn.api.v1.territory.WynncraftTerritory;
import me.bed0.jWynn.api.v2.APIVersion2;
import me.bed0.jWynn.api.v2.player.PlayerRank;
import me.bed0.jWynn.config.WynncraftAPIConfig;

import java.awt.*;

public class WynncraftAPI {

    public static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(PlayerRank.class, new PlayerRank.PlayerRankDeserializer())
            .registerTypeAdapter(WynncraftTerritory[].class, new WynncraftTerritory.WynncraftTerritoryListDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<WynncraftTerritory[]>>() {}.getType(), new APIV1TerritoryList.APIV1TerritoryResponseDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<GuildList>>() {}.getType(), new APIV1GuildList.APIV1GuildListResponseDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<WynncraftGuild>>() {}.getType(), new APIV1GuildStats.APIV1GuildStatsResponseDeserializer())
            .registerTypeAdapter(ItemTier.class, new ItemTier.ItemTierDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<WynncraftItem[]>>() {}.getType(), new APIV1ItemDB.APIV1ItemDBResponseDeserializer())
            .registerTypeAdapter(Color.class, new WynncraftItem.ItemColorDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<StatsSearchResult>>() {}.getType(), new APIV1StatsSearch.APIV1StatsSearchResponseDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<OnlinePlayerSum>>() {}.getType(), new APIV1OnlinePlayerSum.APIV1OnlinePlayerSumResponseDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<WynncraftMapLocation[]>>() {}.getType(), new APIV1MapLocations.APIV1MapLocationsResponseDeserializer())
            .create();
    public static final String VERSION = "0.1.2";
    private WynncraftAPIConfig config;
    private APIVersion1 v1;
    private APIVersion2 v2;

    private static WynncraftAPI INSTANCE;

    public WynncraftAPI() {
        this(new WynncraftAPIConfig());
    }

    public WynncraftAPI(WynncraftAPIConfig config) {
        this.config = config;
        this.v1 = new APIVersion1(this);
        this.v2 = new APIVersion2(this);

        WynncraftAPI.INSTANCE = this;
    }

    @CheckReturnValue
    public APIVersion1 v1() {
        return v1;
    }

    @CheckReturnValue
    public APIVersion2 v2() {
        return v2;
    }

    public WynncraftAPIConfig getConfig() {
        return config;
    }

    public static WynncraftAPI getApi() {
        return WynncraftAPI.INSTANCE;
    }
}
