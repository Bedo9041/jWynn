package me.bed0.jWynn.api.v2.routes;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.common.WynncraftIdentification;
import me.bed0.jWynn.api.common.WynncraftProfession;
import me.bed0.jWynn.api.v2.endpoints.APIV2IngredientRequest;

import javax.annotation.CheckReturnValue;

public class APIV2IngredientSearch {

    private APIMidpoint midpoint;
    private WynncraftAPI api;

    APIV2IngredientSearch(APIMidpoint midpoint, WynncraftAPI api) {
        this.midpoint = midpoint;
        this.api = api;
    }

    @CheckReturnValue
    public APIV2IngredientRequest professionsOr(WynncraftProfession... professions) {
        StringBuilder builder = new StringBuilder("v2/ingredient/search/skills/%5E");
        for (WynncraftProfession profession : professions) {
            builder.append(profession).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        return new APIV2IngredientRequest(api.getConfig().getBaseURL() + builder.toString(), midpoint);
    }

    @CheckReturnValue
    public APIV2IngredientRequest professionsAnd(WynncraftProfession... professions) {
        StringBuilder builder = new StringBuilder("v2/ingredient/search/skills/&");
        for (WynncraftProfession profession : professions) {
            builder.append(profession).append(",");
        }
        builder.deleteCharAt(builder.length() - 1);
        return new APIV2IngredientRequest(api.getConfig().getBaseURL() + builder.toString(), midpoint);
    }

    @CheckReturnValue
    public APIV2IngredientRequest identificationsOr(WynncraftIdentification... identifications) {
        StringBuilder builder = new StringBuilder("v2/ingredient/search/identifications/%5E");
        for (WynncraftIdentification identification : identifications) {
            builder.append(identification).append("%3C;%3E,");
        }
        builder.deleteCharAt(builder.length() - 1);
        return new APIV2IngredientRequest(api.getConfig().getBaseURL() + builder.toString(), midpoint);
    }

    @CheckReturnValue
    public APIV2IngredientRequest identificationsAnd(WynncraftIdentification... identifications) {
        StringBuilder builder = new StringBuilder("v2/ingredient/search/identifications/&");
        for (WynncraftIdentification identification : identifications) {
            builder.append(identification).append("%3C;%3E,");
        }
        builder.deleteCharAt(builder.length() - 1);
        return new APIV2IngredientRequest(api.getConfig().getBaseURL() + builder.toString(), midpoint);
    }
}
