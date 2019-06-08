package me.bed0.jWynn.api.v2.endpoints;

import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIResponse;
import me.bed0.jWynn.api.v2.recipe.WynncraftRecipe;
import me.bed0.jWynn.exceptions.APIRequestException;

import javax.annotation.CheckReturnValue;

public class APIV2RecipeMinimumMaximumRequest extends APIV2RecipeRequest {

    private boolean updateMade = false;

    public APIV2RecipeMinimumMaximumRequest(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest withMinimum(int minimum) {
        requestURL += "min%3C" + minimum + "%3E,";
        updateMade = true;
        return this;
    }

    @CheckReturnValue
    public APIV2RecipeMinimumMaximumRequest withMaximum(int maximum) {
        requestURL += "max%3C" + maximum + "%3E,";
        updateMade = true;
        return this;
    }

    @Override
    public APIResponse<WynncraftRecipe[]> runIncludeMeta() {
        if (!updateMade)
            throw new APIRequestException("API V2 Recipe Search: No properties added to search");
        requestURL = requestURL.substring(0, requestURL.length() - 1);
        return super.runIncludeMeta();
    }
}
