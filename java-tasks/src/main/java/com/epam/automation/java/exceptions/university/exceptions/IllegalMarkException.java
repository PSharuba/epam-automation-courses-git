package com.epam.automation.java.exceptions.university.exceptions;

public class IllegalMarkException extends IllegalArgumentException {
    public IllegalMarkException() {
        super();
    }

    public IllegalMarkException(String s) {
        super(s);
    }

    public IllegalMarkException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalMarkException(Throwable cause) {
        super(cause);
    }
}