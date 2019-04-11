package me.bed0.jWynn.exceptions;

public class APIRequestException extends APIException {

    public APIRequestException(String message) {
        super(message);
    }

    public APIRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public APIRequestException(Throwable cause) {
        super(cause);
    }
}
