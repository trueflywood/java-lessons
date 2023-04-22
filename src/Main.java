public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone("+74872700007", "Sumsung", 150);
        System.out.println(phone);
        Phone phone2 = new Phone("+74872700088", "Sumsung", 170);
        System.out.println(phone2);
        Phone phone3 = new Phone("+74872700099", "Sumsung", 200);
        System.out.println(phone3);
        phone.receiveCall("Юра");
        System.out.print(" на номер " + phone.getNumber());
        System.out.println();
        phone2.receiveCall("Катя");
        System.out.print(" на номер " + phone2.getNumber());
        System.out.println();
        phone3.receiveCall("Саша");
        System.out.print(" на номер " + phone3.getNumber());
        System.out.println();

        phone.receiveCall("Юра", "+74526700588");
        phone2.receiveCall("Маша", "+74556700588");
        phone3.receiveCall("Женя", "+74578700588");

        System.out.println("\nОтправка сообщений по номерам: ");
        phone.sendMessage("Приходите в гости","+74526700588", "+74556700588", "+74578700588");

    }
}
class Phone {
    String number;
    String model;
    int weight;

    public Phone() {
        this.number = "";
        this.model = "";
        this.weight = 0;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
        this.weight = 0;
    }

    public Phone(String number, String model, int weight) {
        this(number, model);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "model = " + this.model + "\n" + "number = " + this.number + "\n" +"weight = " + this.weight + "\n ";
    }

    public void receiveCall(String name) {
        System.out.print("Звонит " + name);
    }
    public void receiveCall(String name, String phone) {
        System.out.println("Звонит " + name + " (" + phone + ") ");
    }
    public void sendMessage(String message, String ...numbers) {
        for (String number :
                numbers) {
            System.out.println("Сообщение \"" + message + "\" было отправлено на " + number);
        }
    }


    public String getNumber() {
        return this.number;
    }
}