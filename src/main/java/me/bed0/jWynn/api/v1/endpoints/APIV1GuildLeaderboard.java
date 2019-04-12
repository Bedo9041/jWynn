package me.bed0.jWynn.api.v1.endpoints;

import com.google.gson.reflect.TypeToken;
import me.bed0.jWynn.api.APIMidpoint;
import me.bed0.jWynn.api.APIRequest;
import me.bed0.jWynn.api.APIResponse;
import me.bed0.jWynn.api.v1.APIResponseV1;
import me.bed0.jWynn.api.v1.leaderboard.GuildLeaderboardPos;

import static me.bed0.jWynn.WynncraftAPI.GSON;

public class APIV1GuildLeaderboard extends APIRequest<GuildLeaderboardPos[]> {

    public APIV1GuildLeaderboard(String requestURL, APIMidpoint midpoint) {
        super(requestURL, midpoint);
    }

    @Override
    public GuildLeaderboardPos[] run() {
        return runIncludeMeta().getData();
    }

    @Override
    public APIResponse<GuildLeaderboardPos[]> runIncludeMeta() {
        return GSON.fromJson(getReponse(), new TypeToken<APIResponseV1<GuildLeaderboardPos[]>>(){}.getType());
    }
}
