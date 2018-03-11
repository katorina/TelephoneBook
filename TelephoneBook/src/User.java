import java.util.ArrayList;

/**
 * Класс контакта
 */
class User {

    private String name = "";
    /**
     * Номера контакта
     */
    private ArrayList<String> numbers = new ArrayList<>();

    /**
     * Создание контакта
     * @param nameIn имя при создании
     * @param numberIn номер при создании
     */
    User(String nameIn, String numberIn) {
        name = nameIn;
        numbers.add(transformNumber(numberIn));
    }

    public String getName() {
        return name;
    }

    ArrayList<String> getNumbers() {
        return numbers;
    }

    /**
     * Метод трансформации номера в "приятный" вид
     * А именно: удаление чёрточек и # не на последней позиции, а также превращения 8 в +7
     * @param number корявый номер
     * @return приятный номер
     */
    private String transformNumber(String number) {
        String checkNumber = number.replaceAll("[0-9]+|[*#+-]?", "");
        if (!(checkNumber.equals(""))) {
            System.out.println("Некорректно задан номер");
            return null;
        }
        if (number.charAt(number.length()-1) == '#' ){
            number = number.replaceAll("[#]","");
            number = number + "#";
        }
        boolean plus = false;
        if (number.charAt(0) == '+') {
            plus = true;
        }
        number = number.replaceAll("[+-]", "");
        if (number.charAt(0) == '8'){
            number = "7" + number.substring(1);
            plus = true;
        }
        if (plus) {
            number = "+" + number;
        }
        return number;
    }

    /**
     * Метод добавления нового номера контакту
     * @param newNumber новый ноер
     */
    void addNumber(String newNumber) {
        numbers.add(transformNumber(newNumber));
        for (int i = 0; i < numbers.size() - 1; i++){
            for (int j = i + 1; j < numbers.size(); j++){
                if (numbers.get(i).equals(numbers.get(j)))
                    numbers.remove(j);
            }
        }
    }

    /**
     * Метод удаления номер у контакта
     * @param delNumber номер для удаления
     */
    void deleteNumber(String delNumber) {
        if (numbers.size() == 1) {
            //System.out.println("Контакт не может жить без номера");
            return;
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(transformNumber(delNumber)))
                numbers.remove(i);
        }
    }
}
