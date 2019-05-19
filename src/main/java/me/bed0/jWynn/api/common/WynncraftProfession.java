package me.bed0.jWynn.api.common;

public enum WynncraftProfession {

    ARMOURING("Armouring", 'Ⓗ', "http://cdn.wynncraft.com/img/stats/professions/armouring.png"),
    TAILORING("Tailoring", 'Ⓕ', "http://cdn.wynncraft.com/img/stats/professions/tailoring.png"),
    JEWELING("Jeweling", 'Ⓓ', "http://cdn.wynncraft.com/img/stats/professions/jeweling.png"),
    SCRIBING("Scribing", 'Ⓔ', "http://cdn.wynncraft.com/img/stats/professions/scribing.png"),
    WOODWORKING("Woodworking", 'Ⓘ', "http://cdn.wynncraft.com/img/stats/professions/woodworking.png"),
    WEAPONSMITHING("Weaponsmithing", 'Ⓖ', "http://cdn.wynncraft.com/img/stats/professions/weaponsmithing.png"),
    COOKING("Cooking", 'Ⓐ', "http://cdn.wynncraft.com/img/stats/professions/cooking.png"),
    ALCHEMISM("Alchemism", 'Ⓛ', "http://cdn.wynncraft.com/img/stats/professions/alchemism.png"),
    WOODCUTTING("Woodcutting", 'Ⓒ', "http://cdn.wynncraft.com/img/stats/professions/woodcutting.png"),
    MINING("Mining", 'Ⓑ', "http://cdn.wynncraft.com/img/stats/professions/mining.png"),
    FISHING("Fishing", 'Ⓚ', "http://cdn.wynncraft.com/img/stats/professions/fishing.png"),
    FARMING("Farming", 'Ⓙ', "http://cdn.wynncraft.com/img/stats/professions/farming.png");

    private String friendlyName;
    private char minecraftSymbol;
    private String symbolImageURL;

    WynncraftProfession(String friendlyName, char minecraftSymbol, String symbolImageURL) {
        this.friendlyName = friendlyName;
        this.minecraftSymbol = minecraftSymbol;
        this.symbolImageURL = symbolImageURL;
    }

    /**
     * Get a friendly name for this profession (generally just the enum name converted to sentence case)
     */
    public String getFriendlyName() {
        return friendlyName;
    }

    /**
     * Get the symbol used in Minecraft's chat for this profession (i.e. if printed in Minecraft with the
     * Wynncraft resource pack enabled - it will be the profession icon)
     */
    public char getMinecraftSymbol() {
        return minecraftSymbol;
    }

    /**
     * Get the URL of an image of this profession's icon. <b>Once downloaded this image should be cached</b>
     */
    public String getSymbolImageURL() {
        return symbolImageURL;
    }

    public String toString() {
        return getFriendlyName();
    }
}
