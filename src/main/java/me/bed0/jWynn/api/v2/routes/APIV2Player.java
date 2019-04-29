package me.bed0.jWynn.api.v2.routes;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.v2.endpoints.APIV2PlayerStats;
import me.bed0.jWynn.api.v2.endpoints.APIV2PlayerUUID;
import me.bed0.jWynn.config.WynncraftAPIConfig;

public class APIV2Player extends APIMidpoint {

    private WynncraftAPI api;

    public APIV2Player(WynncraftAPI api) {
        this.api = api;
    }

    @Override
    public WynncraftAPIConfig getAPIConfig() {
        return api.getConfig();
    }

    @CheckReturnValue
    public APIV2PlayerStats stats(String playerName) {
        return new APIV2PlayerStats(api.getConfig().getBaseURL() + "v2/player/" + playerName + "/stats", this);
    }

    @CheckReturnValue
    @Deprecated
    public APIV2PlayerUUID uuid(String playerName) {
        return new APIV2PlayerUUID(api.getConfig().getBaseURL() + "v2/player/" + playerName + "/uuid", this);
    }
}
