package me.bed0.jWynn.api.v2.player;

public class WynncraftPlayerUUID {

    private String name;
    private String uuid;

    public WynncraftPlayerUUID(String name, String uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }
}
