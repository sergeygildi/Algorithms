package com.algorithms.sorts;

import com.algorithms.utils.exceptions.ArrayIsEmptyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    private HeapSort heapSort;
    private int[] expected;

    @BeforeEach
    void setUp() {
        heapSort = new HeapSort();
        expected = new int[10];
        var randomValue = new Random(System.nanoTime());
        for (int i = 0; i < 10; i++) {
            expected[i] = randomValue.nextInt(100);
        }
    }

    @Test
    @DisplayName("Should throw ArrayIsEmptyException if get an empty array")
    void shouldThrowExceptionIfArrayIsEmpty() {
        int[] inputArray = {};
        assertThrows(
                ArrayIsEmptyException.class,
                () -> heapSort.sort(inputArray));
    }

    @Test
    void shouldSortSingleIntegerElementArray() {
        int[] inputArray = {4};
        int[] outputArray = heapSort.sort(inputArray);
        int[] expectedOutput = {4};
        assertArrayEquals(outputArray, expectedOutput);
    }

    @Test
    void shouldSortNegativeArray() {
        int[] inputArray = {4, 23, -6, 78, 1, 54, 23, -6, -231, 9, 12};
        int[] outputArray = heapSort.sort(inputArray);
        int[] expectedOutput = {-231, -6, -6, 1, 4, 9, 12, 23, 23, 54, 78};
        assertArrayEquals(outputArray, expectedOutput);
    }

    @RepeatedTest(value = 10, name = "#{displayName} {currentRepetition}/{totalRepetitions}")
    void shouldSortRandomIntegerArray() {
        var sorted = heapSort.sort(expected);
        Arrays.sort(expected);

        assertEquals(sorted, expected);
    }

}