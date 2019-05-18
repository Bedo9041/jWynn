package me.bed0.jWynn.api.v2.ingredient;

import com.google.gson.*;
import me.bed0.jWynn.api.common.WynncraftIdentification;
import me.bed0.jWynn.api.common.WynncraftProfession;

import java.lang.reflect.Type;
import java.util.HashMap;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class WynncraftIngredient {

    private String name;
    private String displayName;
    private int tier;
    private int level;
    private WynncraftProfession[] skills;
    private WynncraftIngredientSprite sprite;
    private HashMap<WynncraftIdentification, WynncraftIngredientIdentificationDetails> identifications;
    private WynncraftItemOnlyIDs itemOnlyIDs;
    private WynncraftConsumableOnlyIDs consumableOnlyIDs;

    public WynncraftIngredient(String name, String displayName, int tier, int level, WynncraftProfession[] skills, WynncraftIngredientSprite sprite, HashMap<WynncraftIdentification, WynncraftIngredientIdentificationDetails> identifications, WynncraftItemOnlyIDs itemOnlyIDs, WynncraftConsumableOnlyIDs consumableOnlyIDs) {
        this.name = name;
        this.displayName = displayName;
        this.tier = tier;
        this.level = level;
        this.skills = skills;
        this.sprite = sprite;
        this.identifications = identifications;
        this.itemOnlyIDs = itemOnlyIDs;
        this.consumableOnlyIDs = consumableOnlyIDs;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName == null ? name : displayName;
    }

    public boolean hasDefinedDisplayName() {
        return displayName != null;
    }

    public int getTier() {
        return tier;
    }

    public int getLevel() {
        return level;
    }

    public WynncraftProfession[] getSkills() {
        return skills;
    }

    public WynncraftIngredientSprite getSprite() {
        return sprite;
    }

    public HashMap<WynncraftIdentification, WynncraftIngredientIdentificationDetails> getIdentifications() {
        return identifications;
    }

    public WynncraftItemOnlyIDs getItemOnlyIDs() {
        return itemOnlyIDs;
    }

    public WynncraftConsumableOnlyIDs getConsumableOnlyIDs() {
        return consumableOnlyIDs;
    }

    public static class WynncraftIngredientIdentificationDeserializer implements JsonDeserializer<HashMap<WynncraftIdentification, WynncraftIngredientIdentificationDetails>> {
        @Override
        public HashMap<WynncraftIdentification, WynncraftIngredientIdentificationDetails> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            HashMap<WynncraftIdentification, WynncraftIngredientIdentificationDetails> identifications = new HashMap<>();
            JsonObject object = jsonElement.getAsJsonObject();
            for (String key : object.keySet()) {
                WynncraftIdentification identification = WynncraftIdentification.valueOf(key);
                WynncraftIngredientIdentificationDetails details = GSON.fromJson(object.get(key), WynncraftIngredientIdentificationDetails.class);
                details.setIdentification(identification);
                identifications.put(identification, details);
            }
            return identifications;
        }
    }
}
