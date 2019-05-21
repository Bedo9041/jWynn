package me.bed0.jWynn.api.v2.endpoints;

import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIResponse;
import me.bed0.jWynn.api.v2.ingredient.WynncraftIngredient;
import me.bed0.jWynn.exceptions.APIRequestException;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public class APIV2IngredientSpriteRequest extends APIV2IngredientRequest {

    private boolean updateMade = false;

    public APIV2IngredientSpriteRequest(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @CheckReturnValue
    public APIV2IngredientSpriteRequest withDamage(int damage) {
        requestURL += "damage%3C" + damage + "%3E,";
        updateMade = true;
        return this;
    }

    @CheckReturnValue
    public APIV2IngredientSpriteRequest withId(int id) {
        requestURL += "id%3C" + id + "%3E,";
        updateMade = true;
        return this;
    }

    @Override
    public APIResponse<WynncraftIngredient[]> runIncludeMeta() {
        if (!updateMade)
            throw new APIRequestException("API V2 Ingredient Sprite Search: No sprites added to search");
        requestURL = requestURL.substring(0, requestURL.length() - 1);
        return super.runIncludeMeta();
    }
}
