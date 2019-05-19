package me.bed0.jWynn.api.v1.endpoints;

import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIRequest;
import me.bed0.jWynn.api.APIResponse;
import me.bed0.jWynn.api.v1.APIResponseV1;
import me.bed0.jWynn.api.v1.leaderboard.PlayerLeaderboardPos;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV1PlayerLeaderboard extends APIRequest<PlayerLeaderboardPos[]> {

    public APIV1PlayerLeaderboard(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public PlayerLeaderboardPos[] run() {
        return runIncludeMeta().getData();
    }

    @Override
    public APIResponse<PlayerLeaderboardPos[]> runIncludeMeta() {
        return GSON.fromJson(getResponse(), new TypeToken<APIResponseV1<PlayerLeaderboardPos[]>>() {}.getType());
    }
}
