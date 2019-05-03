package me.bed0.jWynn.exceptions;

public class APIResponseException extends APIException {

    public APIResponseException(String message) {
        super(message);
    }

    public APIResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public APIResponseException(Throwable cause) {
        super(cause);
    }
}
