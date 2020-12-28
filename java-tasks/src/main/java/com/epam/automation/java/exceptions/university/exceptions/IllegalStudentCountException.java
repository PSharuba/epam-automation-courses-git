package com.epam.automation.java.exceptions.university.exceptions;

public class IllegalStudentCountException extends IllegalArgumentException {
    public IllegalStudentCountException() {
        super();
    }

    public IllegalStudentCountException(String s) {
        super(s);
    }

    public IllegalStudentCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalStudentCountException(Throwable cause) {
        super(cause);
    }
}
