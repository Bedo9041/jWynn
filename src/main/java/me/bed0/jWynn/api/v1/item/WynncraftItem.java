package me.bed0.jWynn.api.v1.item;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.awt.*;
import java.lang.reflect.Type;

public class WynncraftItem {

    private String name;
    private ItemTier tier;
    private int sockets;
    private Color armorColor;
    private String armorType;
    private String addedLore;
    private String type;
    private String set;
    private String material;
    private String dropType;
    private String restrictions;
    private String damage;
    private String fireDamage;
    private String waterDamage;
    private String airDamage;
    private String thunderDamage;
    private String earthDamage;
    private String attackSpeed;
    private int level;
    private String quest;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int agility;
    private int defense;
    private int healthRegen;
    private int manaRegen;
    private int spellDamage;
    private int damageBonus;
    private int lifeSteal;
    private int manaSteal;
    private int xpBonus;
    private int lootBonus;
    private int reflection;
    private int strengthPoints;
    private int dexterityPoints;
    private int intelligencePoints;
    private int agilityPoints;
    private int defensePoints;
    private int thorns;
    private int exploding;
    private int speed;
    private int attackSpeedBonus;
    private int poison;
    private int healthBonus;
    private int soulPoints;
    private int emeraldStealing;
    private int healthRegenRaw;
    private int spellDamageRaw;
    private int damageBonusRaw;
    private int bonusFireDamage;
    private int bonusWaterDamage;
    private int bonusAirDamage;
    private int bonusThunderDamage;
    private int bonusEarthDamage;
    private int bonusFireDefense;
    private int bonusWaterDefense;
    private int bonusAirDefense;
    private int bonusThunderDefense;
    private int bonusEarthDefense;
    private String category;
    private int fireDefense;
    private int waterDefense;
    private int airDefense;
    private int thunderDefense;
    private int earthDefense;
    private int health;
    private String accessoryType;
    private String classRequirement;
    private boolean identified = false;
    private String displayName;
    private String skin;

    public WynncraftItem(String name, ItemTier tier, int sockets, Color armorColor, String armorType, String addedLore, String type, String set, String material, String dropType, String restrictions, String damage, String fireDamage, String waterDamage, String airDamage, String thunderDamage, String earthDamage, String attackSpeed, int level, String quest, int strength, int dexterity, int intelligence, int agility, int defense, int healthRegen, int manaRegen, int spellDamage, int damageBonus, int lifeSteal, int manaSteal, int xpBonus, int lootBonus, int reflection, int strengthPoints, int dexterityPoints, int intelligencePoints, int agilityPoints, int defensePoints, int thorns, int exploding, int speed, int attackSpeedBonus, int poison, int healthBonus, int soulPoints, int emeraldStealing, int healthRegenRaw, int spellDamageRaw, int damageBonusRaw, int bonusFireDamage, int bonusWaterDamage, int bonusAirDamage, int bonusThunderDamage, int bonusEarthDamage, int bonusFireDefense, int bonusWaterDefense, int bonusAirDefense, int bonusThunderDefense, int bonusEarthDefense, String category, int fireDefense, int waterDefense, int airDefense, int thunderDefense, int earthDefense, int health, String accessoryType, String classRequirement, boolean identified, String displayName, String skin) {
        this.name = name;
        this.tier = tier;
        this.sockets = sockets;
        this.armorColor = armorColor;
        this.armorType = armorType;
        this.addedLore = addedLore;
        this.type = type;
        this.set = set;
        this.material = material;
        this.dropType = dropType;
        this.restrictions = restrictions;
        this.damage = damage;
        this.fireDamage = fireDamage;
        this.waterDamage = waterDamage;
        this.airDamage = airDamage;
        this.thunderDamage = thunderDamage;
        this.earthDamage = earthDamage;
        this.attackSpeed = attackSpeed;
        this.level = level;
        this.quest = quest;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.agility = agility;
        this.defense = defense;
        this.healthRegen = healthRegen;
        this.manaRegen = manaRegen;
        this.spellDamage = spellDamage;
        this.damageBonus = damageBonus;
        this.lifeSteal = lifeSteal;
        this.manaSteal = manaSteal;
        this.xpBonus = xpBonus;
        this.lootBonus = lootBonus;
        this.reflection = reflection;
        this.strengthPoints = strengthPoints;
        this.dexterityPoints = dexterityPoints;
        this.intelligencePoints = intelligencePoints;
        this.agilityPoints = agilityPoints;
        this.defensePoints = defensePoints;
        this.thorns = thorns;
        this.exploding = exploding;
        this.speed = speed;
        this.attackSpeedBonus = attackSpeedBonus;
        this.poison = poison;
        this.healthBonus = healthBonus;
        this.soulPoints = soulPoints;
        this.emeraldStealing = emeraldStealing;
        this.healthRegenRaw = healthRegenRaw;
        this.spellDamageRaw = spellDamageRaw;
        this.damageBonusRaw = damageBonusRaw;
        this.bonusFireDamage = bonusFireDamage;
        this.bonusWaterDamage = bonusWaterDamage;
        this.bonusAirDamage = bonusAirDamage;
        this.bonusThunderDamage = bonusThunderDamage;
        this.bonusEarthDamage = bonusEarthDamage;
        this.bonusFireDefense = bonusFireDefense;
        this.bonusWaterDefense = bonusWaterDefense;
        this.bonusAirDefense = bonusAirDefense;
        this.bonusThunderDefense = bonusThunderDefense;
        this.bonusEarthDefense = bonusEarthDefense;
        this.category = category;
        this.fireDefense = fireDefense;
        this.waterDefense = waterDefense;
        this.airDefense = airDefense;
        this.thunderDefense = thunderDefense;
        this.earthDefense = earthDefense;
        this.health = health;
        this.accessoryType = accessoryType;
        this.classRequirement = classRequirement;
        this.identified = identified;
        this.displayName = displayName;
        this.skin = skin;
    }

    public String getName() {
        return name;
    }

    public ItemTier getTier() {
        return tier;
    }

    public int getSockets() {
        return sockets;
    }

    public Color getArmorColor() {
        return armorColor;
    }

    public String getArmorType() {
        return armorType;
    }

    public String getAddedLore() {
        return addedLore;
    }

    public String getType() {
        return type;
    }

    public String getSet() {
        return set;
    }

    public String getMaterial() {
        return material;
    }

    public String getDropType() {
        return dropType;
    }

    public String getRestrictions() {
        return restrictions;
    }

    public String getDamage() {
        return damage;
    }

    public String getFireDamage() {
        return fireDamage;
    }

    public String getWaterDamage() {
        return waterDamage;
    }

    public String getAirDamage() {
        return airDamage;
    }

    public String getThunderDamage() {
        return thunderDamage;
    }

    public String getEarthDamage() {
        return earthDamage;
    }

    public String getAttackSpeed() {
        return attackSpeed;
    }

    public int getLevel() {
        return level;
    }

    public String getQuest() {
        return quest;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealthRegen() {
        return healthRegen;
    }

    public int getManaRegen() {
        return manaRegen;
    }

    public int getSpellDamage() {
        return spellDamage;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    public int getLifeSteal() {
        return lifeSteal;
    }

    public int getManaSteal() {
        return manaSteal;
    }

    public int getXpBonus() {
        return xpBonus;
    }

    public int getLootBonus() {
        return lootBonus;
    }

    public int getReflection() {
        return reflection;
    }

    public int getStrengthPoints() {
        return strengthPoints;
    }

    public int getDexterityPoints() {
        return dexterityPoints;
    }

    public int getIntelligencePoints() {
        return intelligencePoints;
    }

    public int getAgilityPoints() {
        return agilityPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public int getThorns() {
        return thorns;
    }

    public int getExploding() {
        return exploding;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAttackSpeedBonus() {
        return attackSpeedBonus;
    }

    public int getPoison() {
        return poison;
    }

    public int getHealthBonus() {
        return healthBonus;
    }

    public int getSoulPoints() {
        return soulPoints;
    }

    public int getEmeraldStealing() {
        return emeraldStealing;
    }

    public int getHealthRegenRaw() {
        return healthRegenRaw;
    }

    public int getSpellDamageRaw() {
        return spellDamageRaw;
    }

    public int getDamageBonusRaw() {
        return damageBonusRaw;
    }

    public int getBonusFireDamage() {
        return bonusFireDamage;
    }

    public int getBonusWaterDamage() {
        return bonusWaterDamage;
    }

    public int getBonusAirDamage() {
        return bonusAirDamage;
    }

    public int getBonusThunderDamage() {
        return bonusThunderDamage;
    }

    public int getBonusEarthDamage() {
        return bonusEarthDamage;
    }

    public int getBonusFireDefense() {
        return bonusFireDefense;
    }

    public int getBonusWaterDefense() {
        return bonusWaterDefense;
    }

    public int getBonusAirDefense() {
        return bonusAirDefense;
    }

    public int getBonusThunderDefense() {
        return bonusThunderDefense;
    }

    public int getBonusEarthDefense() {
        return bonusEarthDefense;
    }

    public String getCategory() {
        return category;
    }

    public int getFireDefense() {
        return fireDefense;
    }

    public int getWaterDefense() {
        return waterDefense;
    }

    public int getAirDefense() {
        return airDefense;
    }

    public int getThunderDefense() {
        return thunderDefense;
    }

    public int getEarthDefense() {
        return earthDefense;
    }

    public int getHealth() {
        return health;
    }

    public String getAccessoryType() {
        return accessoryType;
    }

    public String getClassRequirement() {
        return classRequirement;
    }

    public boolean isIdentified() {
        return identified;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getSkin() {
        return skin;
    }

    /**
     * Get the minimum value for the input stat
     *
     * @param stat The stat value returned by the API
     * */
    public static int getStatMin(int stat) {
        if (stat < 0) {
            return (int) Math.min(Math.round(stat * 0.7d), -1);
        } else {
            return (int) Math.max(Math.round(stat * 0.3d), 1);
        }
    }

    /**
     * Get the maximum value for the input stat
     *
     * @param stat The stat value returned by the API
     * */
    public static int getStatMax(int stat) {
        if (stat < 0) {
            return (int) Math.min(Math.round(stat * 1.3d), -1);
        } else {
            return (int) Math.max(Math.round(stat * 1.3d), 1);
        }
    }

    /**
     * Get the percentage value of a stat given the base stat and the value
     * to check the percentage of
     *
     * @param stat The base stat returned by the API
     * @param statVal The value of the stat to get the percentage of
     * */
    public static double getStatPercent(int stat, int statVal) {
        return getStatPercent(getStatMin(stat), getStatMax(stat), statVal);
    }

    /**
     * Get the percentage value of a stat
     *
     * @param statMin The minimum value of the stat
     * @param statMax The maximum value of the stat
     * @param statVal The value of the stat to get the percentage of
     * */
    public static double getStatPercent(int statMin, int statMax, int statVal) {
        double variation = (double) (statMax - statMin);
        double amountAboveMin = (double) (statVal - statMin);
        double percent = variation / amountAboveMin;
        if (percent < 0) percent = 1 - percent;
        return percent;
    }

    public static class ItemColorDeserializer implements JsonDeserializer<Color> {
        @Override
        public Color deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            String color = jsonElement.getAsString();
            String[] splitColor = color.split("[^\\d]");
            int red = Integer.parseInt(splitColor[0]);
            int green = Integer.parseInt(splitColor[1]);
            int blue = Integer.parseInt(splitColor[2]);
            return new Color(red, green, blue);
        }
    }
}
