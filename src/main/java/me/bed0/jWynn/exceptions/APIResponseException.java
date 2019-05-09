package me.bed0.jWynn.exceptions;

public class APIResponseException extends APIException {

    private int statusCode;

    public APIResponseException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
