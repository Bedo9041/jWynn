package me.bed0.jWynn;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.common.WynncraftIdentification;
import me.bed0.jWynn.api.v1.APIResponseV1;
import me.bed0.jWynn.api.v1.APIVersion1;
import me.bed0.jWynn.api.v1.endpoints.*;
import me.bed0.jWynn.api.v1.guild.GuildList;
import me.bed0.jWynn.api.v1.guild.WynncraftGuild;
import me.bed0.jWynn.api.v1.item.ItemTier;
import me.bed0.jWynn.api.v1.item.MajorID;
import me.bed0.jWynn.api.v1.item.WynncraftItem;
import me.bed0.jWynn.api.v1.map.WynncraftMapLocation;
import me.bed0.jWynn.api.v1.network.WynncraftOnlinePlayerSum;
import me.bed0.jWynn.api.v1.network.WynncraftOnlinePlayers;
import me.bed0.jWynn.api.v1.search.StatsSearchResult;
import me.bed0.jWynn.api.v1.territory.WynncraftTerritory;
import me.bed0.jWynn.api.v2.APIVersion2;
import me.bed0.jWynn.api.v2.ingredient.WynncraftIngredient;
import me.bed0.jWynn.api.v2.ingredient.WynncraftIngredientIdentificationDetails;
import me.bed0.jWynn.api.v2.player.PlayerRank;
import me.bed0.jWynn.api.v2.player.meta.WynncraftPlayerMetaTag;
import me.bed0.jWynn.config.WynncraftAPIConfig;
import me.bed0.jWynn.util.DateDeserializer;

import javax.annotation.CheckReturnValue;
import java.awt.*;
import java.util.Date;
import java.util.HashMap;

public class WynncraftAPI extends APIMidpoint {

    public static final Gson GSON = new GsonBuilder()
            .registerTypeAdapter(ItemTier.class, new ItemTier.ItemTierDeserializer())
            .registerTypeAdapter(MajorID.class, new MajorID.MajorIDDeserializer())
            .registerTypeAdapter(Color.class, new WynncraftItem.ItemColorDeserializer())
            .registerTypeAdapter(PlayerRank.class, new PlayerRank.PlayerRankDeserializer())
            .registerTypeAdapter(WynncraftPlayerMetaTag.class, new WynncraftPlayerMetaTag.PlayerTagDeserializer())
            .registerTypeAdapter(WynncraftTerritory[].class, new WynncraftTerritory.WynncraftTerritoryListDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<GuildList>>() {}.getType(), new APIV1GuildList.APIV1GuildListResponseDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<WynncraftItem[]>>() {}.getType(), new APIV1ItemDB.APIV1ItemDBResponseDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<WynncraftGuild>>() {}.getType(), new APIV1GuildStats.APIV1GuildStatsResponseDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<StatsSearchResult>>() {}.getType(), new APIV1StatsSearch.APIV1StatsSearchResponseDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<WynncraftTerritory[]>>() {}.getType(), new APIV1TerritoryList.APIV1TerritoryResponseDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<WynncraftOnlinePlayerSum>>() {}.getType(), new APIV1OnlinePlayerSum.APIV1OnlinePlayerSumResponseDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<WynncraftMapLocation[]>>() {}.getType(), new APIV1MapLocations.APIV1MapLocationsResponseDeserializer())
            .registerTypeAdapter(new TypeToken<APIResponseV1<WynncraftOnlinePlayers>>() {}.getType(), new APIV1OnlinePlayers.APIV1OnlinePlayersDeserializer())
            .registerTypeAdapter(new TypeToken<HashMap<WynncraftIdentification, WynncraftIngredientIdentificationDetails>>() {}.getType(), new WynncraftIngredient.WynncraftIngredientIdentificationDeserializer())
            .registerTypeAdapter(Date.class, new DateDeserializer())
            .create();
    public static final String VERSION = "0.7.4";
    private static WynncraftAPI INSTANCE;
    private WynncraftAPIConfig config;
    private APIVersion1 v1;
    private APIVersion2 v2;

    public WynncraftAPI() {
        this(new WynncraftAPIConfig());
    }

    public WynncraftAPI(String apiKey) {
        this(new WynncraftAPIConfig(apiKey));
    }

    public WynncraftAPI(WynncraftAPIConfig config) {
        this.config = config;
        this.v1 = new APIVersion1(this);
        this.v2 = new APIVersion2(this);

        WynncraftAPI.INSTANCE = this;
    }

    public static WynncraftAPI getApi() {
        return WynncraftAPI.INSTANCE;
    }

    @Deprecated
    public static int getUnixTimestampSeconds() {
        return (int) (System.currentTimeMillis() / 1000L);
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

    @Override
    public WynncraftAPIConfig getAPIConfig() {
        return config;
    }
}
