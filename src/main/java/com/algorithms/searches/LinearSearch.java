package com.algorithms.searches;

import com.algorithms.utils.checks.Checks;
import com.algorithms.utils.exceptions.NumberNotFoundException;

/**
 * An implementation of the linear search sorting algorithm.
 */
public class LinearSearch {

    public int search(int[] numbers, int element) {
        Checks.throwExceptionIfArrayEmpty(numbers);
        return getFoundElement(numbers, element);
    }

    private static int getFoundElement(int[] array, int element) {
        int foundElementIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                foundElementIndex = i;
            }
        }
        if (foundElementIndex == -1) {
            throw new NumberNotFoundException();
        }
        return foundElementIndex;
    }

}