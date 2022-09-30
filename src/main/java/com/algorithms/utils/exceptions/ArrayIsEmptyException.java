package com.algorithms.utils.exceptions;

public class ArrayIsEmptyException extends RuntimeException {

    public ArrayIsEmptyException() {
        this.getMessage();
    }

    @Override
    public String getMessage() {
        return "Array is empty.";
    }

}
