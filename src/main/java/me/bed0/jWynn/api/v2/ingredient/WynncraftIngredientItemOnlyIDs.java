package me.bed0.jWynn.api.v2.ingredient;

public class WynncraftIngredientItemOnlyIDs {

    private float durabilityModifier;
    private float strengthRequirement;
    private float dexterityRequirement;
    private float intelligenceRequirement;
    private float defenceRequirement;
    private float agilityRequirement;

    public WynncraftIngredientItemOnlyIDs(float durabilityModifier, float strengthRequirement, float dexterityRequirement, float intelligenceRequirement, float defenceRequirement, float agilityRequirement) {
        this.durabilityModifier = durabilityModifier;
        this.strengthRequirement = strengthRequirement;
        this.dexterityRequirement = dexterityRequirement;
        this.intelligenceRequirement = intelligenceRequirement;
        this.defenceRequirement = defenceRequirement;
        this.agilityRequirement = agilityRequirement;
    }

    public float getDurabilityModifier() {
        return durabilityModifier;
    }

    public float getStrengthRequirement() {
        return strengthRequirement;
    }

    public float getDexterityRequirement() {
        return dexterityRequirement;
    }

    public float getIntelligenceRequirement() {
        return intelligenceRequirement;
    }

    public float getDefenceRequirement() {
        return defenceRequirement;
    }

    public float getAgilityRequirement() {
        return agilityRequirement;
    }
}
