package com.algorithms.ciphers;


import com.algorithms.utils.exceptions.ParamIsNullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CaesarCipherTest {

    private CaesarCipher caesarCipher;

    @BeforeEach
    void setUp() {
        caesarCipher = new CaesarCipher();
    }

    @Test
    void shouldWorkCorrect() {
        String actual = caesarCipher.encrypt("абвгд", 1);
        assertEquals("бвгґе", actual);
    }

    @Test
    void shouldThrowParamIsNullExceptionIfTextIsBlank() {
        assertThrows(ParamIsNullException.class,
                () -> caesarCipher.encrypt("", 1));
    }

    @Test
    void shouldThrowParamIsNullExceptionIfTextIsNull() {
        assertThrows(ParamIsNullException.class,
                () -> caesarCipher.encrypt(null, 1));
    }

    @Test
    void shouldThrowParamIsNullExceptionIfSecretNumberIsNull() {
        assertThrows(ParamIsNullException.class,
                () -> caesarCipher.encrypt("asd", 0));
    }

}