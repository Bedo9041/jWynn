package me.bed0.jWynn.api.v2.routes;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.common.WynncraftProfession;
import me.bed0.jWynn.api.v2.endpoints.APIV2RecipeMinimumMaximumRequest;
import me.bed0.jWynn.api.v2.endpoints.APIV2RecipeRequest;
import me.bed0.jWynn.api.v2.recipe.WynncraftRecipeType;

import javax.annotation.CheckReturnValue;

public class APIV2RecipeSearch {

    private APIMidpoint midpoint;
    private WynncraftAPI api;

    APIV2RecipeSearch(APIMidpoint midpoint, WynncraftAPI api) {
        this.midpoint = midpoint;
        this.api = api;
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest durationOr() {
        return new APIV2RecipeMinimumMaximumRequest(api.getConfig().getBaseURL() + "v2/recipe/search/duration/%5E", midpoint);
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest durationAnd() {
        return new APIV2RecipeMinimumMaximumRequest(api.getConfig().getBaseURL() + "v2/recipe/search/duration/&", midpoint);
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest levelOr() {
        return new APIV2RecipeMinimumMaximumRequest(api.getConfig().getBaseURL() + "v2/recipe/search/level/%5E", midpoint);
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest levelAnd() {
        return new APIV2RecipeMinimumMaximumRequest(api.getConfig().getBaseURL() + "v2/recipe/search/level/&", midpoint);
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest durabilityOr() {
        return new APIV2RecipeMinimumMaximumRequest(api.getConfig().getBaseURL() + "v2/recipe/search/durability/%5E", midpoint);
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest durabilityAnd() {
        return new APIV2RecipeMinimumMaximumRequest(api.getConfig().getBaseURL() + "v2/recipe/search/durability/&", midpoint);
    }

    @CheckReturnValue
    public APIV2RecipeRequest type(WynncraftRecipeType type) {
        return new APIV2RecipeRequest(api.getConfig().getBaseURL() + "v2/recipe/search/type/" + type.name(), midpoint);
    }

    @CheckReturnValue
    public APIV2RecipeRequest profession(WynncraftProfession skill) {
        return new APIV2RecipeRequest(api.getConfig().getBaseURL() + "v2/recipe/search/skill/" + skill.name(), midpoint);
    }
}
