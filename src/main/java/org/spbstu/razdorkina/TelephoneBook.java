package org.spbstu.razdorkina;

import java.util.ArrayList;
import java.util.Objects;

/**
 * TelephoneBook
 */
public class TelephoneBook {


    /**
     * Array of User class objects
     */
    final private ArrayList<User> users;

    /**
     * Array of User class objects is creating in constructor
     */
    public TelephoneBook() {
        users = new ArrayList<>();
    }

    /**
     * Search of User class object by number
     *
     * @param numberIn number for search
     * @return User object
     */
    User searchByNumber(String numberIn) {
        for (User user : users) {
            for (String hNumber : user.getNumbers()) {
                if (hNumber.equals(numberIn))
                    return user;
            }
        }
        return null;
    }

    /**
     * Search of User class object by name
     *
     * @param nameIn name for search
     * @return User object
     */
    User searchByName(String nameIn) {
        for (User user : users) {
            if (user.getName().equals(nameIn))
                return user;
        }
        return null;
    }

    /**
     * Adding a contact
     *
     * @param nameIn   name of contact
     * @param numberIn number of contact
     */
    void addUser(String nameIn, String numberIn) {
        final User local = new User(nameIn, numberIn);
        users.add(local);
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        for (User user : users
                ) {
            str.append(user.toString()).append(" ");
        }
        return "TelephoneBook{" +
                "users=" + str +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TelephoneBook that = (TelephoneBook) o;
        return Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    /**
     * Deleting of a contact from users array
     *
     * @param user contact for deleting
     */
    boolean deleteUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }
}

