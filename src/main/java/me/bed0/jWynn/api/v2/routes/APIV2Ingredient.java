package me.bed0.jWynn.api.v2.routes;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.v2.endpoints.APIV2IngredientRequest;
import me.bed0.jWynn.config.WynncraftAPIConfig;
import me.bed0.jWynn.exceptions.APIRequestException;

import javax.annotation.CheckReturnValue;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class APIV2Ingredient extends APIMidpoint {

    private WynncraftAPI api;

    private APIV2IngredientSearch search;

    public APIV2Ingredient(WynncraftAPI api) {
        this.api = api;
        this.search = new APIV2IngredientSearch(this, api);
    }

    @Override
    public WynncraftAPIConfig getAPIConfig() {
        return api.getConfig();
    }

    @CheckReturnValue
    public APIV2IngredientRequest get(String ingredient) {
        try {
            return new APIV2IngredientRequest(api.getConfig().getBaseURL() + "v2/ingredient/get/" + URLEncoder.encode(ingredient.replace(' ', '_'), "UTF-8"), this);
        } catch (UnsupportedEncodingException ex) {
            throw new APIRequestException(ex);
        }
    }

    @CheckReturnValue
    public APIV2IngredientSearch search() {
        return search;
    }

    @CheckReturnValue
    public APIV2IngredientRequest list() {
        return new APIV2IngredientRequest(api.getConfig().getBaseURL() + "v2/ingredient/list", this);
    }
}
