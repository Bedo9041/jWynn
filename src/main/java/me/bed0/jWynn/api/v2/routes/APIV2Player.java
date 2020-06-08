package me.bed0.jWynn.api.v2.routes;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.v2.endpoints.APIV2PlayerStats;
import me.bed0.jWynn.api.v2.endpoints.APIV2PlayerUUID;
import me.bed0.jWynn.config.WynncraftAPIConfig;
import me.bed0.jWynn.exceptions.APIRequestException;

import javax.annotation.CheckReturnValue;
import java.util.UUID;

public class APIV2Player {

    private WynncraftAPI api;

    public APIV2Player(WynncraftAPI api) {
        this.api = api;
    }

    /**
     * See <a href="https://docs.wynncraft.com/Player-API/#statistics">https://docs.wynncraft.com/Player-API/#statistics</a>
     */
    @CheckReturnValue
    public APIV2PlayerStats stats(String playerName) {
        if (!playerName.matches("[a-zA-Z0-9_]{1,16}"))
            throw new APIRequestException("The provided username: " + playerName + " is not a valid Minecraft username");
        return new APIV2PlayerStats(api.getConfig().getBaseURL() + "v2/player/" + playerName + "/stats", api);
    }

    /**
     * See <a href="https://docs.wynncraft.com/Player-API/#statistics">https://docs.wynncraft.com/Player-API/#statistics</a>
     */
    @CheckReturnValue
    public APIV2PlayerStats statsUUID(UUID uuid) {
        return new APIV2PlayerStats(api.getConfig().getBaseURL() + "v2/player/" + uuid.toString() + "/stats", api);
    }

    /**
     * See <a href="https://docs.wynncraft.com/Player-API/#statistics">https://docs.wynncraft.com/Player-API/#statistics</a>
     */
    @CheckReturnValue
    public APIV2PlayerStats statsUUID(String uuidIn) {
        String uuid = uuidIn;
        if (!uuid.matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}")) {
            if (!uuid.matches("[0-9a-fA-F]{32}"))
                throw new APIRequestException("The provided UUID: " + uuid + " is not a valid UUID");
            uuid = new StringBuilder(uuid).insert(20, "-").insert(16, "-").insert(12, "-").insert(8, "-").toString();
        }
        return new APIV2PlayerStats(api.getConfig().getBaseURL() + "v2/player/" + uuid + "/stats", api);
    }

    /**
     * See <a href="https://docs.wynncraft.com/Player-API/#uuid">https://docs.wynncraft.com/Player-API/#uuid</a>
     *
     * @deprecated Use Mojang's API instead
     */
    @CheckReturnValue
    @Deprecated
    public APIV2PlayerUUID uuid(String playerName) {
        if (!playerName.matches("[a-zA-Z0-9_]{1,16}"))
            throw new APIRequestException("The provided username: " + playerName + " is not a valid Minecraft username");
        return new APIV2PlayerUUID(api.getConfig().getBaseURL() + "v2/player/" + playerName + "/uuid", api);
    }
}
