package me.bed0.jWynn.api.v2.ingredient;

public class WynncraftIngredientConsumableOnlyIDs {

    private float duration;
    private float charges;

    public WynncraftIngredientConsumableOnlyIDs(float duration, float charges) {
        this.duration = duration;
        this.charges = charges;
    }

    public float getDuration() {
        return duration;
    }

    public float getCharges() {
        return charges;
    }
}
