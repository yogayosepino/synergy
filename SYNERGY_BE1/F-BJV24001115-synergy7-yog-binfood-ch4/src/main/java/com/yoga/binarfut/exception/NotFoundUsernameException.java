package com.yoga.binarfut.exception;

public class NotFoundUsernameException extends IllegalArgumentException {
    public NotFoundUsernameException(String message) {
        super(message);
    }
}
