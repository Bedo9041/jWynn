package me.bed0.jWynn.api.v2;

import edu.umd.cs.findbugs.annotations.CheckReturnValue;
import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.v2.routes.APIV2Player;

public class APIVersion2 {

    private WynncraftAPI api;
    private APIV2Player player;

    public APIVersion2(WynncraftAPI api) {
        this.api = api;
        player = new APIV2Player(api);
    }

    @CheckReturnValue
    public APIV2Player player() {
        return player;
    }
}
