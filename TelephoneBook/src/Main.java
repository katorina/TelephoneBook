import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Главный класс используется для тестирования
 */
class Main {

    private TelephoneBook book;

    /**
     * Создание телефонной книги и добавление в неё трёх базовых контактов
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
     * Проверка работы методов searchByName() и getNumbers()
     */
    @Test
    void searchByName_and_GetNumbers() {
        assertEquals("456", book.searchByName("Pavel").getNumbers().get(0));
        assertEquals(null, book.searchByName("Pavel1"));
    }

    /**
     * Проверка работы методов searchByNumber() и getName()
     */
    @Test
    void searchByNumber_and_GetName() {
        assertEquals("Ivan", book.searchByNumber("123").getName());
        assertEquals(null, book.searchByNumber("1234"));
    }

    /**
     * Проверка работы метода addUser()
     */
    @Test
    void addUser(){
        assertEquals(null, book.searchByName("Pasha"));
        assertEquals(null, book.searchByNumber("1111111111"));
        book.addUser("Pasha","1111111111");
        assertEquals("1111111111", book.searchByName("Pasha").getNumbers().get(0));
        assertEquals("Pasha", book.searchByNumber("1111111111").getName());
    }

    /**
     * Проверка работы метода deleteUser()
     */
    @Test
    void deleteUser(){
        assertEquals("Ivan", book.searchByNumber("123").getName());
        book.deleteUser(book.searchByNumber("123"));
        assertEquals(null, book.searchByNumber("123"));
    }

    /**
     * Проверка работы метода addNumber()
     */
    @Test
    void addNumber(){
        assertEquals("123", book.searchByName("Ivan").getNumbers().get(0));
        assertEquals(1, book.searchByName("Ivan").getNumbers().size());
        book.searchByName("Ivan").addNumber("987654");
        assertEquals("123", book.searchByName("Ivan").getNumbers().get(0));
        assertEquals("987654", book.searchByName("Ivan").getNumbers().get(1));
    }

    /**
     * Проверка работы метода deleteNumber()
     */
    @Test
    void deleteNumber(){
        book.searchByName("Ivan").addNumber("987654");
        assertEquals("123", book.searchByName("Ivan").getNumbers().get(0));
        assertEquals("987654", book.searchByName("Ivan").getNumbers().get(1));
        book.searchByName("Ivan").deleteNumber("123");
        assertEquals(null, book.searchByNumber("123"));
        assertEquals("987654",book.searchByName("Ivan").getNumbers().get(0));
        book.searchByName("Ivan").deleteNumber("987654");
        assertEquals("987654",book.searchByName("Ivan").getNumbers().get(0));

    }

    /**
     * Проверка работы метода transformNumber() для номеров с * и #
     */
    @Test
    void transformNumber1(){
        book.addUser("Balance", "*100#");
        assertEquals("*100#", book.searchByName("Balance").getNumbers().get(0));
        assertEquals("Balance", book.searchByNumber("*100#").getName());

        book.addUser("IDoNotKnowWhatItHappens", "*110*22*1#");
        assertEquals("*110*22*1#", book.searchByName("IDoNotKnowWhatItHappens").getNumbers().get(0));
        assertEquals("IDoNotKnowWhatItHappens", book.searchByNumber("*110*22*1#").getName());
    }

    /**
     * Проверка работы метода transformNumber() для номеров с +7, 8 и просто +
     */
    @Test
    void transformNumber2(){
        book.addUser("Katya", "89522002020");
        assertEquals("+79522002020", book.searchByName("Katya").getNumbers().get(0));
        book.searchByName("Katya").addNumber("+79522002020");
        book.searchByName("Katya").addNumber("+7-952-200-20-20");
        assertEquals(1, book.searchByName("Katya").getNumbers().size());

        book.addUser("Valery", "+262544896545");
        assertEquals("Valery", book.searchByNumber("+262544896545").getName());
    }
}
