package me.bed0.jWynn.api.v2;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.v2.routes.APIV2Ingredient;
import me.bed0.jWynn.api.v2.routes.APIV2Player;
import me.bed0.jWynn.api.v2.routes.APIV2Recipe;

import javax.annotation.CheckReturnValue;

public class APIVersion2 {

    private WynncraftAPI api;
    private APIV2Player player;
    private APIV2Ingredient ingredient;
    private APIV2Recipe recipe;

    public APIVersion2(WynncraftAPI api) {
        this.api = api;
        player = new APIV2Player(api);
        ingredient = new APIV2Ingredient(api);
        recipe = new APIV2Recipe(api);
    }

    @CheckReturnValue
    public APIV2Player player() {
        return player;
    }

    @CheckReturnValue
    public APIV2Ingredient ingredient() {
        return ingredient;
    }

    @CheckReturnValue
    public APIV2Recipe recipe() {
        return recipe;
    }
}
