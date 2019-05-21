package me.bed0.jWynn.api.v2.endpoints;

import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIResponse;
import me.bed0.jWynn.api.common.WynncraftIdentification;
import me.bed0.jWynn.api.v2.ingredient.WynncraftIngredient;
import me.bed0.jWynn.exceptions.APIRequestException;

import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public class APIV2IngredientIdentificationRequest extends APIV2IngredientRequest {

    private boolean updateMade = false;

    public APIV2IngredientIdentificationRequest(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @CheckReturnValue
    public APIV2IngredientIdentificationRequest withIdentification(WynncraftIdentification identification, @Nullable Integer min, @Nullable Integer max) {
        requestURL += identification.name() + "%3C";
        if (min != null) requestURL += min;
        requestURL += ";";
        if (max != null) requestURL += max;
        requestURL += "%3E,";
        updateMade = true;
        return this;
    }

    @Override
    public APIResponse<WynncraftIngredient[]> runIncludeMeta() {
        if (!updateMade)
            throw new APIRequestException("API V2 Ingredient Identification Search: No identifications added to search");
        requestURL = requestURL.substring(0, requestURL.length() - 1);
        return super.runIncludeMeta();
    }
}
