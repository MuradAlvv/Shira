package com.example.msauth.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApplicationException {

    public NotFoundException(String object) {
        super(object + "not found", HttpStatus.NOT_FOUND);
    }
}
