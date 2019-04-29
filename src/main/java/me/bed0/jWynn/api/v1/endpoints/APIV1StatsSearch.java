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
import me.bed0.jWynn.api.v1.search.StatsSearchResult;

import java.lang.reflect.Type;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV1StatsSearch extends APIRequest<StatsSearchResult> {

    public APIV1StatsSearch(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public StatsSearchResult run() {
        return runIncludeMeta().getData();
    }

    @Override
    public APIResponse<StatsSearchResult> runIncludeMeta() {
        return GSON.fromJson(getResponse(), new TypeToken<APIResponseV1<StatsSearchResult>>() {}.getType());
    }

    public static class APIV1StatsSearchResponseDeserializer implements JsonDeserializer<APIResponseV1<StatsSearchResult>> {
        @Override
        public APIResponseV1<StatsSearchResult> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            APIResponseV1Request request = GSON.fromJson(jsonElement.getAsJsonObject().get("request"), APIResponseV1Request.class);
            String[] guilds = GSON.fromJson(jsonElement.getAsJsonObject().get("guilds"), String[].class);
            String[] players = GSON.fromJson(jsonElement.getAsJsonObject().get("players"), String[].class);
            StatsSearchResult data = new StatsSearchResult(guilds, players);
            return new APIResponseV1<>(request, data);
        }
    }
}
