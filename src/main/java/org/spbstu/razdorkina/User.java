package main.java.org.spbstu.razdorkina;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Contact class
 */
public class User {

    private String name;
    /**
     * Contact number
     */
    private ArrayList<String> numbers = new ArrayList<>();

    /**
     * Creating a contact
     *
     * @param nameIn   the name of contact
     * @param numberIn the number of contact
     */
    public User(String nameIn, String numberIn) {
        name = nameIn;
        numbers.add(transformNumber(numberIn));
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    /**
     * Number transformation
     *
     * @param number input number
     * @return output number
     */
    private String transformNumber(String number) {
        final String checkNumber = number.replaceAll("[-]*", "");
        if (!checkNumber.matches("[*+]?\\d+?#?")) return "";
        int plus = 0;
        int asterisk = 0;
        int lattice = 0;
        for (int i = 0; i < checkNumber.length(); i++) {
            switch (checkNumber.charAt(i)) {
                case '+':
                    plus++;
                    break;
                case '*':
                    asterisk++;
                    break;
                case '#':
                    lattice++;
                    break;
            }
        }
        if (plus == 1 && checkNumber.charAt(0) != '+' || plus > 1) return "";
        if (asterisk == 1 && checkNumber.charAt(0) != '*' || asterisk > 1) return "";
        if (lattice == 1 && checkNumber.charAt(checkNumber.length() - 1) != '#' || lattice > 1) return "";
        return number;
    }

    /**
     * Adding a new number for a contact
     *
     * @param newNumber new number
     */
    public boolean addNumber(String newNumber) {
        if (transformNumber(newNumber).isEmpty())
            return false;
        for (String number : numbers) {
            if (newNumber.equals(number))
                return false;
        }
        numbers.add(transformNumber(newNumber));
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(numbers, user.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numbers);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (String s :
                numbers) {
            str.append(s).append(" ");
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
    public boolean deleteNumber(String delNumber) {
        delNumber = transformNumber(delNumber);
        if (delNumber.equals(""))
            return false;
        if (numbers.size() == 1 && delNumber.equals(numbers.get(0))) {
            numbers.remove(0);
            numbers.add("");
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
