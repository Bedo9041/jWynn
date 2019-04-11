package me.bed0.jWynn.api.v2.player.classes;

public class WynncraftPlayerClassDungeonIndividual {

    private String name;
    private int completed;

    public WynncraftPlayerClassDungeonIndividual(String name, int completed) {
        this.name = name;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public int getCompleted() {
        return completed;
    }
}
