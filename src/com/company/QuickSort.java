package com.company;

/**
 * An implementation Quick Sort algorithm.
 */
public class QuickSort {
    public static final int[] NUMBERS = {100, 29, 38, 47, 56, 65, 74, 38, 29, 1, 10};

    public static void main(String[] args) {
        quickSort(NUMBERS, 0, NUMBERS.length - 1);
        printResult(NUMBERS);
    }

    private static void quickSort(int[] numbers, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = numbers[(leftMarker + rightMarker) / 2];

        do {
            while (numbers[leftMarker] < pivot) {
                leftMarker++;
            }

            while (numbers[rightMarker] > pivot) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    swap(numbers, leftMarker, rightMarker);
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        if (leftMarker < rightBorder) {
            quickSort(numbers, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(numbers, leftBorder, rightMarker);
        }
    }

    public static void printResult(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static void swap(int[] numbers, int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }
}
