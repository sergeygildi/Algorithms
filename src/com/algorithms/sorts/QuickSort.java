package com.algorithms.sorts;

/**
 * An implementation QuickSort algorithm.
 */
public class QuickSort {
    private static final int[] NUMBERS = {12, 324, 112, 15, 4, 134, 345, 3, 2, 4, 1, 5, 9};

    public static void quickSort(int[] numbers) {
        sort(numbers, 0, numbers.length - 1);
    }

    private static void sort(int[] numbers, int leftBorder, int rightBorder) {
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
            sort(numbers, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            sort(numbers, leftBorder, rightMarker);
        }
    }

    private static void swap(int[] numbers, int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }

    public static void printResult(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    public static void main(String[] args) {
        quickSort(NUMBERS);
        printResult(NUMBERS);
    }

}
