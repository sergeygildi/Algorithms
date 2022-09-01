package com.company;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DecimalToBinary {

    private static final int DECIMAL_NUMBER = 122;
    private static Logger logger = Logger.getGlobal();

    private static StringBuilder decimalToBinary(int decimalNumber) {
        StringBuilder sb = new StringBuilder();

        int tempDecimalNumber = decimalNumber;

        boolean isDone = false;
        while (!isDone) {
            if (tempDecimalNumber%2==0) {
                tempDecimalNumber = tempDecimalNumber / 2;
                sb.append("0");
            } else {
                tempDecimalNumber = (tempDecimalNumber - 1) / 2;
                sb.append("1");
            }
            if (tempDecimalNumber == 0) {
                isDone = true;
            }
        }
        return sb.reverse();
    }

    private static void printResult(StringBuilder stringBuilder) {
        logger.log(Level.INFO, String.valueOf(stringBuilder));
    }

    public static void main(String[] args) {
        printResult(decimalToBinary(DECIMAL_NUMBER));
    }
}
