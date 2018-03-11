import java.util.ArrayList;

/**
 * Класс, содержащий саму механику телефонной книги
 */
class TelephoneBook {


    /**
     * Массив объектов класса User
     */
    private ArrayList<User> users;

    /**
     * Массив объектов класса User создатся в конструкторе
     */
    TelephoneBook(){
        users = new ArrayList<>();
    }

    /**
     * Метод поиска объекта User по номеру
     * @param numberIn номер для поиска
     * @return возвращает объект User
     */
    User searchByNumber (String numberIn){
        for (User user : users) {
            for (String hNumber: user.getNumbers()) {
                if (hNumber.equals(numberIn))
                    return user;
            }
        }
        //System.out.println("Человек с таким номером не найден");
        return null;
    }

    /**
     * Метод поиска объекта User по имени
     * @param nameIn имя для поиска
     * @return возвращает объект User
     */
    User searchByName (String nameIn){
        for (User user : users) {
            if (user.getName().equals(nameIn))
                return user;
        }
        //System.out.println("Человек с таким именем не найден");
        return null;
    }

    /**
     * Метод добавления контакта
     * @param nameIn имя контакта
     * @param numberIn номер контакта
     */
    void addUser (String nameIn, String numberIn){
        User local = new User(nameIn, numberIn);
        users.add(local);
    }

    /**
     * Метод удаления контакта из массива
     * @param user объект для удаления
     */
    void deleteUser (User user){
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).equals(user))
                users.remove(i);
        }
    }
}

