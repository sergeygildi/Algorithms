package com.algorithms.utils.checks;

import com.algorithms.utils.exceptions.ArrayIsEmptyException;

public class Checks {

    public static void throwExceptionIfArrayEmpty(int[] numbers) {
        if (numbers.length == 0) {
            throw new ArrayIsEmptyException();
        }
    }

}
