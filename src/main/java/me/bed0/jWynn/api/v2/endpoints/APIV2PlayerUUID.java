package me.bed0.jWynn.api.v2.endpoints;

import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIRequest;
import me.bed0.jWynn.api.APIResponse;
import me.bed0.jWynn.api.v2.APIResponseV2;
import me.bed0.jWynn.api.v2.player.WynncraftPlayerUUID;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV2PlayerUUID extends APIRequest<WynncraftPlayerUUID[]> {

    public APIV2PlayerUUID(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public APIResponse<WynncraftPlayerUUID[]> runIncludeMeta() {
        return GSON.fromJson(getResponse(), new TypeToken<APIResponseV2<WynncraftPlayerUUID[]>>() {}.getType());
    }
}
