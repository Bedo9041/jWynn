package me.bed0.jWynn.api.v1.map;

public class WynncraftMapLocation {

    private String name;
    private String icon;
    private int x;
    private int y;
    private int z;

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    /**
     * Get the URL for image of this icon. <b>Once downloaded this image should be cached.</b>
     */
    public String getIconURL() {
        return "https://map.wynncraft.com/" + icon;
    }
}
