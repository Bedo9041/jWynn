package me.bed0.jWynn.api;

public class APIResponseV1<T> implements APIResponse<T> {

    public long timestamp;
    public long version;
    public T data;

    public APIResponseV1(long timestamp, long version, T data) {
        this.timestamp = timestamp;
        this.version = version;
        this.data = data;
    }

    @Override
    public String getVersion() {
        return version + "";
    }

    @Override
    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public T getData() {
        return data;
    }
}
