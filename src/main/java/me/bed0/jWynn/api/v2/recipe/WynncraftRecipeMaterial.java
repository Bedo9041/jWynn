package me.bed0.jWynn.api.v2.recipe;

public class WynncraftRecipeMaterial {

    private String item;
    private int amount;

    public WynncraftRecipeMaterial(String item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
}
