package com.algorithms.conversions;

import com.algorithms.utils.checks.Checks;

/**
 * An implementation of the algorithm that converts a number from decimal to binary
 */
public class DecimalToBinary {

    public <T extends Number> String conversion(T t) {
        Checks.throwExceptionIfParamIsEmptyOrNull(t);
        return getBinaryNumber(t);
    }

    private static <T extends Number> String getBinaryNumber(T t) {
        StringBuilder sb = new StringBuilder();
        int value = t.intValue();
        while (value != 0) {
            sb.append(value < 0 ? '1' : '0');
            value <<= 1;
        }
        return sb.reverse().toString();
    }

}
