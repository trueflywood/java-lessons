import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Урок №2 \n");

        System.out.println("Задание №1 \n");
        System.out.println("Добрый день. Как Ваше имя? ");
        String name = scaner.next();
        System.out.println("Привет, " + name);
        Boolean isNotUsual  = Pattern.matches("[^A-Za-zА-Яа-яёЁ]+", name);
        if (isNotUsual) {
            System.out.println("Не обычное имя.");
        }
        System.out.println("\n\n\n");

        System.out.println("Задание №2 \n");
        final int currentYear = 2023;
        System.out.println("В каком году Вы родились? ");
        int year = scaner.nextInt();
        char isExist = ' ';
        boolean charInRange = false;
        do {
            System.out.println("У Вас в этом году был День Рождения (y/n) ? ");
            isExist = (char) System.in.read();
            charInRange = List.of('y','n').contains(isExist);
        } while (!charInRange);
        int age = currentYear - year - (List.of('y').contains(isExist) ? 0 : 1);
        String[] titles = {"год", "года", "лет"};
        System.out.println("Вам исполнилось " + age + " " + declOfNum(age, titles));

        System.out.println("\n\n\n");

        System.out.println("Задание №3 \n");
        System.out.println("Введите длинну стороны квадрата (целое число)");
        int side = scaner.nextInt();
        System.out.println("Периметр квадрата: " + (side * 4));
        System.out.println("\n\n\n");

        System.out.println("Задание №4 \n");
        System.out.println("Введите длинну радиуса окружности");
        float radius = scaner.nextFloat();
        float S = 3.141592f * radius * radius;
        System.out.printf("Площадь круга:  %.6f ", S);
        System.out.println("\n\n\n");

        System.out.println("Задание №5 \n");
        System.out.println("Введите расстояне между городами (км):");
        float distance = scaner.nextFloat();
        System.out.println("За сколько часов вы хотите добраться?:");
        float time = scaner.nextFloat();
        float speed = distance / time;
        System.out.println("Необходимо двигаться со средней скоростью " + speed + "км/ч");
        System.out.println("\n\n\n");

        System.out.println("Задание №6 \n");
        float curs = 1.2f;
        System.out.println("Введите сумму в долларах");
        float dollarSum = scaner.nextFloat();
        float evroSum = dollarSum/curs;
        System.out.println("Вы получите " + evroSum + " евро");
        System.out.println("\n\n\n");

        System.out.println("Задание №7 \n");
        int fileSize = 820;
        System.out.println("Введите Размер флешки в Гб:");
        float flashSize = scaner.nextFloat();
        int count = (int)(flashSize * 1000 / fileSize); // Согласно стандарту 1 Гб = 1 000 Мб в отличии от 1 ГиБ = 1024 МиБ
        String[] titlesFile = {"фаил", "файла", "файлов"};
        System.out.println("На флешку поместится " + count + " " + declOfNum(count, titlesFile) + " размером " + fileSize + " Мб");
        System.out.println("\n\n\n");

        System.out.println("Задание №8 \n");
        System.out.println("Введите сумму денег в кошельке:");
        float moneySum = scaner.nextFloat();
        System.out.println("Введите цену одной шоколадки:");
        float chocolatePrice = scaner.nextFloat();

        int countChocolate = (int)(moneySum / chocolatePrice);
        String[] titlesChocolate = {"шоколадку", "шоколадки", "шоколадок"};
        System.out.println("На имеющуюся сумму вы сможете купить " + countChocolate + " " + declOfNum(countChocolate, titlesChocolate));
        System.out.println("\n\n\n");
    }

    public static String declOfNum(int  num, String[] titles) {
        int[] cases = {2, 0, 1, 1, 1,2};
        return titles[num % 100 > 4 && num % 100 < 20 ? 2 : cases[num % 10 < 5 ? num % 10 : 5]];
    }
}