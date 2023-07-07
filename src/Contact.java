public class Contact {
    private String name;
    private String surname;
    private String number;
    private int age;
    private final Integer id;
    static Integer nextId = 1;

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

    public  Integer getId() {
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

    Contact (Integer id, String name, String surname,String number, Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.age = age;
    }


    @Override
    public String toString() {

        return "| "+ padRight(this.id.toString(), MaxLengthFields.maxID) + " | "+ padRight(this.name, MaxLengthFields.maxName) + " | " + padRight(this.surname, MaxLengthFields.maxSurname) + " | " + padRight(this.number, MaxLengthFields.maxNumber) + " | " + padRight(Integer.toString(this.age, 10), MaxLengthFields.maxAge) + " |";
    }

    static String padRight(String s, int n) {
        String x = "";
        if (n - s.length() > 0) {
            x = String.format("%-" + n + "s", s);
        } else {
            x = s;
        }

        return x;
    }

}
