package me.bed0.jWynn.api.v2.endpoints;

import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIRequest;
import me.bed0.jWynn.api.APIResponse;
import me.bed0.jWynn.api.v2.APIResponseV2;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV2RecipeList extends APIRequest<String[]> {

    public APIV2RecipeList(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public APIResponse<String[]> runIncludeMeta() {
        return GSON.fromJson(getResponse(), new TypeToken<APIResponseV2<String[]>>() {}.getType());
    }
}
