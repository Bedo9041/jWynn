package me.bed0.jWynn.api.v1.territory;

public class WynncraftTerritoryLocation {

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public WynncraftTerritoryLocation(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }
}
