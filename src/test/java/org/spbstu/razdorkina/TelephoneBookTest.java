package org.spbstu.razdorkina;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneBookTest {

    private TelephoneBook book;

    /**
     * Creating telephone book and adding of base contacts
     */
    @BeforeEach
    void setUp() {
        book = new TelephoneBook();
        book.addUser("Alotof Numbers", "456");
        book.searchByName("Alotof Numbers").addNumber("+79582204220");
        book.searchByName("Alotof Numbers").addNumber("8-952-321-45");
    }

    /**
     * Checking methods searchByName() and getNumbers()
     */
    @Test
    void searchByName_and_GetNumbers() {
        book.addUser("name", "898727");
        book.addUser("name", "565919");
        final User found = book.searchByName("name");
        ArrayList<String> answer = new ArrayList<>();
        answer.add("898727");
        answer.add("565919");
        assertEquals(answer, found.getNumbers());
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
        assertTrue(book.deleteUser(book.searchByNumber("+79582204220").getName()));
        assertNull(book.searchByNumber("456"));
        assertFalse(book.deleteUser("Katya"));
    }

}
