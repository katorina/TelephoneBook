package org.spbstu.razdorkina;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Contact class
 */
public class User {

    final private String name;
    /**
     * Contact number
     */
    final private ArrayList<String> numbers = new ArrayList<>();

    /**
     * Creating a contact
     *
     * @param nameIn   the name of contact
     * @param numberIn the number of contact
     */
    public User(String nameIn, String numberIn) {
        name = nameIn;
        if (checkNumber(numberIn)) numbers.add(numberIn);
    }

    final public String getName() {
        return name;
    }

    final ArrayList<String> getNumbers() {
        return numbers;
    }

    /**
     * Number transformation
     *
     * @param number input number
     * @return output number
     */
    private boolean checkNumber(String number) {
        final String checkNumber = number.replaceAll("[-]*", "");
        return checkNumber.matches("[*|+]?\d+#?[\d+]?");
    }

    /**
     * Adding a new number for a contact
     *
     * @param newNumber new number
     */
    boolean addNumber(String newNumber) {
        if (!checkNumber(newNumber))
            return false;
        for (String number : numbers) {
            if (newNumber.equals(number))
                return false;
        }
        numbers.add(newNumber);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return false;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return Objects.equals(user.hashCode(), this.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numbers);
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        for (String s :
                numbers) {
            str.append("'").append(s).append("' ");
        }
        str.deleteCharAt(str.length() - 1);
        return "User{" +
                "name='" + name + '\'' +
                ", numbers=" + str +
                '}';
    }

    /**
     * Deleting a number of a contact
     *
     * @param delNumber number for deleting
     */
    boolean deleteNumber(String delNumber) {
        if (!checkNumber(delNumber))
            return false;
        if (numbers.size() == 1 && delNumber.equals(numbers.get(0))) {
            numbers.remove(0);
            return true;
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(delNumber)) {
                numbers.remove(i);
                return true;
            }
        }
        return false;

    }
}
