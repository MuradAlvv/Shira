package com.example.msproject.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApplicationException extends RuntimeException {

    private final HttpStatus status;

    public ApplicationException(HttpStatus status) {
        super("Something went wrong");
        this.status = status;
    }

    public ApplicationException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
