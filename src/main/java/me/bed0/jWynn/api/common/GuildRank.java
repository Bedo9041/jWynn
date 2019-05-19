package me.bed0.jWynn.api.common;

public enum GuildRank {

    RECRUIT("", '♙'),
    RECRUITER("★", '♘'),
    CAPTAIN("★★", '♖'),
    CHIEF("★★★", '♕'),
    OWNER("★★★★", '♔');

    private String stars;
    private char symbol;

    GuildRank(String stars, char symbol) {
        this.stars = stars;
        this.symbol = symbol;
    }

    /**
     * Get a string representing the starts that proceed this rank in the guild
     */
    public String getStars() {
        return stars;
    }

    /**
     * Get the character that represents this rank in the guild (as seen at https://wynncraft.com/stats)
     */
    public char getSymbol() {
        return symbol;
    }
}
