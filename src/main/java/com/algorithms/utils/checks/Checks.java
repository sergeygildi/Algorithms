package com.algorithms.utils.checks;

import com.algorithms.utils.exceptions.ParamIsNullException;
import com.algorithms.utils.exceptions.ArrayIsEmptyException;

public class Checks {

    public static void throwExceptionIfArrayEmpty(int[] numbers) {
        if (numbers.length == 0) {
            throw new ArrayIsEmptyException();
        }
    }

    public static void throwExceptionIfParamIsEmptyOrNull(String string) {
        if (string == null || string.isBlank() || string.isEmpty()) {
            throw new ParamIsNullException();
        }
    }

    public static <T extends Number> void throwExceptionIfParamIsEmptyOrNull(T t) {
        if (t.intValue() == 0 || t.doubleValue() == 0.0) {
            throw new ParamIsNullException();
        }
    }

}
