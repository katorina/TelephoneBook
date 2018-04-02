package org.spbstu.razdorkina;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneBookTest {

    private TelephoneBook book;

    /**
     * Creating telephone book and adding of 3 base contacts
     * "Ivan", "123"
     * "Pavel", "456"
     * "Masha", "789"
     */

    @BeforeEach
    void setUp() {
        book = new TelephoneBook();
        book.addUser("Ivan", "123");
        book.addUser("Pavel", "456");
        book.addUser("Masha", "789");
    }

    /**
     * Checking methods searchByName() and getNumbers()
     */
    @Test
    void searchByName_and_GetNumbers() {
        assertEquals("456", book.searchByName("Pavel").getNumbers().get(0));
        assertNull(book.searchByName("Pavel1"));
    }

    /**
     * Checking methods searchByNumber()and getName()
     */
    @Test
    void searchByNumber_and_GetName() {
        assertEquals("Ivan", book.searchByNumber("123").getName());
        assertNull(book.searchByNumber("1234"));
        book.searchByName("Ivan").addNumber("1488");
        System.out.print(book.toString());
    }

    /**
     * Checking method addUser()
     */
    @Test
    void addUser() {
        assertNull(book.searchByName("Pasha"));
        assertNull(book.searchByNumber("1111111111"));
        book.addUser("Pasha", "1111111111");
        assertEquals("1111111111", book.searchByName("Pasha").getNumbers().get(0));
        assertEquals("Pasha", book.searchByNumber("1111111111").getName());
    }

    /**
     * Checking method deleteUser()
     */
    @Test
    void deleteUser() {
        assertEquals("Ivan", book.searchByNumber("123").getName());
        assertTrue(book.deleteUser(book.searchByNumber("123")));
        assertNull(book.searchByNumber("123"));
    }

}
