package com.algorithms.conversions;


import com.algorithms.utils.exceptions.ParamIsNullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DecimalToBinaryTest {

    private DecimalToBinary decimalToBinary;

    @BeforeEach
    void setUp() {
        decimalToBinary = new DecimalToBinary();
    }

    @Test
    void shouldWorkWithPositiveNumber() {
        String actual = decimalToBinary.conversion(128);
        assertEquals("1000000000000000000000000", actual);
    }

    @Test
    void shouldWorkWithNegativeNumber() {
        String actual = Integer.toBinaryString(-128);
        assertEquals("11111111111111111111111110000000", actual);
    }

    @Test
    void shouldThrowNullException() {
        assertThrows(NullPointerException.class,
                () -> decimalToBinary.conversion(null));
    }

    @Test
    void shouldThrowNullException1() {
        assertThrows(ParamIsNullException.class,
                () -> decimalToBinary.conversion(0));
    }
}