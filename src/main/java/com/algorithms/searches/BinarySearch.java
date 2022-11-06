package com.algorithms.searches;

import com.algorithms.utils.checks.Checks;
import com.algorithms.utils.exceptions.NumberNotFoundException;

import java.util.Arrays;

/**
 * An implementation of the BinarySearch algorithm.
 */
public class BinarySearch {

    public int search(int[] numbers, int key) {
        Checks.throwExceptionIfArrayEmpty(numbers);
        return getFoundNumberIndex(numbers, key);
    }

    private int getFoundNumberIndex(int[] numbers, int key) {
        Arrays.sort(numbers);

        int left = 0;
        int right = numbers.length - 1;
        int pivot = (left + right) / 2;
        int foundNumber = -1;

        while (left <= right) {
            if (key == numbers[pivot]) {
                foundNumber = pivot;
                break;
            }
            if (numbers[pivot] < key) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
            pivot = (left + right) / 2;
        }

        if (foundNumber == -1) {
            throw new NumberNotFoundException();
        }

        return foundNumber;
    }
}
