package me.bed0.jWynn.api.v2.player.classes;

public class WynncraftPlayerClassSkills {

    private int strength;
    private int dexterity;
    private int intelligence;
    private int defence;
    private int agility;

    public WynncraftPlayerClassSkills(int strength, int dexterity, int intelligence, int defence, int agility) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.defence = defence;
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

    @Deprecated
    public int getDefense() {
        return defence;
    }

    public int getDefence() {
        return defence;
    }

    public int getAgility() {
        return agility;
    }
}
