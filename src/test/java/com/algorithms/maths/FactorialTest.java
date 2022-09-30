package com.algorithms.maths;

import com.algorithms.utils.exceptions.NumberIsNegativeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {

    @ParameterizedTest
    @DisplayName("should work if pass positive values")
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    void getFactorial(String number) {
        var actual = Factorial.getFactorial(number);

        long parseLong = Long.parseLong(number);
        BigInteger expected = BigInteger.valueOf(
                LongStream.rangeClosed(1, parseLong)
                        .reduce(1,
                                (long x, long y) -> x * y
                        )
        );
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @DisplayName("Should throw IllegalArgumentException if passed arguments are negative numbers")
    @ValueSource(strings = {"-1", "-2", "-3", "-4", "-5"})
    void shouldThrowExceptionIfArgsIsNegativeNumber(String negativeNumbers) {
        assertThrows(NumberIsNegativeException.class,
                () -> Factorial.getFactorial(negativeNumbers),
                "Number is negative");
    }

}