package com.algorithms.sorts;

import com.algorithms.utils.exceptions.ArrayIsEmptyException;
import com.google.common.primitives.Ints;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ReverseBubbleSortTest {
    private ReverseBubbleSort reverseBubbleSort;
    private int[] expected;

    @BeforeEach
    void setUp() {
        reverseBubbleSort = new ReverseBubbleSort();
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
                () -> reverseBubbleSort.sort(inputArray));
    }

    @Test
    void shouldSortSingleIntegerElementArray() {
        int[] inputArray = {4};
        int[] outputArray = reverseBubbleSort.sort(inputArray);
        int[] expectedOutput = {4};
        assertArrayEquals(outputArray, expectedOutput);
    }

    @Test
    void shouldSortNegativeArray() {
        int[] inputArray = {4, 23, -6, 78, 1, 54, 23, -6, -231, 9, 12};
        int[] outputArray = reverseBubbleSort.sort(inputArray);
        int[] expectedOutput = {78, 54, 23, 23, 12, 9, 4, 1, -6, -6, -231};
        assertArrayEquals(outputArray, expectedOutput);
    }

    @RepeatedTest(value = 10, name = "#{displayName} {currentRepetition}/{totalRepetitions}")
    void shouldSortRandomIntegerArray() {
        int[] sorted = reverseBubbleSort.sort(expected);
        List<Integer> integersList = Ints.asList(expected);
        integersList.sort(Collections.reverseOrder());
        assertEquals(sorted, expected);
    }

}