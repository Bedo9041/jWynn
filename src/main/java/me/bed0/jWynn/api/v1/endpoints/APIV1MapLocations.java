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
import me.bed0.jWynn.api.v1.map.WynncraftMapLocation;

import java.lang.reflect.Type;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV1MapLocations extends APIRequest<WynncraftMapLocation[]> {

    public APIV1MapLocations(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public APIResponse<WynncraftMapLocation[]> runIncludeMeta() {
        return GSON.fromJson(getResponse(), new TypeToken<APIResponseV1<WynncraftMapLocation[]>>() {}.getType());
    }

    public static class APIV1MapLocationsResponseDeserializer implements JsonDeserializer<APIResponseV1<WynncraftMapLocation[]>> {
        @Override
        public APIResponseV1<WynncraftMapLocation[]> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            APIResponseV1Request request = GSON.fromJson(jsonElement.getAsJsonObject().get("request"), APIResponseV1Request.class);
            WynncraftMapLocation[] data = GSON.fromJson(jsonElement.getAsJsonObject().get("locations").getAsJsonArray(), WynncraftMapLocation[].class);
            return new APIResponseV1<>(request, data);
        }
    }
}
