package com.company;

import java.util.Arrays;

public class BinarySearch {
    public static final int[] NUMBERS = {30, 11, 22, 43, 54, 65, 76, 87, 98, 9, -10};

    public static void main(String[] args) {
        binarySearch(NUMBERS, 3);
    }

    private static void binarySearch(int[] numbers, int elementToBeFound) {
        Arrays.sort(numbers);

        int first = 0;
        int last = numbers.length - 1;
        int pivot = (first + last) >> 1;

        while (first <= last) {
            if (numbers[pivot] == elementToBeFound) {
                System.out.printf("%s found at location %s", elementToBeFound, pivot);
                break;
            } else if (numbers[pivot] > elementToBeFound) {
                last = pivot--;
            } else if (numbers[pivot] < elementToBeFound) {
                first = pivot++;
            }
            pivot = (first + last) >> 1;
        }

        if (first > last) {
            System.out.printf("%s is not present in the list.\n", elementToBeFound);
        }
    }
}
