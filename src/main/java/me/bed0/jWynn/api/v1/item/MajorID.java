package me.bed0.jWynn.api.v1.item;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public enum MajorID {

    PLAGUE("Plague", "Poisoned mobs also poison nearby mobs"),
    HAWKEYE("Hawkeye", "Arrow storm fires 5 powerful arrows"),
    GREED("Greed", "Picking up emeralds heals you and nearby players for 20% max health"),
    CAVALRYMAN("Cavalryman", "Can attack mobs while riding a horse"),
    GUARDIAN("Guardian", "50% of the damage taken by players nearby are redirected to you"),
    ALTRUISM("Heart of the Pack", "Nearby players gain 30% of the health you naturally regenerate"),
    HERO("Saviour's Sacrifice", "While under 25% maximum health, nearby allies gain 30% bonus damage and defense"),
    ARCANES("Transcendence", "50% chance for spells to cost no mana when casted"),
    ENTROPY("Entropy", "Meteor falls significantly faster"),
    ROVINGASSASSIN("Roving Assassin", "Vanish no longer drains mana while invisible"),
    MAGNET("Magnet", "Pull every items on the ground nearby"),
    MADNESS("Madness", "Cast a random ability every 10s"),
    LIGHTWEIGHT("Lightweight", "Removes fall damage"),
    SORCERY("Sorcery", "Spells may cast a second time at no additional cost"),
    TAUNT("Taunt", "War Scream makes nearby mobs target you");

    String friendlyName;
    String description;

    MajorID(String friendlyName, String description) {
        this.friendlyName = friendlyName;
        this.description = description;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public String getDescription() {
        return description;
    }

    public static class MajorIDDeserializer implements JsonDeserializer<MajorID> {
        @Override
        public MajorID deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return MajorID.valueOf(jsonElement.getAsString().toUpperCase());
        }
    }
}
