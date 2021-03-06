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
import me.bed0.jWynn.api.v1.guild.WynncraftGuild;

import java.lang.reflect.Type;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV1GuildStats extends APIRequest<WynncraftGuild> {

    public APIV1GuildStats(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public APIResponse<WynncraftGuild> runIncludeMeta() {
        return GSON.fromJson(getResponse(), new TypeToken<APIResponseV1<WynncraftGuild>>() {}.getType());
    }

    public static class APIV1GuildStatsResponseDeserializer implements JsonDeserializer<APIResponseV1<WynncraftGuild>> {
        @Override
        public APIResponseV1<WynncraftGuild> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            APIResponseV1Request request = GSON.fromJson(jsonElement.getAsJsonObject().get("request"), APIResponseV1Request.class);
            WynncraftGuild data = GSON.fromJson(jsonElement, WynncraftGuild.class);
            return new APIResponseV1<>(request, data);
        }
    }
}
