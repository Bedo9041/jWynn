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
import me.bed0.jWynn.api.v1.item.WynncraftItem;

import java.lang.reflect.Type;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV1ItemDB extends APIRequest<WynncraftItem[]> {

    public APIV1ItemDB(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public WynncraftItem[] run() {
        return runIncludeMeta().getData();
    }

    @Override
    public APIResponse<WynncraftItem[]> runIncludeMeta() {
        return GSON.fromJson(getResponse(), new TypeToken<APIResponseV1<WynncraftItem[]>>() {}.getType());
    }

    public static class APIV1ItemDBResponseDeserializer implements JsonDeserializer<APIResponseV1<WynncraftItem[]>> {
        @Override
        public APIResponseV1<WynncraftItem[]> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            APIResponseV1Request request = GSON.fromJson(jsonElement.getAsJsonObject().get("request"), APIResponseV1Request.class);
            WynncraftItem[] data = GSON.fromJson(jsonElement.getAsJsonObject().get("items").getAsJsonArray(), WynncraftItem[].class);
            return new APIResponseV1<>(request, data);
        }
    }
}
