package me.bed0.jWynn.api.v1.endpoints;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIRequest;
import me.bed0.jWynn.api.APIResponse;
import me.bed0.jWynn.api.v1.APIResponseV1;
import me.bed0.jWynn.api.v1.APIResponseV1Request;
import me.bed0.jWynn.api.v1.network.WynncraftOnlinePlayerSum;

import java.lang.reflect.Type;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV1OnlinePlayerSum extends APIRequest<WynncraftOnlinePlayerSum> {

    public APIV1OnlinePlayerSum(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public APIResponse<WynncraftOnlinePlayerSum> runIncludeMeta() {
        return GSON.fromJson(getResponse(), new TypeToken<APIResponseV1<WynncraftOnlinePlayerSum>>() {}.getType());
    }

    public static class APIV1OnlinePlayerSumResponseDeserializer implements JsonDeserializer<APIResponseV1<WynncraftOnlinePlayerSum>> {
        @Override
        public APIResponseV1<WynncraftOnlinePlayerSum> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            APIResponseV1Request request = GSON.fromJson(jsonElement.getAsJsonObject().get("request"), APIResponseV1Request.class);
            WynncraftOnlinePlayerSum data = GSON.fromJson(jsonElement, WynncraftOnlinePlayerSum.class);
            return new APIResponseV1<>(request, data);
        }
    }
}
