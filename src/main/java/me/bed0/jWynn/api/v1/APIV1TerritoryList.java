package me.bed0.jWynn.api.v1;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIRequest;
import me.bed0.jWynn.api.APIResponseV1;
import me.bed0.jWynn.api.APIResponseV1Request;
import me.bed0.jWynn.api.v1.territory.WynncraftTerritory;

import java.lang.reflect.Type;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV1TerritoryList extends APIRequest<WynncraftTerritory[]> {

    public APIV1TerritoryList(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public WynncraftTerritory[] run() {
        return runIncludeMeta().getData();
    }

    @Override
    public APIResponseV1<WynncraftTerritory[]> runIncludeMeta() {
        return GSON.fromJson(getReponse(), new TypeToken<APIResponseV1<WynncraftTerritory[]>>() {}.getType());
    }

    public static class APIV1TerritoryResponseDeserializer implements JsonDeserializer<APIResponseV1<WynncraftTerritory[]>> {
        @Override
        public APIResponseV1<WynncraftTerritory[]> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            APIResponseV1Request request = GSON.fromJson(jsonElement.getAsJsonObject().get("request"), APIResponseV1Request.class);
            WynncraftTerritory[] data = GSON.fromJson(jsonElement.getAsJsonObject().get("territories"), WynncraftTerritory[].class);
            return new APIResponseV1<>(request, data);
        }
    }
}
