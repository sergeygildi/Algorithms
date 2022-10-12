package company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListTest {

    private LinkedList<Integer> integers;

    @BeforeEach
    void setUp() {
        integers = new LinkedList<>();
        for (int i = 0; i < 2000; i++) {
            integers.addLast(i);
        }
    }

    @Test
    @DisplayName("Should return correct size of the list")
    void add() {
        assertEquals(2000, integers.size());
    }

    @Test
    @DisplayName("Should return correct first element")
    void getFirst() {
        Integer actual = this.integers.getFirst();

        assertEquals(0, actual);
    }

    @Test
    @DisplayName("Should return correct last element")
    void getLast() {
        Integer actual = this.integers.getLast();

        assertEquals(1999, actual);
    }

}