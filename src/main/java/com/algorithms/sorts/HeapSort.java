package com.algorithms.sorts;

import com.algorithms.utils.checks.Checks;

/**
 * An implementation of the HeapSort algorithm.
 */
public class HeapSort {

    public int[] sort(int[] numbers) {
        Checks.throwExceptionIfArrayEmpty(numbers);
        return getSortedArray(numbers);
    }

    private static int[] getSortedArray(int[] numbers) {
        final int size = numbers.length;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            build(numbers, i, size);
        }
        for (int i = size - 1; i >= 0; i--) {
            swap(numbers, 0, i);
            build(numbers, 0, i);
        }
        return numbers;
    }

    private static void build(int[] numbers, int root, int size) {
        int updRoot = root;
        int left = root * 2 + 1;
        int right = left + 1;

        if (left < size && numbers[updRoot] < numbers[left]) {
            updRoot = left;
        }
        if (right < size && numbers[updRoot] < numbers[right]) {
            updRoot = right;
        }
        if (updRoot == root) {
            return;
        }
        swap(numbers, updRoot, root);
        build(numbers, updRoot, size);
    }

    private static void swap(int[] numbers, int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }

}