package me.bed0.jWynn.api.v2.endpoints;

import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIRequest;
import me.bed0.jWynn.api.v2.APIResponseV2;
import me.bed0.jWynn.api.v2.player.WynncraftPlayer;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV2PlayerStats extends APIRequest<WynncraftPlayer[]> {

    public APIV2PlayerStats(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public WynncraftPlayer[] run() {
        return runIncludeMeta().getData();
    }

    @Override
    public APIResponseV2<WynncraftPlayer[]> runIncludeMeta() {
        return GSON.fromJson(getReponse(), new TypeToken<APIResponseV2<WynncraftPlayer[]>>() {
        }.getType());
    }
}
