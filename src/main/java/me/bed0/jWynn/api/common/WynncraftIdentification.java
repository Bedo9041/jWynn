package me.bed0.jWynn.api.common;

public enum WynncraftIdentification {

    AIRDEFENSE("❋ Air Defense", true),
    EARTHDEFENSE("✤ Earth Defense", true),
    FIREDEFENSE("✹ Fire Defense", true),
    WATERDEFENSE("❉ Water Defense", true),
    THUNDERDEFENSE("✦ Thunder Defense", true),
    DAMAGEBONUS("Melee Damage", true),
    DAMAGEBONUSRAW("Melee Damage", false),
    FIREDAMAGEBONUS("✹ Fire Damage", true),
    AIRDAMAGEBONUS("❋ Air Damage", true),
    WATERDAMAGEBONUS("❉ Water Damage", true),
    THUNDERDAMAGEBONUS("✦ Thunder Damage", true),
    EARTHDAMAGEBONUS("✤ Earth Damage", true),
    STRENGTHPOINTS("Strength", false),
    INTELLIGENCEPOINTS("Intelligence", false),
    AGILITYPOINTS("Agility", false),
    DEXTERITYPOINTS("Dexterity", false),
    DEFENSEPOINTS("Defence", false),
    POISON("Poison", false),
    MANASTEAL("Mana Steal", false),
    MANAREGEN("Mana Regen", false),
    SPEED("Walk Speed", true),
    HEALTHBONUS("Health", false),
    SPELLDAMAGE("Spell Damage", true),
    SPELLDAMAGERAW("Spell Damage", false),
    ATTACKSPEED("Attack Speed", false),
    LIFESTEAL("Life Steal", false),
    HEALTHREGEN("Health Regen", true),
    HEALTHREGENRAW("Health Regen", false),
    REFLECTION("Reflection", true),
    THORNS("Thorns", true),
    EXPLODING("Exploding", true),
    LOOTBONUS("Loot Bonus", true),
    XPBONUS("XP Bonus", true),
    EMERALDSTEALING("Stealing", true),
    SOULPOINTS("Soul Point Regen", true),
    LOOT_QUALITY("Loot Quality", true),
    STAMINA_REGEN("Sprint Regen", true);

    private String friendlyName;
    private boolean isPercentage;

    WynncraftIdentification(String friendlyName, boolean isPercentage) {
        this.friendlyName = friendlyName;
        this.isPercentage = isPercentage;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public boolean isPercentage() {
        return isPercentage;
    }

    public String getOptionalPercentage() {
        return isPercentage ? "%" : "";
    }
}
