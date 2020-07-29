package com.lusa.carros.customexceptions;

public class NoPropertiesException extends RuntimeException {

    public NoPropertiesException() {}

    public NoPropertiesException(String message) {
        super(message);
    }

    public NoPropertiesException(String message, Throwable cause) {
        super(message, cause);
    }
}
