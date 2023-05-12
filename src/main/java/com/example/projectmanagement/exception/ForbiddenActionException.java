package com.example.projectmanagement.exception;

public class ForbiddenActionException extends ApplicationException {

    public ForbiddenActionException() {
        super("don't have permission");
    }
}
