package me.bed0.jWynn.api.v2.recipe;

public class WynncraftRecipeMinimumMaximum {

    private int minimuim;
    private int maximum;

    public WynncraftRecipeMinimumMaximum(int minimuim, int maximum) {
        this.minimuim = minimuim;
        this.maximum = maximum;
    }

    public int getMinimuim() {
        return minimuim;
    }

    public int getMaximum() {
        return maximum;
    }
}
