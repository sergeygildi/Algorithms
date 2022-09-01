package com.company;

/**
 * An implementation of the decimal to binary conversion algorithm
 */
public class DecimalToBinary {

    private static final int DECIMAL_NUMBER = -128;

    private static String decimalToBinary(int decimalNumber) {

        int binaryRepresentationOfANumber;

        if (DECIMAL_NUMBER < 0) {
            binaryRepresentationOfANumber = getBinaryRepresentationOfANumber(Math.abs(decimalNumber));
            return String.valueOf(~binaryRepresentationOfANumber + 1);
        } else {
            binaryRepresentationOfANumber = getBinaryRepresentationOfANumber(decimalNumber);
            return String.valueOf(binaryRepresentationOfANumber);
        }
    }

    private static int getBinaryRepresentationOfANumber(int tempDecimalNumber) {
        StringBuilder sb = new StringBuilder();
        do {
            if (tempDecimalNumber % 2 == 0) {
                tempDecimalNumber = tempDecimalNumber >> 1;
                sb.append("0");
            } else {
                tempDecimalNumber = (tempDecimalNumber - 1) >> 1;
                sb.append("1");
            }
        } while (tempDecimalNumber != 0);
        return Integer.parseInt(sb.reverse().toString());
    }

    private static void printResult(String result) {
        System.out.print(result);
    }

    public static void main(String[] args) {
        printResult(decimalToBinary(DECIMAL_NUMBER));
    }
}
