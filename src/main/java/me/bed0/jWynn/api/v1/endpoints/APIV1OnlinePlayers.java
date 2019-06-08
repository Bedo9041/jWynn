package me.bed0.jWynn.api.v1.endpoints;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIRequest;
import me.bed0.jWynn.api.APIResponse;
import me.bed0.jWynn.api.v1.APIResponseV1;
import me.bed0.jWynn.api.v1.APIResponseV1Request;
import me.bed0.jWynn.api.v1.network.WynncraftOnlinePlayers;
import me.bed0.jWynn.api.v1.network.WynncraftServerOnlinePlayers;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV1OnlinePlayers extends APIRequest<WynncraftOnlinePlayers> {

    public APIV1OnlinePlayers(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public APIResponse<WynncraftOnlinePlayers> runIncludeMeta() {
        return GSON.fromJson(getResponse(), new TypeToken<APIResponseV1<WynncraftOnlinePlayers>>() {}.getType());
    }

    public static class APIV1OnlinePlayersDeserializer implements JsonDeserializer<APIResponseV1<WynncraftOnlinePlayers>> {
        @Override
        public APIResponseV1<WynncraftOnlinePlayers> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject mainObject = jsonElement.getAsJsonObject();
            APIResponseV1Request request = GSON.fromJson(mainObject.get("request"), APIResponseV1Request.class);
            ArrayList<WynncraftServerOnlinePlayers> serverOnlinePlayers = new ArrayList<>();
            for (String element : mainObject.keySet()) {
                if (element.equals("request"))
                    continue;
                String[] onlinePlayers = GSON.fromJson(mainObject.get(element).getAsJsonArray(), String[].class);
                serverOnlinePlayers.add(new WynncraftServerOnlinePlayers(element, onlinePlayers));
            }
            WynncraftServerOnlinePlayers[] array = new WynncraftServerOnlinePlayers[serverOnlinePlayers.size()];
            WynncraftOnlinePlayers data = new WynncraftOnlinePlayers(serverOnlinePlayers.toArray(array));
            return new APIResponseV1<>(request, data);
        }
    }
}
