package me.bed0.jWynn.api.v2.ingredient;

public class WynncraftConsumableOnlyIDs {

    private int duration;
    private int charges;

    public WynncraftConsumableOnlyIDs(int duration, int charges) {
        this.duration = duration;
        this.charges = charges;
    }

    public int getDuration() {
        return duration;
    }

    public int getCharges() {
        return charges;
    }
}
