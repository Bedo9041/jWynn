package me.bed0.jWynn.api.v2.player.classes;

public class WynncraftPlayerClassDungeonCollection {

    private int completed;
    private WynncraftPlayerClassDungeonIndividual[] list;

    public WynncraftPlayerClassDungeonCollection(int completed, WynncraftPlayerClassDungeonIndividual[] list) {
        this.completed = completed;
        this.list = list;
    }

    public int getCompleted() {
        return completed;
    }

    public WynncraftPlayerClassDungeonIndividual[] getList() {
        return list;
    }
}
