package com.algorithms.searches;

import com.algorithms.utils.exceptions.ArrayIsEmptyException;
import com.algorithms.utils.exceptions.NumberNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LinearSearchTest {
    private LinearSearch linearSearch;
    private int[] expected;

    @BeforeEach
    void setUp() {
        linearSearch = new LinearSearch();
        expected = new int[]{-10, 9, -8, 7, -6, 5, -4, 3, -2, 1};
    }

    @Test
    void shouldFindIntNumber() {
        var actual = linearSearch.search(expected, 5);
        assertEquals(5, actual);
    }

    @Test
    @DisplayName("Should throw NumberNotFoundException if get an empty array")
    void shouldThrowNumberNotFoundException() {
        assertThrows(NumberNotFoundException.class,
                () -> {
                    linearSearch.search(expected, 100);
                });
    }

    @Test
    @DisplayName("Should throw ArrayIsEmptyException if get an empty array")
    void shouldThrowArrayIsEmptyException() {
        int[] inputArray = {};
        assertThrows(
                ArrayIsEmptyException.class,
                () -> linearSearch.search(inputArray, 3));
    }

}