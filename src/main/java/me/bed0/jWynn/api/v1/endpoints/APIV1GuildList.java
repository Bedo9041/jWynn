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
import me.bed0.jWynn.api.v1.guild.GuildList;

import java.lang.reflect.Type;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV1GuildList extends APIRequest<GuildList> {

    public APIV1GuildList(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public GuildList run() {
        return runIncludeMeta().getData();
    }

    @Override
    public APIResponse<GuildList> runIncludeMeta() {
        return GSON.fromJson(getResponse(), new TypeToken<APIResponseV1<GuildList>>() {}.getType());
    }

    public static class APIV1GuildListResponseDeserializer implements JsonDeserializer<APIResponseV1<GuildList>> {
        @Override
        public APIResponseV1<GuildList> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            APIResponseV1Request request = GSON.fromJson(jsonElement.getAsJsonObject().get("request"), APIResponseV1Request.class);
            String[] list = GSON.fromJson(jsonElement.getAsJsonObject().get("guilds"), String[].class);
            GuildList data = new GuildList(list);
            return new APIResponseV1<>(request, data);
        }
    }
}
