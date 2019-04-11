package me.bed0.jWynn.api;

public interface APIResponse<T> {

    public String getVersion();

    public long getTimestamp();

    public T getData();
}
