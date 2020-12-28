package com.epam.automation.java.exceptions.university.exceptions;

public class IllegalFacultyCountException extends IllegalArgumentException {
    public IllegalFacultyCountException() {
        super();
    }

    public IllegalFacultyCountException(String s) {
        super(s);
    }

    public IllegalFacultyCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFacultyCountException(Throwable cause) {
        super(cause);
    }
}
