package org.binarfood.exception;

public class DuplicateMenuException extends IllegalArgumentException{
    public DuplicateMenuException(String message) {
        super(message);
    }
}
