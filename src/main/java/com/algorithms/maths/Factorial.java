package com.algorithms.maths;

import java.math.BigInteger;

/**
 * An implementation of calculation Factorial in Java
 */
public class Factorial {

    /**
     * The long datatype can be used for factorials only for n <= 20.
     * For larger values of n, we can use the BigInteger class from the java.Math package,
     * which can hold values up to {@code 2^Integer.MAX_VALUE}.
     *
     * @param targetNumberString
     * @return BigInteger
     */
    public static BigInteger getFactorial(String targetNumberString) {
        if (Integer.parseInt(targetNumberString) < 0) {
            throw new IllegalArgumentException("number is negative");
        }
        BigInteger target = new BigInteger(targetNumberString).abs();
        if (!target.equals(BigInteger.ZERO)) {
            BigInteger factorial = target;
            while (!target.equals(BigInteger.ONE)) {
                target = target.subtract(BigInteger.ONE);
                factorial = factorial.multiply(target);
            }
            return factorial;
        }
        return BigInteger.ONE;
    }

}
