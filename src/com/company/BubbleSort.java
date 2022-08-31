package com.company;

/**
 * An implementation of the bubble sorting algorithm.
 */
public class BubbleSort {

    private static final int[] NUMBERS = {12, 324, 112, 15, 4, 134, 345, 3, 2, 4, 1, 5, 9};

    private static void bubbleSort(int[] numbers) {
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
        print(numbers);
    }

    private static void print(int[] bubbleSort) {
        for (int value : bubbleSort) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        bubbleSort(NUMBERS);
    }
}
