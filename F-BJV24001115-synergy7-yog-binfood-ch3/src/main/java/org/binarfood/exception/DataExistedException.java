package org.binarfood.exception;

public class DataExistedException extends IllegalArgumentException {
    public DataExistedException(String message) {
        super(message);
    }
}
