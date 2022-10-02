package com.algorithms.ciphers;

import com.algorithms.utils.checks.Checks;

/**
 * An implementation of the Caesar cipher algorithm.
 */
public class CaesarCipher {

    private static final String ALPHABET = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

    public String encrypt(String text, int secretNumber) {
        Checks.throwExceptionIfParamIsEmptyOrNull(text);
        Checks.throwExceptionIfParamIsEmptyOrNull(secretNumber);
        return getEncryptString(text, secretNumber);
    }

    private String getEncryptString(String text, int secretNumber) {
        if (!text.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            String lowerText = text.toLowerCase();
            for (int i = 0; i < lowerText.length(); i++) {
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