package me.bed0.jWynn.api.v2.endpoints;

import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIResponse;
import me.bed0.jWynn.api.v2.ingredient.WynncraftIngredient;
import me.bed0.jWynn.exceptions.APIRequestException;

import javax.annotation.CheckReturnValue;

public class APIV2IngredientItemOnlyIDsRequest extends APIV2IngredientRequest {

    private boolean updateMade = false;

    public APIV2IngredientItemOnlyIDsRequest(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @CheckReturnValue
    public APIV2IngredientItemOnlyIDsRequest withDurability(int durability) {
        requestURL += "durability%3C" + durability + "%3E,";
        updateMade = true;
        return this;
    }

    @CheckReturnValue
    public APIV2IngredientItemOnlyIDsRequest withStrength(int strength) {
        requestURL += "strength%3C" + strength + "%3E,";
        updateMade = true;
        return this;
    }

    @CheckReturnValue
    public APIV2IngredientItemOnlyIDsRequest withDexterity(int dexterity) {
        requestURL += "dexterity%3C" + dexterity + "%3E,";
        updateMade = true;
        return this;
    }

    @CheckReturnValue
    public APIV2IngredientItemOnlyIDsRequest withIntelligence(int intelligence) {
        requestURL += "intelligence%3C" + intelligence + "%3E,";
        updateMade = true;
        return this;
    }

    @CheckReturnValue
    public APIV2IngredientItemOnlyIDsRequest withDefence(int defence) {
        requestURL += "defence%3C" + defence + "%3E,";
        updateMade = true;
        return this;
    }

    @CheckReturnValue
    public APIV2IngredientItemOnlyIDsRequest withAgility(int agility) {
        requestURL += "agility%3C" + agility + "%3E,";
        updateMade = true;
        return this;
    }

    @Override
    public APIResponse<WynncraftIngredient[]> runIncludeMeta() {
        if (!updateMade)
            throw new APIRequestException("API V2 Ingredient Item Only IDs Search: No properties added to search");
        requestURL = requestURL.substring(0, requestURL.length() - 1);
        return super.runIncludeMeta();
    }
}
