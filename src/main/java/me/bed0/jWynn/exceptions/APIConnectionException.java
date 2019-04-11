package me.bed0.jWynn.exceptions;

public class APIConnectionException extends APIException {

    public APIConnectionException(String message) {
        super(message);
    }

    public APIConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public APIConnectionException(Throwable cause) {
        super(cause);
    }
}
