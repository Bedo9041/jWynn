package me.bed0.jWynn.exceptions;

public class APIMappingException extends APIException {

    public APIMappingException(String message) {
        super(message);
    }

    public APIMappingException(String message, Throwable cause) {
        super(message, cause);
    }

    public APIMappingException(Throwable cause) {
        super(cause);
    }
}
