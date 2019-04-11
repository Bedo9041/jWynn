package me.bed0.jWynn.api.v2.player.classes;

public class WynncraftPlayerClassSkills {

    private int strength;
    private int dexterity;
    private int intelligence;
    private int defense;
    private int agility;

    public WynncraftPlayerClassSkills(int strength, int dexterity, int intelligence, int defense, int agility) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.defense = defense;
        this.agility = agility;
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

    public int getDefense() {
        return defense;
    }

    public int getAgility() {
        return agility;
    }
}
