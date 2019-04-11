package me.bed0.jWynn.api.v1.guild;

public class GuildList {

    String[] guilds;

    public GuildList(String[] guilds) {
        this.guilds = guilds;
    }

    public String[] getList() {
        return guilds;
    }
}
