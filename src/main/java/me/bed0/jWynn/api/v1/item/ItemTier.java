package me.bed0.jWynn.api.v1.item;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public enum ItemTier {

    NORMAL,
    SET,
    UNIQUE,
    RARE,
    LEGENDARY,
    FABLED,
    MYTHIC;

    public static class ItemTierDeserializer implements JsonDeserializer<ItemTier> {
        @Override
        public ItemTier deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return ItemTier.valueOf(jsonElement.getAsString().toUpperCase());
        }
    }
}
