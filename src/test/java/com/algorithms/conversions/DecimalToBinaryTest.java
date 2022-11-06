package com.algorithms.conversions;

import com.algorithms.utils.exceptions.ParamIsNullException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("DecimalToBinary should")
class DecimalToBinaryTest {

    private static DecimalToBinary decimalToBinary;

    @BeforeAll
    static void setUp() {
        decimalToBinary = new DecimalToBinary();
    }

    @Test
    @DisplayName("work with positive number")
    void positiveNumberInput() {
        String actual = decimalToBinary.conversion(128);
        assertEquals("1000000000000000000000000", actual);
    }

    @Test
    @DisplayName("work with negative number")
    void negativeNumberInput() {
        String actual = decimalToBinary.conversion(-128);
        assertEquals("1111111111111111111111111", actual);
    }

    @Test
    @DisplayName("throw an exception if input is null")
    void nullInput() {
        assertThrows(NullPointerException.class,
                () -> decimalToBinary.conversion(null));
    }

    @Test
    @DisplayName("throw an exception if input is zero")
    void zeroInput() {
        assertThrows(ParamIsNullException.class,
                () -> decimalToBinary.conversion(0));
    }

}