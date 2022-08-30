package com.company;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySearch {

    private static final Logger LOG = Logger.getGlobal();
    public static final int[] ARRAY = {0,1,2,3,4,5,6,7,8,9,10};

    public static void main(String[] args) {
        binarySearch1(ARRAY, 1);
    }

    private static void binarySearch1(int[] array, int key) {
        Arrays.sort(array);

        int first = 0;
        int last = array.length - 1;
        int mid = (first + last) / 2;

        while (first <= last) {
            if (array[mid] == key) {
                LOG.log (Level.INFO, key + " found at location " + mid);
                break;
            } else if (array[mid] > key) {
                last = mid - 1;
            } else if (array[mid] < key) {
                first = mid + 1;
            }
            mid = (first + last) / 2;
        }

        if (first > last) {
            LOG.log (Level.INFO, key + " is not present in the list.\n");
        }
    }
}
