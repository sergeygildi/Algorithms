package com.company;

/**
 * An implementation of the algorithm that converts a number from decimal to binary
 */
public class DecimalToBinary {

    private static void decimalToBinary(int decimalNumber) {
        StringBuilder sb = new StringBuilder();
        while (decimalNumber != 0) {
            sb.append(decimalNumber < 0 ? '1' : '0');
            decimalNumber <<= 1;
        }
        System.out.println(sb.reverse().toString());
    }
    public static void main(String[] args) {
        decimalToBinary(10);
        decimalToBinary(-10);
        decimalToBinary(128);
        decimalToBinary(-128);
    }
}
