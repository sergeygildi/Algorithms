package com.algorithms.ciphers;


import com.algorithms.utils.exceptions.ParamIsNullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("CaesarCipher should")
class CaesarCipherTest {

    private CaesarCipher caesarCipher;

    @BeforeEach
    void setUp() {
        caesarCipher = new CaesarCipher();
    }

    @Test
    @DisplayName("work correct")
    void shouldWorkCorrect() {
        String actual = caesarCipher.getEncryptString("абвгд", 1);
        assertEquals("бвгґе", actual);
    }

    @Test
    @DisplayName("throw an exception if the input is blank")
    void blankInput() {
        assertThrows(ParamIsNullException.class,
                () -> caesarCipher.getEncryptString("", 1));
    }

    @Test
    @DisplayName("throw an exception if the text input is null")
    void nullTextInput() {
        assertThrows(ParamIsNullException.class,
                () -> caesarCipher.getEncryptString(null, 1));
    }

    @Test
    @DisplayName("throw an exception if the secret number input is null")
    void nullSecretNumberInput() {
        assertThrows(ParamIsNullException.class,
                () -> caesarCipher.getEncryptString("asd", 0));
    }

}