package me.bed0.jWynn.api.v2.player;

import java.awt.*;

public enum PlayerTag {

    VIP("VIP", new Color(72, 241, 72)),
    VIPPLUS("VIP+", new Color(0, 195, 255)),
    HERO("HERO", new Color(170, 0, 170)),
    CHAMPION("CHAMPION", new Color(241, 196, 15)),
    OTHER("OTHER", new Color(0, 0, 0));

    private String friendlyName;
    private Color color;

    PlayerTag(String friendlyName, Color color) {
        this.friendlyName = friendlyName;
        this.color = color;
    }

    public String getFriendlyName() {
        return friendlyName;
    }

    public Color getColor() {
        return color;
    }
}
