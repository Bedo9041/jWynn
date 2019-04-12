package me.bed0.jWynn.api.v1.endpoints;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.*;
import me.bed0.jWynn.api.v1.APIResponseV1;
import me.bed0.jWynn.api.v1.APIResponseV1Request;
import me.bed0.jWynn.api.v1.network.OnlinePlayers;
import me.bed0.jWynn.api.v1.network.ServerOnlinePlayers;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV1OnlinePlayers extends APIRequest<OnlinePlayers> {

    public APIV1OnlinePlayers(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public OnlinePlayers run() {
        return runIncludeMeta().getData();
    }

    @Override
    public APIResponse<OnlinePlayers> runIncludeMeta() {
        return GSON.fromJson(getReponse(), new TypeToken<APIResponseV1<OnlinePlayers>>() {}.getType());
    }

    public static class APIV1OnlinePlayersDeserializer implements JsonDeserializer<APIResponseV1<OnlinePlayers>> {
        @Override
        public APIResponseV1<OnlinePlayers> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            APIResponseV1Request request = GSON.fromJson(jsonElement.getAsJsonObject().get("request"), APIResponseV1Request.class);
            JsonObject mainObject = jsonElement.getAsJsonObject();
            ArrayList<ServerOnlinePlayers> serverOnlinePlayers = new ArrayList<>();
            for (String element : mainObject.keySet()) {
                if (element.equals("request"))
                    continue;
                String[] onlinePlayers = GSON.fromJson(mainObject.get("element").getAsJsonArray(), String[].class);
                serverOnlinePlayers.add(new ServerOnlinePlayers(element, onlinePlayers));
            }
            ServerOnlinePlayers[] array = new ServerOnlinePlayers[serverOnlinePlayers.size()];
            OnlinePlayers data = new OnlinePlayers(serverOnlinePlayers.toArray(array));
            return new APIResponseV1<>(request, data);
        }
    }
}
