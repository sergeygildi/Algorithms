package com.company;

/**
 * An implementation of the HeapSort algorithm.
 */
public class HeapSort {
    private static final int[] NUMBERS = {23, 445, 776, 213, 865, 234, 67, 3};

    public static void main(String[] args) {
        sort(NUMBERS);
        printResult(NUMBERS);
    }

    private static void sort(int[] numbers) {
        final int size = numbers.length;
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            build(numbers, i, size);
        }
        for (int i = size - 1; i >= 0; i--) {
            swap(numbers, 0, i);
            build(numbers, 0, i);
        }
    }

    private static void build(int[] numbers, int root, int size) {
        int x = root;
        int l = root * 2 + 1;
        int r = l + 1;

        if (l < size && numbers[x] < numbers[l]) {
            x = l;
        }
        if (r < size && numbers[x] < numbers[r]) {
            x = r;
        }
        if (x == root) {
            return;
        }
        swap(numbers, x, root);
        build(numbers, x, size);
    }

    private static void swap(int[] numbers, int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }

    private static void printResult(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}