package com.epam.automation.java.exceptions.university.exceptions;

public class IllegalGroupCountException extends IllegalArgumentException {
    public IllegalGroupCountException() {
        super();
    }

    public IllegalGroupCountException(String s) {
        super(s);
    }

    public IllegalGroupCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalGroupCountException(Throwable cause) {
        super(cause);
    }
}
