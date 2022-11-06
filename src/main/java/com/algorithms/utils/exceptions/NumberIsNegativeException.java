package com.algorithms.utils.exceptions;

public class NumberIsNegativeException extends RuntimeException {

    public NumberIsNegativeException() {
        this.getMessage();
    }

    @Override
    public String getMessage() {
        return "Number is negative.";
    }

}
