package com.algorithms.utils.exceptions;

public class ParamIsNullException extends RuntimeException {
    public ParamIsNullException() {
        this.getMessage();
    }

    @Override
    public String getMessage() {
        return "Parameter is null.";
    }

}
