package com.company;

/**
 * An implementation of the Caesar cipher algorithm.
 */
public class CaesarCipher {
    private static final String ALPHABET = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

    public static void main(String[] args) {
        System.out.print(encrypt("абвгґд", 1));
    }

    private static String encrypt(String text, int secretNumber) {
        if (!text.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < text.toLowerCase().length(); i++) {
                char shift = shift(text.charAt(i), secretNumber);
                sb.append(shift);
            }
            return sb.toString();
        }
        return "Text is empty";
    }

    private static char shift(char symbol, int secretNumber) {
        int symbolIndex = ALPHABET.indexOf(symbol);

        if (symbolIndex != -1) {
            return ALPHABET.charAt((symbolIndex + secretNumber) % ALPHABET.length());
        } else {
            return symbol;
        }
    }
}