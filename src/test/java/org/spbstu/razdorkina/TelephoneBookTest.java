package org.spbstu.razdorkina;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneBookTest {

    private TelephoneBook book;

    /**
     * Creating telephone book and adding of base contacts
     */

    @BeforeEach
    void setUp() {
        book = new TelephoneBook();
        book.addUser("Ivan", "123");
        book.addUser("Alotof Numbers", "456");
        book.searchByName("Alotof Numbers").addNumber("+7958220");
        book.searchByName("Alotof Numbers").addNumber("8-952-321-45");
    }

    /**
     * Checking methods searchByName() and getNumbers()
     */
    @Test
    void searchByName_and_GetNumbers() {
        assertEquals("456", book.searchByName("Alotof Numbers").getNumbers().get(0));
        assertNull(book.searchByName("Pavel1"));
    }

    /**
     * Checking methods searchByNumber()and getName()
     */
    @Test
    void searchByNumber_and_GetName() {
        assertEquals("Alotof Numbers", book.searchByNumber("8-952-321-45").getName());
        assertNull(book.searchByNumber("1234"));
    }

    /**
     * Checking method deleteUser()
     */
    @Test
    void deleteUser() {
        assertTrue(book.deleteUser(book.searchByNumber("+7958220")));
        assertNull(book.searchByNumber("456"));
        assertFalse(book.deleteUser(book.searchByName("Katya")));
    }

}
