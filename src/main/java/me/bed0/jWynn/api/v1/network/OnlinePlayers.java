package me.bed0.jWynn.api.v1.network;

public class OnlinePlayers {

    private ServerOnlinePlayers[] onlinePlayers;

    public OnlinePlayers(ServerOnlinePlayers[] onlinePlayers) {
        this.onlinePlayers = onlinePlayers;
    }

    public ServerOnlinePlayers[] getOnlinePlayers() {
        return onlinePlayers;
    }
}
