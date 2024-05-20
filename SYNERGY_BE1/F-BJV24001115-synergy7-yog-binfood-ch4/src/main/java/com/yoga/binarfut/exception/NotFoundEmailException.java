package com.yoga.binarfut.exception;

public class NotFoundEmailException extends IllegalArgumentException {
    public NotFoundEmailException(String message) {
        super(message);
    }
}
