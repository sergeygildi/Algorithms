package company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayListTest {

    private ArrayList<Integer> actual;

    @BeforeEach
    void setUp() {
         actual = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            actual.add(i);
        }
    }

    @Test
    @DisplayName("Should return correct size of the list")
    void add() {
        assertEquals(2000, actual.getSize());
    }

    @Test
    @DisplayName("Should return correct first element")
    void get() {
        Integer actual = this.actual.get(0);
        System.out.println(actual);
        assertEquals(0, actual);
    }

}