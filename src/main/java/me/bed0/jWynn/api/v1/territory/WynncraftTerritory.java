package me.bed0.jWynn.api.v1.territory;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class WynncraftTerritory {

    private String territory;
    private String guild;
    private Date aquired;
    private String attacker;
    private WynncraftTerritoryLocation location;

    public WynncraftTerritory(String territory, String guild, Date aquired, String attacker, WynncraftTerritoryLocation location) {
        this.territory = territory;
        this.guild = guild;
        this.aquired = aquired;
        this.attacker = attacker;
        this.location = location;
    }

    public String getTerritory() {
        return territory;
    }

    public String getGuild() {
        return guild;
    }

    public Date getAquired() {
        return aquired;
    }

    public String getAttacker() {
        return attacker;
    }

    public WynncraftTerritoryLocation getLocation() {
        return location;
    }

    public static class WynncraftTerritoryListDeserializer implements JsonDeserializer<WynncraftTerritory[]> {
        @Override
        public WynncraftTerritory[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            ArrayList<WynncraftTerritory> territories = new ArrayList<>();
            JsonObject mainObject = jsonElement.getAsJsonObject();
            for (String territory : mainObject.keySet()) {
                territories.add(GSON.fromJson(mainObject.get(territory), WynncraftTerritory.class));
            }
            WynncraftTerritory[] territoryArray = new WynncraftTerritory[territories.size()];
            return territories.toArray(territoryArray);
        }
    }
}
