package me.bed0.jWynn.api.v2.player;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.awt.*;
import java.lang.reflect.Type;

public enum PlayerRank {

    PLAYER("Player", new Color(0, 0, 0)),
    MODERATOR("Moderator", new Color(249, 199, 0)),
    ADMINISTRATOR("Administrator", new Color(201, 31, 18)),
    BUILDER("Builder", new Color(0, 170, 170)),
    ITEM("Item Team", new Color(0, 170, 170)),
    GAME_MASTER("Game Master", new Color(0, 170, 170)),
    CMD("CMD", new Color(0, 170, 170)),
    MUSIC("Music", new Color(0, 170, 170)),
    HYBRID("Hybrid", new Color(0, 170, 170)),
    MEDIA("Media", new Color(64, 0, 212)),
    ART("Art", new Color(0, 170, 170)),
    OTHER("Other", new Color(0, 0, 0));

    private String friendlyName;
    private Color color;

    PlayerRank(String friendlyName, Color color) {
        this.friendlyName = friendlyName;
        this.color = color;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public Color getColor() {
        return color;
    }

    public static class PlayerRankDeserializer implements JsonDeserializer<PlayerRank> {
        @Override
        public PlayerRank deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            try {
                return PlayerRank.valueOf(jsonElement.getAsString().replace(" ", "_").toUpperCase());
            } catch (IllegalArgumentException ex) {
                return PlayerRank.OTHER;
            }
        }
    }
}
