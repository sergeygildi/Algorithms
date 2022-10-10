package com.algorithms.sorts;

/**
 * An implementation of the reverse bubble sorting algorithm.
 */
public class ReverseBubbleSort {
    private static final int[] NUMBERS = {12, 324, 112, 15, 4, 134, 345, 3, 2, 4, 1, 5, 9};

    private static void sortedArray(int[] numbers) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < numbers.length; i++) {
                int current = numbers[i];
                int previous = numbers[i - 1];

                if (current > previous) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i - 1];
                    numbers[i - 1] = temp;
                    isSorted = false;
                }
            }
        }
        print(numbers);
    }

    private static void print(int[] sortedArray) {
        for (int number : sortedArray) {
            System.out.print(number + " ");
        }
    }

    public static void main(String[] args) {
        sortedArray(NUMBERS);
    }
}