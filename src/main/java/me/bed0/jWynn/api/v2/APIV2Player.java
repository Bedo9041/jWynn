package me.bed0.jWynn.api.v2;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.APIMidpoint;

public class APIV2Player extends APIMidpoint {

    private WynncraftAPI api;

    public APIV2Player(WynncraftAPI api) {
        this.api = api;
    }

    public APIV2PlayerStats stats(String playerName) {
        return new APIV2PlayerStats(api.getConfig().getBaseURL() + "v2/player/" + playerName + "/stats", this);
    }
}
