package com.company;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CaesarCipher {
    private static final Logger LOG = Logger.getGlobal();
    private static final String ALPHABET = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

    public static void main(String[] args) {
        LOG.log(Level.INFO, encrypt("абвгґд", 1));
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
        int index = ALPHABET.indexOf(symbol);

        if (index != -1) {
            return ALPHABET.charAt((index + secretNumber) % ALPHABET.length());
        } else {
            return symbol;
        }
    }
}
