package com.algorithms.searches;

import com.algorithms.utils.exceptions.ArrayIsEmptyException;
import com.algorithms.utils.exceptions.NumberNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    private BinarySearch binarySearch;
    private int[] expected;

    @BeforeEach
    void setUp() {
        binarySearch = new BinarySearch();
        expected = new int[]{-10, 9, -8, 7, -6, 5, -4, 3, -2, 1};
    }

    @Test
    void shouldFindIntNumber() {
        var actual = binarySearch.search(expected, 5);
        assertEquals(7, actual);
    }

    @Test
    @DisplayName("Should throw NumberNotFoundException if get an empty array")
    void shouldThrowNumberNotFoundException() {
        assertThrows(NumberNotFoundException.class,
                () -> {
                    binarySearch.search(expected, 100);
                });
    }

    @Test
    @DisplayName("Should throw ArrayIsEmptyException if get an empty array")
    void shouldThrowArrayIsEmptyException() {
        int[] inputArray = {};
        assertThrows(
                ArrayIsEmptyException.class,
                () -> binarySearch.search(inputArray, 3));
    }

}