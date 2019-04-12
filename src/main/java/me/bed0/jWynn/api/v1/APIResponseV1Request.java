package me.bed0.jWynn.api.v1;

public class APIResponseV1Request {

    private long timestamp;
    private String version;

    public APIResponseV1Request(long timestamp, String version) {
        this.timestamp = timestamp;
        this.version = version;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getVersion() {
        return version;
    }
}
