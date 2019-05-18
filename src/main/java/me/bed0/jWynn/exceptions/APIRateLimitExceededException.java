package me.bed0.jWynn.exceptions;

public class APIRateLimitExceededException extends APIException {

    private long tryAgainAt;
    private boolean fromRequest;

    public APIRateLimitExceededException(String message, long tryAgainAt, boolean fromRequest) {
        super(message);
        this.tryAgainAt = tryAgainAt;
        this.fromRequest = fromRequest;
    }

    public long getTryAgainAt() {
        return tryAgainAt;
    }

    public boolean isFromRequest() {
        return fromRequest;
    }
}
