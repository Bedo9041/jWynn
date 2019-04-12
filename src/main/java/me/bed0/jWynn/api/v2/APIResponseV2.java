package me.bed0.jWynn.api.v2;

import me.bed0.jWynn.api.APIResponse;

public class APIResponseV2<T> implements APIResponse<T> {

    private String kind;
    private int code;
    private String message;
    private long timestamp;
    private String version;
    private T data;

    public APIResponseV2(String kind, int code, String message, long timestamp, String version, T data) {
        this.kind = kind;
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.version = version;
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public T getData() {
        return data;
    }
}
