package com.example.projectmanagement.exception;

public class ApplicationException extends RuntimeException {

    public ApplicationException() {
        super("Something went wrong");
    }

    public ApplicationException(String message) {
        super(message);
    }
}
