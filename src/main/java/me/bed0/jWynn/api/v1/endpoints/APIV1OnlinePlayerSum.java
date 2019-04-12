package me.bed0.jWynn.api.v1.endpoints;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.*;
import me.bed0.jWynn.api.v1.APIResponseV1;
import me.bed0.jWynn.api.v1.APIResponseV1Request;
import me.bed0.jWynn.api.v1.network.OnlinePlayerSum;

import java.lang.reflect.Type;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV1OnlinePlayerSum extends APIRequest<OnlinePlayerSum> {

    public APIV1OnlinePlayerSum(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public OnlinePlayerSum run() {
        return runIncludeMeta().getData();
    }

    @Override
    public APIResponse<OnlinePlayerSum> runIncludeMeta() {
        return GSON.fromJson(getReponse(), new TypeToken<APIResponseV1<OnlinePlayerSum>>() {}.getType());
    }

    public static class APIV1OnlinePlayerSumResponseDeserializer implements JsonDeserializer<APIResponseV1<OnlinePlayerSum>> {
        @Override
        public APIResponseV1<OnlinePlayerSum> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            APIResponseV1Request request = GSON.fromJson(jsonElement.getAsJsonObject().get("request"), APIResponseV1Request.class);
            OnlinePlayerSum data = GSON.fromJson(jsonElement, OnlinePlayerSum.class);
            return new APIResponseV1<>(request, data);
        }
    }
}
