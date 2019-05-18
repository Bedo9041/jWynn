package me.bed0.jWynn.api.v2.ingredient;

public class WynncraftIngredientSprite {

    private int id;
    private int damage;

    public WynncraftIngredientSprite(int id, int damage) {
        this.id = id;
        this.damage = damage;
    }

    public int getId() {
        return id;
    }

    public int getDamage() {
        return damage;
    }
}
