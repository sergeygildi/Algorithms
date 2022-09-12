package com.company;

import java.math.BigInteger;

/**
 * An implementation of calculation Factorial in Java
 */
public class Factorial {

    public static void main(String[] args) {
        getFactorial("4");
        getFactorial("-4");
    }

    /**
     * The long datatype can be used for factorials only for n <= 20.
     * For larger values of n, we can use the BigInteger class from the java.Math package,
     * which can hold values up to 2^Integer.MAX_VALUE;
     *
     * @param targetNumberString
     * @return BigInteger
     */
    public static BigInteger getFactorial(String targetNumberString) {
        BigInteger target = new BigInteger(targetNumberString).abs();
        if (!target.equals(BigInteger.ZERO)) {
            BigInteger factorial = target;
            while (!target.equals(BigInteger.ONE)) {
                target = target.subtract(BigInteger.ONE);
                factorial = factorial.multiply(target);
            }
            System.out.println(factorial);
            return factorial;
        }
        return BigInteger.ONE;
    }
}
