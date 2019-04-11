package me.bed0.jWynn.api.v2.player;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public enum PlayerRank {

    PLAYER,
    MODERATOR,
    ADMINISTRATOR,
    BUILDER,
    ITEM,
    GAME_MASTER,
    CMD,
    MUSIC,
    HYBRID,
    MEDIA;

    public static class PlayerRankDeserializer implements JsonDeserializer<PlayerRank> {
        @Override
        public PlayerRank deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return PlayerRank.valueOf(jsonElement.getAsString().replace(" ", "_").toUpperCase());
        }
    }
}
