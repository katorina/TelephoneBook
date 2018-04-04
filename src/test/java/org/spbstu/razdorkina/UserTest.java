package org.spbstu.razdorkina;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user1;

    @BeforeEach
    void setUp() {
        user1 = new User("Ivan", "123");
    }

    /**
     * Checking method deleteNumber() and checkNumber()
     */
    @Test
    void deleteNumber() {
        assertTrue(user1.addNumber("987654"));
        user1.deleteNumber("123");
        assertEquals("987654", user1.getNumbers().get(0));
        assertTrue(user1.deleteNumber("987654"));
        assertFalse(user1.deleteNumber("2151+189"));
    }

}

