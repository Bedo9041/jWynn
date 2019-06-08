package me.bed0.jWynn.api.v2.recipe;

import me.bed0.jWynn.api.common.WynncraftProfession;

public class WynncraftRecipe {

    private WynncraftRecipeMinimumMaximum level;
    private WynncraftRecipeType type;
    private WynncraftProfession skill;
    private WynncraftRecipeMaterial[] materials;
    private WynncraftRecipeMinimumMaximum healthOrDamage;
    private WynncraftRecipeMinimumMaximum durability;
    private String id;

    public WynncraftRecipe(WynncraftRecipeMinimumMaximum level, WynncraftRecipeType type, WynncraftProfession skill, WynncraftRecipeMaterial[] materials, WynncraftRecipeMinimumMaximum healthOrDamage, WynncraftRecipeMinimumMaximum durability, String id) {
        this.level = level;
        this.type = type;
        this.skill = skill;
        this.materials = materials;
        this.healthOrDamage = healthOrDamage;
        this.durability = durability;
        this.id = id;
    }

    public WynncraftRecipeMinimumMaximum getLevel() {
        return level;
    }

    public WynncraftRecipeType getType() {
        return type;
    }

    public WynncraftProfession getSkill() {
        return skill;
    }

    public WynncraftRecipeMaterial[] getMaterials() {
        return materials;
    }

    public WynncraftRecipeMinimumMaximum getHealthOrDamage() {
        return healthOrDamage;
    }

    public WynncraftRecipeMinimumMaximum getDurability() {
        return durability;
    }

    public String getId() {
        return id;
    }
}
