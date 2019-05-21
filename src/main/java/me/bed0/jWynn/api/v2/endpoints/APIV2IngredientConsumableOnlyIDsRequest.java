package me.bed0.jWynn.api.v2.endpoints;

import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIResponse;
import me.bed0.jWynn.api.v2.ingredient.WynncraftIngredient;
import me.bed0.jWynn.exceptions.APIRequestException;

import javax.annotation.CheckReturnValue;

public class APIV2IngredientConsumableOnlyIDsRequest extends APIV2IngredientRequest {

    private boolean updateMade = false;

    public APIV2IngredientConsumableOnlyIDsRequest(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @CheckReturnValue
    public APIV2IngredientConsumableOnlyIDsRequest withDuration(int duration) {
        requestURL += "duration%3C" + duration + "%3E,";
        updateMade = true;
        return this;
    }

    @CheckReturnValue
    public APIV2IngredientConsumableOnlyIDsRequest withCharges(int charges) {
        requestURL += "charges%3C" + charges + "%3E,";
        updateMade = true;
        return this;
    }

    @Override
    public APIResponse<WynncraftIngredient[]> runIncludeMeta() {
        if (!updateMade)
            throw new APIRequestException("API V2 Ingredient Consumable Only IDs Search: No properties added to search");
        requestURL = requestURL.substring(0, requestURL.length() - 1);
        return super.runIncludeMeta();
    }
}
