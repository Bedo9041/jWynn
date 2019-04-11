package me.bed0.jWynn.api.v2;

import me.bed0.jWynn.WynncraftAPI;

public class APIVersion2 {

    private WynncraftAPI api;
    private APIV2Player player;

    public APIVersion2(WynncraftAPI api) {
        this.api = api;
        player = new APIV2Player(api);
    }

    public APIV2Player player() {
        return player;
    }
}
