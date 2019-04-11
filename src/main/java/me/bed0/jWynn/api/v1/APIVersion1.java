package me.bed0.jWynn.api.v1;

import me.bed0.jWynn.WynncraftAPI;
import me.bed0.jWynn.api.APIMidpoint;

public class APIVersion1 extends APIMidpoint {

    private WynncraftAPI api;

    public APIVersion1(WynncraftAPI api) {
        v2 = false;
        this.api = api;
    }
}
