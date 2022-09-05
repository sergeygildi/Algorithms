package com.company;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LinearSearch {
    private static final int[] randomValues = {12, 425, 154, 56543, 467, 3467};
    static Logger logger = Logger.getLogger("SearchForANumberUsingLinearSearch.class");

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
            logger.log(Level.INFO, "Element " + elementToSearch + " at position " + elementIndex);
        } else if (elementIndex == -1) {
            logger.log(Level.INFO, "Element not found");
        }
    }

    public static void main(String[] args) {
        int numberToSearch = 12;
        int element = searchElement(randomValues, numberToSearch);

        printResult(element, numberToSearch);
    }
}
