package main.java.org.spbstu.razdorkina;

import java.util.ArrayList;

/**
 * TelephoneBook
 */
public class TelephoneBook {


    /**
     * Array of User class objects
     */
    private ArrayList<User> users;

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
    public User searchByNumber(String numberIn) {
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
    public User searchByName(String nameIn) {
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
    public void addUser(String nameIn, String numberIn) {
        User local = new User(nameIn, numberIn);
        users.add(local);
    }

    /**
     * Deleting of a contact from users array
     *
     * @param user contact for deleting
     */
    public boolean deleteUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }
}

