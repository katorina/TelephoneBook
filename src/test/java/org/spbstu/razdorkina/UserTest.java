package test.java.org.spbstu.razdorkina;

import main.java.org.spbstu.razdorkina.TelephoneBook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private TelephoneBook book = new TelephoneBook();

    @BeforeEach
    void setUp() {
        book = new TelephoneBook();
        book.addUser("Ivan", "123");
        book.addUser("Pavel", "456");
        book.addUser("Masha", "789");
    }

    /**
     * Checking method addNumber()
     */
    @Test
    void addNumber() {
        assertTrue(book.searchByName("Ivan").addNumber("987654"));
        assertEquals("123", book.searchByName("Ivan").getNumbers().get(0));
        assertEquals("987654", book.searchByName("Ivan").getNumbers().get(1));
        assertFalse(book.searchByName("Ivan").addNumber("15+48941*"));
        assertFalse(book.searchByName("Ivan").addNumber("987654"));
    }

    /**
     * Checking method deleteNumber()
     */
    @Test
    void deleteNumber() {
        book.searchByName("Ivan").addNumber("987654");
        book.searchByName("Ivan").deleteNumber("123");
        assertNull(book.searchByNumber("123"));
        assertEquals("987654", book.searchByName("Ivan").getNumbers().get(0));
        assertTrue(book.searchByName("Ivan").deleteNumber("987654"));
        assertFalse(book.searchByName("Ivan").deleteNumber("2151+189"));
    }

    /**
     * Checking method transformNumber() for numbers with * and #
     */
    @Test
    void transformNumber1() {
        book.addUser("Balance", "*100#");
        assertEquals("*100#", book.searchByName("Balance").getNumbers().get(0));
        assertEquals("Balance", book.searchByNumber("*100#").getName());
    }
}

