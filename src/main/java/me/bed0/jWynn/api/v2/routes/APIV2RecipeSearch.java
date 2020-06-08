package me.bed0.jWynn.api.v2.routes;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.common.WynncraftProfession;
import me.bed0.jWynn.api.v2.endpoints.APIV2RecipeMinimumMaximumRequest;
import me.bed0.jWynn.api.v2.endpoints.APIV2RecipeRequest;
import me.bed0.jWynn.api.v2.recipe.WynncraftRecipeType;

import javax.annotation.CheckReturnValue;

public class APIV2RecipeSearch {

    private WynncraftAPI api;

    APIV2RecipeSearch(WynncraftAPI api) {
        this.api = api;
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest durationOr() {
        return new APIV2RecipeMinimumMaximumRequest(api.getConfig().getBaseURL() + "v2/recipe/search/duration/%5E", api);
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest durationAnd() {
        return new APIV2RecipeMinimumMaximumRequest(api.getConfig().getBaseURL() + "v2/recipe/search/duration/&", api);
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest levelOr() {
        return new APIV2RecipeMinimumMaximumRequest(api.getConfig().getBaseURL() + "v2/recipe/search/level/%5E", api);
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest levelAnd() {
        return new APIV2RecipeMinimumMaximumRequest(api.getConfig().getBaseURL() + "v2/recipe/search/level/&", api);
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest durabilityOr() {
        return new APIV2RecipeMinimumMaximumRequest(api.getConfig().getBaseURL() + "v2/recipe/search/durability/%5E", api);
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest durabilityAnd() {
        return new APIV2RecipeMinimumMaximumRequest(api.getConfig().getBaseURL() + "v2/recipe/search/durability/&", api);
    }

    @CheckReturnValue
    public APIV2RecipeRequest type(WynncraftRecipeType type) {
        return new APIV2RecipeRequest(api.getConfig().getBaseURL() + "v2/recipe/search/type/" + type.name(), api);
    }

    @CheckReturnValue
    public APIV2RecipeRequest profession(WynncraftProfession skill) {
        return new APIV2RecipeRequest(api.getConfig().getBaseURL() + "v2/recipe/search/skill/" + skill.name(), api);
    }
}
