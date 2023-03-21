import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Калькулятор");
        do {
            System.out.println("Для начала вычислений введите '1'");
            System.out.println("Для выхода из программы введите '0'");
            System.out.print("Ваш выбор:");
            int vibor = scanner.nextInt();
            if(vibor == 0) break;
            if(vibor == 1) {
                getCalcData();
                continue;
            }
            System.out.println("Вы ввели что-то не то...");
        } while (true);
    }

    public static void getCalcData() {
        System.out.print("Введите первое целое число: ");
        int n1 = scanner.nextInt();
        char sign = getSign();
        System.out.print("Введите второе целое число: ");
        int n2 = scanner.nextInt();
        calc(n1, n2, sign);
    }

    public static char getSign() {
        char sign;
        do {
            System.out.print("Введите символ операции (*,/,+,-)");
            String signStr = scanner.next();
            if(signStr.length() == 1 ) {
                sign = signStr.charAt(0);
                if(sign == '*' || sign == '/' || sign == '+' || sign == '-') break;
            }
            System.out.println("Вы ввели что-то не то");

        } while(true);
        return sign;
    }

    public static void calc(int a1 , int a2, char sign) {
        switch (sign) {
            case '*':
                System.out.println("Произведение " + a1 + " * " + a2 + " = " + proizvedneie(a1, a2));
                break;
            case '+':
                System.out.println("Сумма " + a1 + " + " + a2 + " = " + summa(a1, a2));
                break;
            case '-':
                System.out.println("Разность " + a1 + " - " + a2 + " = " + raznost(a1, a2));
                break;
            case '/':
                if (a2 != 0) {
                    float resultInt1 = delenie(a1, a2);
                    System.out.printf("Результат %d / %d = %.2f",  a1,  a2, resultInt1);
                    System.out.println();
                } else {
                    System.out.println("Деление на ноль запрещено");
                }
                break;
            default:
                System.out.println("Если мы сюда попали значит комп сам переписал код и началось восстание машин! )))");
                break;
        }

    }

    public static int summa(int a, int b) {
        return a + b;
    }

    public static float delenie(int a, int b) {
        return (float) a / b;
    }

    public static int proizvedneie(int a, int b) {
        return a * b;
    }

    public static int raznost(int a, int b) {
        return a - b;
    }

}
