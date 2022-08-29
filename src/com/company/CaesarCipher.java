package com.company;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CaesarCipher {
    private static Logger logger = Logger.getGlobal();
    private static final String ALPHABET = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

    public static void main(String[] args) {
        logger.log(Level.INFO, encryption("абвгґд", 33));
    }

    private static String encryption(String text, int secretNumber) {
        if (text.isEmpty()) {
            logger.warning("Text is empty");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.toLowerCase().length(); i++) {
            char shift = shift(text.charAt(i), secretNumber);
            sb.append(shift);
        }
        return sb.toString();
    }

    private static char shift(char symbol, int secretNumber) {
        if (ALPHABET.indexOf(symbol) != -1) {
            return ALPHABET.charAt((ALPHABET.indexOf(symbol) + secretNumber) % ALPHABET.length());
        } else {
            return symbol;
        }
    }
}
