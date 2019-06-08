package me.bed0.jWynn.api.v2.routes;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.v2.endpoints.APIV2RecipeList;
import me.bed0.jWynn.api.v2.endpoints.APIV2RecipeRequest;
import me.bed0.jWynn.config.WynncraftAPIConfig;
import me.bed0.jWynn.exceptions.APIRequestException;

import javax.annotation.CheckReturnValue;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class APIV2Recipe extends APIMidpoint {

    private WynncraftAPI api;

    private APIV2RecipeSearch search;

    public APIV2Recipe(WynncraftAPI api) {
        this.api = api;
        this.search = new APIV2RecipeSearch(this, api);
    }

    @Override
    public WynncraftAPIConfig getAPIConfig() {
        return api.getConfig();
    }

    @CheckReturnValue
    public APIV2RecipeRequest get(String recipe) {
        try {
            return new APIV2RecipeRequest(api.getConfig().getBaseURL() + "v2/recipe/get/" + URLEncoder.encode(recipe.replace(' ', '_'), "UTF-8"), this);
        } catch (UnsupportedEncodingException ex) {
            throw new APIRequestException(ex);
        }
    }

    @CheckReturnValue
    public APIV2RecipeList list() {
        return new APIV2RecipeList("v2/recipe/list", this);
    }

    @CheckReturnValue
    public APIV2RecipeSearch search() {
        return search;
    }
}
