import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.*;


/**
 * коды основного меню
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
        showMainMenu();
    }

    public ArrayList<Contact> getBook() {
        return book;
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
                    case SORT -> this.SortContacts();
                    case SAVE -> this.saveToFile();
                    default -> System.out.println("Не правильный выбор");
                }

            } catch (Exception e) {
                System.out.println("Не правильный выбор");
            }

        } while (true);
    }

    private void SortContacts() {

        enum sortColunm  {
            ID(0), NAME(1), SURNAME(2), PHONE(3);

            sortColunm(int codeAction) {
                this.code = codeAction;
            }

            public static sortColunm byOrdinal(int ord) throws Exception {
                for (sortColunm m : sortColunm.values()) {
                    if (m.code == ord) {
                        return m;
                    }
                }
                throw new Exception("Не правильный код выбора");
            }
            private final int code;
        }

        sortColunm selectCodeAction;
        do {
            System.out.println("Выберите действие:" );
            System.out.println("""
                        0 - ID
                        1 - Имя
                        2 - Фамилия
                        3 - Номер телефона
                    """);

            try {
                Scanner scanner = new Scanner(System.in);
                Integer select = scanner.nextInt();
                selectCodeAction = sortColunm.byOrdinal(select);

                switch (selectCodeAction) {
                    case ID -> this.SortID();
                    case NAME -> this.SortName();
                    case SURNAME -> this.SortSurname();
                    case PHONE -> this.SortPhone();

                    default -> System.out.println("Не правильный выбор");
                }
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true);


    }

    private void SortPhone() {
        List<Contact> sortedBook = this.book.stream().sorted((contact1, contact2) -> contact1.getNumber().compareToIgnoreCase(contact2.getNumber())).toList();
       
        int length =  this.PrintHeader("Контакты (сортировка по номеру)");

        for (Contact contact:
                sortedBook) {
            System.out.println(contact);
        }
        this.PrintFooter(length);
    }

    private void SortName() {
        List<Contact> sortedBook = this.book.stream().sorted((contact1, contact2) -> contact1.getName().compareToIgnoreCase(contact2.getName())).toList();
        int length = this.PrintHeader("Контакты (сортировка по Имени)");
        for (Contact contact:
                sortedBook) {
            System.out.println(contact);
        }
        this.PrintFooter(length);

    }

    private void SortSurname() {
        List<Contact> sortedBook = this.book.stream().sorted((contact1, contact2) -> contact1.getSurname().compareToIgnoreCase(contact2.getSurname())).toList();
        int length = this.PrintHeader("Контакты (сортировка по Фамилии)");
        for (Contact contact:
                sortedBook) {
            System.out.println(contact);
        }
        this.PrintFooter(length);

    }

    private void SortID() {



        List<Contact> sortedBook = this.book.stream().sorted(Comparator.comparing(Contact::getId)).toList();
        int length = this.PrintHeader("Контакты (сортировка по ID)");
        for (Contact contact:
                sortedBook) {
            System.out.println(contact);
        }
        this.PrintFooter(length);

    }

    private void saveToFile() {
        String json = new Gson().toJson(this.book);
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
//        System.out.println("SearchContacts");
//
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("введите строку для поиска:  " );
            String searchStr = scanner.next();

            List<Contact> filtered = this.book.stream().filter(item -> item.getName().toLowerCase().contains(searchStr.toLowerCase()) || item.getSurname().toLowerCase().contains(searchStr.toLowerCase()) || item.getNumber().toLowerCase().contains(searchStr.toLowerCase())).toList();

            int length = this.PrintHeader("Контакты");
            for (Contact contact:
                    filtered) {
                System.out.println(contact);
            }
            this.PrintFooter(length);
            break;

        } while (true);

    }

    /**
     * изменение записи
     */
    private void EditContact() {

        do {
            Scanner scanner = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);
            Scanner scanner3 = new Scanner(System.in);
            Scanner scanner4 = new Scanner(System.in);
            try {
                System.out.print("Выберите id записи:  " );
                Integer id = scanner.nextInt();
                int index = this.idToIndex(id);
                Contact oldContact = book.get(index);




                System.out.print("\nВведите новое имя(" + oldContact.getName() + "): ");
                String name = scanner4.nextLine();
                if(name.equals("")) name = oldContact.getName();
                System.out.print("\nВведите новую фамилию(" + oldContact.getSurname() + "): ");
                String surname = scanner3.nextLine();
                if(surname.equals("")) surname = oldContact.getSurname();

                System.out.print("\nВведите номер(" + oldContact.getNumber() + "): ");
                String number = scanner.nextLine();
                if(number.equals("")) number = oldContact.getNumber();

                Integer age;
                do {
                    try {
                        System.out.print("\nВведите возраст(" + oldContact.getAge() + "):");
                        String newStringAge = scanner2.nextLine();
                        if (newStringAge.equals("")) {
                            age = oldContact.getAge();
                        } else {
                            age =  Integer.parseInt(scanner2.nextLine());
                        }
                        if (age < 1 || age > 120) {
                            throw new Exception("Не правильный возраст");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Возраст не правильный");
                    }

                } while (true);

                Contact contact = new Contact(oldContact.getId(), name,surname,number,age);

                if (this.confirm("Сохранить?")) {

                    this.book.remove(index);
                    this.book.add(index, contact);
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
        if(this.confirm()) {
            book = new ArrayList<>();
            System.out.println("Список очищен");
        }
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
     private int nameToIndex(String name) throws Exception {
        Boolean success = false;
        int index = 0;
        for (int i = 0; i < book.toArray().length; i++) {
            if (book.get(i).getName().equalsIgnoreCase(name) ) {
                index = i;
                success = true;
            }
        }
        if (!success) throw new Exception("запись с таким именем не найдена");
        return index;
    }
    private int surnameToIndex(String surname) throws Exception {
        Boolean success = false;
        int index = 0;
        for (int i = 0; i < book.toArray().length; i++) {
            if (book.get(i).getSurname().equalsIgnoreCase(surname) ) {
                index = i;
                success = true;
            }
        }
        if (!success) throw new Exception("запись с такой фамилией не найдена");
        return index;
    }
    private int phoneToIndex(String phone) throws Exception {
        Boolean success = false;
        int index = 0;
        for (int i = 0; i < book.toArray().length; i++) {
            if (book.get(i).getNumber().equalsIgnoreCase(phone) ) {
                index = i;
                success = true;
            }
        }
        if (!success) throw new Exception("запись с таким телефоном не найдена");
        return index;
    }



    /**
     * удаление контакта по id
     */
    private void RemoveContact() {
        MenuRemoveContact menu = new MenuRemoveContact();
        try {
            MenuRemoveContact.ActionСodes code = menu.showMainMenu();
            switch (code) {
                case ID -> removeContactById();
                case NAME -> removeContactByName();
                case SURNAME -> removeContactBySurname();
                case PHONE -> removeContactByPhone();
            }
        } catch (Exception e) {
            System.out.println("Не правильный код выбора");
        }


    }

    private void removeContactByPhone() {
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Введите телефон:  " );
                String phone = scanner.nextLine();
                if (this.confirm()) {
                    int phoneIndex = this.phoneToIndex(phone);
                    book.remove(phoneIndex);
                }
                this.ShowAllContacts();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

    }

    private void removeContactBySurname() {
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Введите фамилию:  " );
                String surname = scanner.nextLine();
                if (this.confirm()) {
                    int nameIndex = this.surnameToIndex(surname);
                    book.remove(nameIndex);
                }
                this.ShowAllContacts();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

    }

    private void removeContactByName() {
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print("Введите имя:  " );
                String name = scanner.nextLine();
                if (this.confirm()) {
                    int nameIndex = this.nameToIndex(name);
                    book.remove(nameIndex);
                }
                this.ShowAllContacts();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true);

    }

    private void removeContactById() {
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
        return confirm("Вы уверены?");
    }

    private boolean confirm(String text  ) {
        Boolean answer = false;
        do {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.print(text + " (y/n)");
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
        int length = this.PrintHeader("Контакты");

        
        for (Contact contact:
                book) {
            System.out.println(contact);

        }
        this.PrintFooter(length);
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
                int length = this.PrintHeader("Запись " + index);
                System.out.println( book.toArray()[index]);
                this.PrintFooter(length);
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
    private int PrintHeader(String title) {
        System.out.println();
        System.out.println();
        System.out.println(title);
        MaxLengthFields.reset();
        getMaxLength();
        String head = "| "+ Contact.padRight("ID", MaxLengthFields.maxID)+" | "+ Contact.padRight("Имя", MaxLengthFields.maxName)+" | "+ Contact.padRight("Фамилия", MaxLengthFields.maxSurname)+" | "+ Contact.padRight("Телефон", MaxLengthFields.maxNumber)+" | "+ Contact.padRight("Возраст", MaxLengthFields.maxAge)+" |";
        System.out.println("=".repeat(head.length()));
        System.out.println(head);
        System.out.println("=".repeat(head.length()));
        return head.length();
    }

    private void getMaxLength() {

        for (Contact contact:
                book) {

            MaxLengthFields.maxID = Math.max(MaxLengthFields.maxID, contact.getId().toString().length());
            MaxLengthFields.maxName = Math.max(MaxLengthFields.maxName, contact.getName().length());
            MaxLengthFields.maxSurname = Math.max(MaxLengthFields.maxName, contact.getName().length());
            MaxLengthFields.maxNumber = Math.max(MaxLengthFields.maxNumber, contact.getNumber().length());
            MaxLengthFields.maxAge = Math.max(MaxLengthFields.maxAge, Integer.toString(contact.getAge()).length() );
        }
    }

    /**
     * Печать низа списка
     */
    private void PrintFooter(int length) {
        System.out.println("=".repeat(length));
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

class MenuRemoveContact  {

    enum ActionСodes {
        ID(0, "по id" ),
        NAME(1, "по имени"),
        SURNAME(1, "по фамилии"),
        PHONE(1, "по телефону");


        ActionСodes(int codeAction, String text) {
            this.code = codeAction;
            this.text = text;
        }

        public static MenuRemoveContact.ActionСodes byOrdinal(int ord) throws Exception {
            for (MenuRemoveContact.ActionСodes m : MenuRemoveContact.ActionСodes.values()) {
                if (m.code == ord) {
                    return m;
                }
            }
            throw new Exception("Не правильный код выбора");
        }
        private final int code;
        private final String text;

    }

    public MenuRemoveContact.ActionСodes showMainMenu() throws Exception {
        MenuRemoveContact.ActionСodes selectCodeAction;

        do {
            System.out.println("Выберите действие:" );
            for (MenuRemoveContact.ActionСodes m : MenuRemoveContact.ActionСodes.values()) {
                System.out.println("    " + m.code + " - " + m.text);
            }

            try {
                Scanner scanner = new Scanner(System.in);
                Integer select = scanner.nextInt();
                selectCodeAction = MenuRemoveContact.ActionСodes.byOrdinal(select);
                return  selectCodeAction;
            } catch (Exception e) {
                System.out.println("Не правильный код выбора");
                throw new Exception("Не правильный код выбора");
            }
        } while (true);
    }

    
}

