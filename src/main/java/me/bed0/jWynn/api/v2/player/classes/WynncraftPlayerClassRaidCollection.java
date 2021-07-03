package me.bed0.jWynn.api.v2.player.classes;

public class WynncraftPlayerClassRaidCollection {

    private int completed;
    private WynncraftPlayerClassRaidIndividual[] list;

    public WynncraftPlayerClassRaidCollection(int completed, WynncraftPlayerClassRaidIndividual[] list) {
        this.completed = completed;
        this.list = list;
    }

    public int getCompleted() {
        return completed;
    }

    public WynncraftPlayerClassRaidIndividual[] getList() {
        return list;
    }
}
