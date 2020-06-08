package me.bed0.jWynn;

import jdk.nashorn.internal.ir.annotations.Ignore;
import me.bed0.jWynn.api.common.WynncraftProfession;
import me.bed0.jWynn.api.v1.item.ItemCategory;
import me.bed0.jWynn.exceptions.APIConnectionException;
import me.bed0.jWynn.exceptions.APIResponseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class jWynnTests {

    private static WynncraftAPI api = new WynncraftAPI();

    @Test
    void exceptionThrownWhenAPIDown() {
        assertThrows(APIConnectionException.class, () -> api.v1().guildStats("Imperial").toURL("aokegfjkjiadvfjidasnjvsnvjuiqebvhuirqnevjuibqnrecn.com").run());
    }

    @Test
    void exceptionThrownWhenNotJSON() {
        assertThrows(APIResponseException.class, () -> api.v1().guildStats("Imperial").toURL("https://example.com").run());
    }

    @Test
    void v1GuildStatsSuccessful() {
        api.v1().guildStats("Imperial").run();
    }

    @Test
    void v1GuildListSuccessful() {
        api.v1().guildList().run();
    }

    @Test
    void v1GuildLeaderboardSuccessful() {
        api.v1().guildLeaderboard().run();
    }

    @Test
    void v1ItemDBSuccessful() {
        api.v1().itemDBByCategory(ItemCategory.BOOTS).run();
    }

    @Test
    void v1MapLocationsSuccessful() {
        api.v1().mapLocations().run();
    }

    @Test
    void v1OnlinePlayersSuccessful() {
        api.v1().onlinePlayers().run();
    }

    @Test
    void v1OnlinePlayerSumSuccessful() {
        api.v1().onlinePlayerSum().run();
    }

    @Test
    void v1PlayerLeaderboardSuccessful() {
        api.v1().playerLeaderboard().run();
    }

    @Ignore
    @Test
    void v1StatsSearchSuccessful() {
        api.v1().statsSearch("Test").run();
    }

    @Test
    void v1TerritoryListSuccessful() {
        api.v1().territoryList().run();
    }

    @Test
    void v2IngredientListSuccessful() {
        api.v2().ingredient().list().run();
    }

    @Test
    void v2IngredientRequestSuccessful() {
        api.v2().ingredient().get("Accursed Effigy").run();
    }

    @Test
    void v2IngredientSearchSuccessful() {
        api.v2().ingredient().search().name("Test").run();
    }

    @Test
    void v2PlayerStatsSuccessful() {
        api.v2().player().statsUUID("5aa0ae01-8c1b-4e0a-b31b-825389a7cb7b").run();
    }

    @Test
    void v2RecipeListSuccessful() {
        api.v2().recipe().list().run();
    }

    @Test
    void v2RecipeSearchSuccessful() {
        api.v2().recipe().search().profession(WynncraftProfession.ALCHEMISM).run();
    }

    @Test
    void v2RecipeSuccessful() {
        api.v2().recipe().get("Boots-1-3").run();
    }
}
