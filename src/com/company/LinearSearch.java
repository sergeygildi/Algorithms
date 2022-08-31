package com.company;

/**
 * An implementation of the linear search sorting algorithm.
 */
public class LinearSearch {
    private static final int[] randomValues = {12, 425, 154, 56543, 467, 3467};

    private static int searchElement(int[] array, int value) {
        int foundNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                foundNumber = i;
            }
        }
        return foundNumber;
    }

    private static void printResult(int elementIndex, int elementToSearch) {
        if (elementIndex >= 0) {
            System.out.print("Element " + elementToSearch + " at position " + elementIndex);
        } else if (elementIndex == -1) {
            System.out.print("Element not found");
        }
    }

    public static void main(String[] args) {
        int numberToSearch = 12;
        int element = searchElement(randomValues, numberToSearch);

        printResult(element, numberToSearch);
    }
}
