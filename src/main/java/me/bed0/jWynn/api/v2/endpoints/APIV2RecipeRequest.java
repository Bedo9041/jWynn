package me.bed0.jWynn.api.v2.endpoints;

import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIRequest;
import me.bed0.jWynn.api.APIResponse;
import me.bed0.jWynn.api.v2.APIResponseV2;
import me.bed0.jWynn.api.v2.recipe.WynncraftRecipe;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV2RecipeRequest extends APIRequest<WynncraftRecipe[]> {

    public APIV2RecipeRequest(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public APIResponse<WynncraftRecipe[]> runIncludeMeta() {
        return GSON.fromJson(getResponse(), new TypeToken<APIResponseV2<WynncraftRecipe[]>>() {}.getType());
    }
}
