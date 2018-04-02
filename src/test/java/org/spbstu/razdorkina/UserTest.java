package org.spbstu.razdorkina;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user1;
    private User user2;

    @BeforeEach
    void setUp() {
        user1 = new User ("Ivan", "123");
        user2 = new User ("Pavel", "456");
        user1.addNumber("987654");
        user2.addNumber("1464847");
    }

    /**
     * Checking method deleteNumber()
     */
    @Test
    void deleteNumber() {
        user1.addNumber("987654");
        user1.deleteNumber("123");
        user2.deleteNumber("456");
        assertEquals("987654", user1.getNumbers().get(0));
        assertTrue(user1.deleteNumber("987654"));
        assertFalse(user1.deleteNumber("2151+189"));
    }

    /**
     * Checking method checkNumber()
     */
    @Test
    void checkNumber() {
        User user4 = new User("Balance", "*100#");
        assertEquals("*100#", user4.getNumbers().get(0));
        assertFalse(user1.addNumber("15+48941*"));
        assertFalse(user1.addNumber("987654"));
    }
}

