package me.bed0.jWynn.api.v2.player.classes;

public class WynncraftPlayerClassQuests {

    private int completed;
    private String[] list;

    public WynncraftPlayerClassQuests(int completed, String[] list) {
        this.completed = completed;
        this.list = list;
    }

    public int getCompleted() {
        return completed;
    }

    public String[] getList() {
        return list;
    }
}
