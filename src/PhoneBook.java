import java.util.ArrayList;
import java.util.Scanner;

enum ActionСodes {
    EXIT(0),
    ADD(1),
    SHOW_ONE(2),
    SHOW_ALL(3),
    REMOVE(4),
    REMOVE_ALL(5),
    EDIT(6),
    SEARCH(7),
    SORT(8);
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
                        2 - Показать запись по счету
                        3 - Показать все записи
                        4 - Удалить запись
                        5 - Удалить все записи
                        6 - Изменить запись
                        7 - Найти записи
                        8 - Сортировать записи
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
                    default -> System.out.println("Не правильный выбор");
                }

            } catch (Exception e) {
                System.out.println("Не правильный выбор");
            }

        } while (true);
    }

    private void SearchContacts() {
        System.out.println("SearchContacts");
    }

    private void EditContact() {

    }

    private void RemoveAllContacts() {
        // TODO добавить подтверждение
        book = new ArrayList<>();
        System.out.println("Список очищен");
    }

    private void RemoveContact() {

    }

    private void ShowAllContacts() {
        this.PrintHeader("Контакты");
        for (Contact contact:
                book) {
            System.out.println(contact);
        }
        this.PrintFooter();
    }

    private void ShowContact() {
        Integer lenght = book.toArray().length ;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Выберите порядковый номер записи от 1 до " + (lenght));
                Integer index = scanner.nextInt();
                this.PrintHeader("Запись номер " + index);
                System.out.println( book.toArray()[index - 1]);
                this.PrintFooter();
                break;
            } catch (Exception e) {
                System.out.println("неправильный выбор");
            }
        } while (true);
    }
    private void PrintHeader(String title) {
        System.out.println();
        System.out.println();
        System.out.println(title);
        System.out.println("=========================================");
        System.out.println("| Имя | фамилия | Телефон | Возраст |");
        System.out.println("=========================================");
    }

    private void PrintFooter() {
        System.out.println("=========================================");
        System.out.println();
        System.out.println();
    }

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
