import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntToDoubleFunction;


/**
 * коды меню
 */
enum ActionСodes {
    EXIT(0),
    ADD(1),
    SHOW_ONE(2),
    SHOW_ALL(3),
    REMOVE(4),
    REMOVE_ALL(5),
    EDIT(6),
    SEARCH(7),
    SORT(8),
    SAVE(9);

    ActionСodes(int codeAction) {
        this.code = codeAction;
    }

    public static ActionСodes byOrdinal(int ord) throws Exception {
        for (ActionСodes m : ActionСodes.values()) {
            if (m.code == ord) {
                return m;
            }
        }
        throw new Exception("Не правильный код выбора");
    }
    private final int code;


}
public class PhoneBook {
    private ArrayList<Contact> book;

    {
        book = new ArrayList<>();
    }
    public PhoneBook() {
        showMainMenu();
    }
    public PhoneBook(PhoneBook book) {
        this.book = new ArrayList<Contact>(book.getBook());
        showMainMenu();
    }

    public PhoneBook(String jsonData) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Contact>>(){}.getType();
        this.book = gson.fromJson(jsonData, listType);
        System.out.println(this.book.toArray()[0]);
        showMainMenu();
    }



    public ArrayList<Contact> getBook() {
        return book;
    }

    public void setBook(ArrayList<Contact> book) {
        this.book = book;
    }

    public void showMainMenu() {
        ActionСodes selectCodeAction;

        do {
            System.out.println("Выберите действие:" );
            System.out.println("""
                        0 - Выход
                        1 - Добавить запись
                        2 - Показать запись по id
                        3 - Показать все записи
                        4 - Удалить запись по id
                        5 - Удалить все записи
                        6 - Изменить запись
                        7 - Найти записи
                        8 - Сортировать записи
                        9 - Сохранить в фаил
                    """);
            try {
                Scanner scanner = new Scanner(System.in);
                Integer select = scanner.nextInt();
                selectCodeAction = ActionСodes.byOrdinal(select);

                if (selectCodeAction == ActionСodes.EXIT) {
                    break;
                }

                switch (selectCodeAction) {
                    case ADD -> this.AddPhone();
                    case SHOW_ONE -> this.ShowContact();
                    case SHOW_ALL -> this.ShowAllContacts();
                    case REMOVE -> this.RemoveContact();
                    case REMOVE_ALL -> this.RemoveAllContacts();
                    case EDIT -> this.EditContact();
                    case SEARCH -> this.SearchContacts();
                    case SAVE -> this.saveToFile();
                    default -> System.out.println("Не правильный выбор");
                }

            } catch (Exception e) {
                System.out.println("Не правильный выбор");
            }

        } while (true);
    }

    private void saveToFile() {
        String json = new Gson().toJson(this.book);
        System.out.println(json);
        try {
            this.saveJsonBase(json);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private void saveJsonBase (String data) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("base.json");
        out.write(data);
        out.close();
    }

    private void SearchContacts() {
        System.out.println("SearchContacts");
    }

    /**
     * изменение записи
     */
    private void EditContact() { // TODO

        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Выберите id записи:  " );
                Integer id = scanner.nextInt();
                int index = this.idToIndex(id);

                // TODO

                if (this.confirm()) {
                    book.remove(index);
                }
                this.ShowAllContacts();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

    }

    /**
     * Очистка списка
     */
    private void RemoveAllContacts() {
        // TODO добавить подтверждение
        book = new ArrayList<>();
        System.out.println("Список очищен");
    }

    private int idToIndex(int id) throws Exception {
        Boolean success = false;
        int index = 0;
        for (int i = 0; i < book.toArray().length; i++) {
            if (book.get(i).getId() == id) {
                index = i;
                success = true;
            }
        }
        if (!success) throw new Exception("не правильный ID записи");
        return index;
    }

    /**
     * удаление контакта по id
     */
    private void RemoveContact() {
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Выберите id записи:  " );
                Integer id = scanner.nextInt();
                if (this.confirm()) {
                    int index = this.idToIndex(id);
                    book.remove(index);
                }
                this.ShowAllContacts();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

    }

    /**
     * Запрашиваем подтверждение
     * @return
     */
    private boolean confirm() {
        Boolean answer = false;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Вы уверены? (y/n)");
                String answerStr  = scanner.next();
                switch (answerStr) {
                    case "y" -> {
                        answer = true;
                    }
                    case "n" -> {
                        answer =  false;
                    }
                    default -> new Exception("нет такого варианта");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        return answer;
    }

    /**
     * отображение всего списка контактов
     */
    private void ShowAllContacts() {
        this.PrintHeader("Контакты");
        for (Contact contact:
                book) {
            System.out.println(contact);
        }
        this.PrintFooter();
    }

    /**
     * отображение 1 контакта по ID
     */
    private void ShowContact() {
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Выберите id записи:  " );
                Integer id = scanner.nextInt();
                int index = this.idToIndex(id);
                this.PrintHeader("Запись " + index);
                System.out.println( book.toArray()[index]);
                this.PrintFooter();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    /**
     * Печать заголовка списка
     *
     * @param title заголовок
     */
    private void PrintHeader(String title) {
        System.out.println();
        System.out.println();
        System.out.println(title);
        System.out.println("=========================================");
        System.out.println("| ID | Имя | фамилия | Телефон | Возраст |");
        System.out.println("=========================================");
    }

    /**
     * Печать низа списка
     */
    private void PrintFooter() {
        System.out.println("=========================================");
        System.out.println();
        System.out.println();
    }

    /**
     * Добавление контакта
     */
    private void AddPhone() {
        System.out.println("AddPhone");
        Contact contact = new Contact();
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите имя:");
        String name = scanner.next();
        contact.setName(name);

        System.out.print("\nВведите фамилию:");
        String surname = scanner.next();
        contact.setSurname(surname);

        System.out.print("\nВведите номер:");
        String number = scanner.next();
        contact.setNumber(number);

        do {
            Scanner scanner2 = new Scanner(System.in);
            try {
                System.out.print("\nВведите возраст:");
                Integer age = scanner2.nextInt();
                if (age < 1 || age > 120) {
                    throw new Exception("Не правильный возраст");
                }
                contact.setAge(age);
                break;
            } catch (Exception e) {
                System.out.println("Возраст не правильный");
            }

        } while (true);

        this.book.add(contact);
        this.ShowAllContacts();

    }


}
