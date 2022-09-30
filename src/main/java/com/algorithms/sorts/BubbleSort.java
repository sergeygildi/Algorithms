package com.algorithms.sorts;

import com.algorithms.utils.checks.Checks;

/**
 * An implementation of the bubble sorting algorithm.
 */
public class BubbleSort {

    public int[] sort(int[] numbers) {
        Checks.throwExceptionIfArrayEmpty(numbers);
        return getSortedArray(numbers);
    }

    private static int[] getSortedArray(int[] numbers) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < numbers.length; i++) {
                int current = numbers[i];
                int previous = numbers[i - 1];
                if (current < previous) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i - 1];
                    numbers[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
        return numbers;
    }
}
