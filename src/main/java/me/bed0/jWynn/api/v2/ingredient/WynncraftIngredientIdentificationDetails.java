package me.bed0.jWynn.api.v2.ingredient;

import me.bed0.jWynn.api.common.WynncraftIdentification;

public class WynncraftIngredientIdentificationDetails {

    private WynncraftIdentification identification;
    private int minimum;
    private int maximum;

    public WynncraftIngredientIdentificationDetails(WynncraftIdentification identification, int minimum, int maximum) {
        this.identification = identification;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public WynncraftIdentification getIdentification() {
        return identification;
    }

    void setIdentification(WynncraftIdentification identification) {
        this.identification = identification;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }
}
