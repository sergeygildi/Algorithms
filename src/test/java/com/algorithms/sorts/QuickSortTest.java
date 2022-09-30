package com.algorithms.sorts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class QuickSortTest {

    private QuickSort quickSort;
    private int[] expected;

    @BeforeEach
    void setUp() {
        quickSort = new QuickSort();
        expected = new int[10];
        var randomValue = new Random(System.nanoTime());
        for (int i = 0; i < 10; i++) {
            expected[i] = randomValue.nextInt(100);
        }
    }

    @Test
    @DisplayName("Should throw ArrayIndexOutOfBoundsException if get an empty array")
    void shouldThrowExceptionIfArrayIsEmpty() {
        int[] inputArray = {};
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> quickSort.quickSort(inputArray));
    }

    @Test
    void shouldSortSingleIntegerElementArray() {
        int[] inputArray = {4};
        int[] outputArray = quickSort.quickSort(inputArray);
        int[] expectedOutput = {4};
        assertArrayEquals(outputArray, expectedOutput);
    }

    @Test
    void shouldSortNegativeArray() {
        int[] inputArray = {4, 23, -6, 78, 1, 54, 23, -6, -231, 9, 12};
        int[] outputArray = quickSort.quickSort(inputArray);
        int[] expectedOutput = {-231, -6, -6, 1, 4, 9, 12, 23, 23, 54, 78};
        assertArrayEquals(outputArray, expectedOutput);
    }

    @RepeatedTest(value = 10, name = "#{displayName} {currentRepetition}/{totalRepetitions}")
    void shouldSortRandomIntegerArray() {
        var sorted = quickSort.quickSort(expected);
        Arrays.sort(expected);
        assertEquals(sorted, expected);
    }

}