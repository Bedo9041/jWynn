package me.bed0.jWynn.api.v2.player.meta;

import com.google.gson.*;
import me.bed0.jWynn.api.v2.player.PlayerRank;
import me.bed0.jWynn.api.v2.player.PlayerTag;

import java.lang.reflect.Type;

public class WynncraftPlayerMetaTag {

    private boolean display;
    private PlayerTag value;

    public WynncraftPlayerMetaTag(boolean display, PlayerTag value) {
        this.display = display;
        this.value = value;
    }

    public boolean isDisplay() {
        return display;
    }

    public PlayerTag getValue() {
        return value;
    }

    public static class PlayerTagDeserializer implements JsonDeserializer<WynncraftPlayerMetaTag> {
        @Override
        public WynncraftPlayerMetaTag deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            JsonObject object = jsonElement.getAsJsonObject();
            boolean display = object.get("display").getAsBoolean();
            try {
                PlayerTag tag = PlayerTag.valueOf(object.get("value").getAsString().replace("+", "PLUS"));
                return new WynncraftPlayerMetaTag(display, tag);
            } catch (IllegalArgumentException ex) {
                return new WynncraftPlayerMetaTag(display, PlayerTag.OTHER);
            }
        }
    }
}
