package com.algorithms.sorts;

/**
 * An implementation QuickSort algorithm.
 */
public class QuickSort {

    public int[] quickSort(int[] numbers) {
        if (numbers.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return sort(numbers, 0, numbers.length - 1);
    }

    private static int[] sort(int[] numbers, int leftBorder, int rightBorder) {
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
        return numbers;
    }

    private static void swap(int[] numbers, int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }

}
