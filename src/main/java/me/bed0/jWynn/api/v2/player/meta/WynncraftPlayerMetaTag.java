package me.bed0.jWynn.api.v2.player.meta;

import me.bed0.jWynn.api.v2.player.PlayerTag;

public class WynncraftPlayerMetaTag {

    private boolean display;
    private PlayerTag value;

    public WynncraftPlayerMetaTag(boolean display, PlayerTag value) {
        this.display = display;
        this.value = value;
    }

    public boolean isDisplay() {
        return display;
    }

    public PlayerTag getValue() {
        return value;
    }
}
