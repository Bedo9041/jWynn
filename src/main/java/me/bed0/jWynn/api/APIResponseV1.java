package me.bed0.jWynn.api;

public class APIResponseV1<T> implements APIResponse<T> {

    private APIResponseV1Request request;
    private T data;

    public APIResponseV1(APIResponseV1Request request, T data) {
        this.request = request;
        this.data = data;
    }

    @Override
    public String getVersion() {
        return request.getVersion();
    }

    @Override
    public long getTimestamp() {
        return request.getTimestamp();
    }

    @Override
    public T getData() {
        return data;
    }
}
