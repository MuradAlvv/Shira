package com.example.mstask.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenActionException extends ApplicationException {

    public ForbiddenActionException() {
        super("don't have permission", HttpStatus.FORBIDDEN);
    }
}
