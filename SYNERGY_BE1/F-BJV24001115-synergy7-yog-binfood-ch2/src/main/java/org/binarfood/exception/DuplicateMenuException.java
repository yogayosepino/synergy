package org.binarfood.exception;

public class DuplicateMenuException extends RuntimeException{
    public DuplicateMenuException(String message) {
        super(message);
    }
}
