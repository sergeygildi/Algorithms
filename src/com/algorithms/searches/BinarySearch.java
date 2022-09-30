package com.algorithms.searches;

import java.util.Arrays;

/**
 * An implementation of the BinarySearch algorithm.
 */
public class BinarySearch {
    public static final int[] NUMBERS = {30, 11, 22, 43, 54, 65, 76, 87, 98, 9, -10};

    public static void main(String[] args) {
        binarySearch(NUMBERS, 3);
    }

    private static void binarySearch(int[] numbers, int elementToBeFound) {
        Arrays.sort(numbers);

        int left = 0;
        int right = numbers.length - 1;
        int pivot = (left + right) / 2;

        while (left <= right) {
            if (elementToBeFound == numbers[pivot]) {
                System.out.printf("%s found at location %s", elementToBeFound, pivot);
                break;
            }
            if (numbers[pivot] < elementToBeFound) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
            pivot = (left + right) / 2;
        }

        if (left > right) {
            System.out.printf("%d is not present in the list.%s",
                    elementToBeFound, System.lineSeparator());
        }
    }
}
