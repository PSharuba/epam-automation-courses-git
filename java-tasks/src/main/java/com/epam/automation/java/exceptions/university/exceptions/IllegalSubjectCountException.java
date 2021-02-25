package com.epam.automation.java.exceptions.university.exceptions;

public class IllegalSubjectCountException extends IllegalArgumentException {
    public IllegalSubjectCountException() {
        super();
    }

    public IllegalSubjectCountException(String s) {
        super(s);
    }

    public IllegalSubjectCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalSubjectCountException(Throwable cause) {
        super(cause);
    }
}
