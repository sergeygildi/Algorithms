package com.algorithms.utils.exceptions;

public class NumberNotFoundException extends RuntimeException {

    public NumberNotFoundException() {
        this.getMessage();
    }

    @Override
    public String getMessage() {
        return "Number not found.";
    }

}
