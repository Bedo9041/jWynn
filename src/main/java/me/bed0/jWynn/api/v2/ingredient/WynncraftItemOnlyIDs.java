package me.bed0.jWynn.api.v2.ingredient;

public class WynncraftItemOnlyIDs {

    private int durabilityModifier;
    private int strenghtRequirement;
    private int dexterityRequirement;
    private int intelligenceRequirement;
    private int defenceRequirement;
    private int agilityRequirement;

    public WynncraftItemOnlyIDs(int durabilityModifier, int strenghtRequirement, int dexterityRequirement, int intelligenceRequirement, int defenceRequirement, int agilityRequirement) {
        this.durabilityModifier = durabilityModifier;
        this.strenghtRequirement = strenghtRequirement;
        this.dexterityRequirement = dexterityRequirement;
        this.intelligenceRequirement = intelligenceRequirement;
        this.defenceRequirement = defenceRequirement;
        this.agilityRequirement = agilityRequirement;
    }

    public int getDurabilityModifier() {
        return durabilityModifier;
    }

    public int getStrenghtRequirement() {
        return strenghtRequirement;
    }

    public int getDexterityRequirement() {
        return dexterityRequirement;
    }

    public int getIntelligenceRequirement() {
        return intelligenceRequirement;
    }

    public int getDefenceRequirement() {
        return defenceRequirement;
    }

    public int getAgilityRequirement() {
        return agilityRequirement;
    }
}
