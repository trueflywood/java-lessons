public class Contact {
    private String name;
    private String surname;
    private String number;
    private int age;
    private final int id;
    static int nextId = 1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  int getId() {
        return id;
    }

    Contact() {
        this.id = Contact.nextId++;
    }

    Contact(Contact contact) {
        this();
        this.name = contact.name;
        this.surname = contact.surname;
        this.number = contact.number;
        this.age = contact.age;
    }

    Contact (Integer id, String name, String surname, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    @Override
    public String toString() {
        return "| "+ this.id + "| "+ this.name + " | " +this.surname + " | " +this.number + " | " +this.age + " |";
    }


}
