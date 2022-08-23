package com.company;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LinearSearch {

    static Logger logger = Logger.getLogger("LinearSearch.class");

    private static int elementToSearch(int[] mass, int index) {
        for (int i = 0; i < mass.length; i++){
            if(mass[i] == index) {
                return i;
            }
        } return -1;
    }

    public static void main(String[] args) {

        int numberToSearch = 12; // change this number
        int[] randomValues = {12,425,154,56543,467,3467};

        int element = elementToSearch(randomValues, numberToSearch);

        printResult(element, numberToSearch);
    }

    private static void printResult(int elementIndex, int elementToSearch) {
        if (elementIndex == -1) {
            logger.log(Level.WARNING, "Element not found");
        } else if (elementIndex >= 0){
            StringBuilder sb = new StringBuilder();
            logger.log(Level.INFO,"Element " + elementToSearch + " at position " + elementIndex );
        }
    }
}
