import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Задание №1 \n");
        System.out.println("Если переменная a равна 10, то выведите 'Верно', иначе выведите 'Неверно'");
        System.out.println("введите число 10");

        int a = scanner.nextInt();
        if (a == 10 ) {
            System.out.println("Верно");
        } else {
            System.out.println("Неверно");
        }
        System.out.println("\n\n\n");

        System.out.println("Задание №2 \n");
        System.out.println("В переменной min лежит число от 0 до 59. Определите в какую четверть часа попадает это число (в первую, вторую, третью или четвертую)");
        System.out.println("введите количество минут");

        int min = scanner.nextInt();
        if (min < 0 || min > 59) {
            System.out.println("Неправильное число");
        }
        int quarter = ((int) min/15);
        switch (quarter) {
            case 0:
                System.out.println("Первая четверть часа");
                break;
            case 1:
                System.out.println("Втоорая четверть часа");
                break;
            case 2:
                System.out.println("Третья четверть часа");
                break;
            case 3:
                System.out.println("Четвертая четверть часа");
                break;
            default:
                System.out.println("Ошибка в программе");
                break;
        }

        System.out.println("\n\n\n");


        System.out.println("Задание №3 \n");
        System.out.println("Если переменная a больше нуля, то выведите 'Верно', иначе выведите 'Неверно'. Проверьте работу скрипта при a, равном 1, 0, -3.");
        System.out.println("введите число больше нуля");
        int a3 = scanner.nextInt();
        if (a3 > 10) {
            System.out.println("Верно");
        } else {
            System.out.println("Неверно");
        }
        System.out.println("\n\n\n");


        System.out.println("Задание №4 \n");
        System.out.println("Если переменная a меньше нуля, то выведите 'Верно', иначе выведите 'Неверно'. Проверьте работу скрипта при a, равном 1, 0, -3.");
        System.out.println("введите число меньше ноля");
        int a4 = scanner.nextInt();
        if (a4 < 0) {
            System.out.println("Верно");
        } else {
            System.out.println("Неверно");
        }

        System.out.println("\n\n\n");


        System.out.println("Задание №5 \n");
        System.out.println("Если переменная a больше или равна нулю, то выведите 'Верно', иначе выведите 'Неверно'. Проверьте работу скрипта при a, равном 1, 0, -3");
        System.out.println("введите число больше или равна нулю");

        int a5 = scanner.nextInt();
        if (a5 >= 0) {
            System.out.println("Верно");
        } else {
            System.out.println("Неверно");
        }

        System.out.println("\n\n\n");


        System.out.println("Задание №6 \n");
        System.out.println("Если переменная a меньше или равна нулю, то выведите 'Верно', иначе выведите 'Неверно'. Проверьте работу скрипта при a, равном 1, 0, -3.");
        System.out.println("введите число меньше или равное нулю");
        int a6 = scanner.nextInt();
        if (a6 <= 0) {
            System.out.println("Верно");
        } else {
            System.out.println("Неверно");
        }

        System.out.println("\n\n\n");


        System.out.println("Задание №7 \n");
        System.out.println("Если переменная a не равна нулю, то выведите 'Верно', иначе выведите 'Неверно'. Проверьте работу скрипта при a, равном 1, 0, -3.");
        System.out.println("введите число введите число не равное нулю");

        int a7 = scanner.nextInt();
        if (a7 != 0) {
            System.out.println("Верно");
        } else {
            System.out.println("Неверно");
        }

        System.out.println("\n\n\n");


        System.out.println("Задание №8 \n");
        System.out.println("Если переменная a равна 'test', то выведите 'Верно', иначе выведите 'Неверно'. Проверьте работу скрипта при a, равном 'test', 'тест', 3.");
        System.out.println("введите слово 'test'");
        String a8 = scanner.next();
        if (a8.equals("test")) {
            System.out.println("Верно");
        } else {
            System.out.println("Неверно");
        }

        System.out.println("\n\n\n");


        System.out.println("Задание №9 \n");
        System.out.println("Если переменная a равна '1' и по значению и по типу, то выведите 'Верно', иначе выведите 'Неверно'. Проверьте работу скрипта при a, равном '1', 1, 3.");
        System.out.println("введите число 1");
        String a9 = scanner.next();
        if (a9.equals("1")) {
            System.out.println("Верно");
        } else {
            System.out.println("Неверно");
        }
        System.out.println("\n\n\n");


        System.out.println("Задание №10 \n");
        System.out.println("Есть три числа (a,b,c) c помощью if else  выведите максимум и минимум");
        System.out.println("введите число 'a'");
        int a10 = scanner.nextInt();
        System.out.println("введите число 'b'");
        int b10 = scanner.nextInt();
        System.out.println("введите число 'c'");
        int c10 = scanner.nextInt();
        int maxVal = getMax3(a10,b10,c10);
        int minVal = getMin3(a10,b10,c10);

        System.out.println("максимум = " + maxVal);
        System.out.println("минимум = " + minVal);
        System.out.println("\n\n\n");


        System.out.println("Задание №11 \n");
        System.out.println("Есть число (a) вывести  положительное или отрицательное");
        System.out.println("введите число ");
        int a11 = scanner.nextInt();
        if (a11 >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }

        System.out.println("\n\n\n");


        System.out.println("Задание №12 \n");
        System.out.println("Есть число (a) вывести  четное не четное");
        System.out.println("введите число");
        int a12 = scanner.nextInt();
        if (a12 % 2 == 0) {
            System.out.println("Число четное");
        } else {
            System.out.println("Число не четное");
        }

        System.out.println("\n\n\n");


    }

    private static int getMin3(int a10, int b10, int c10) {
        int min = a10;
        if (a10 <= b10 && a10 <= c10) min = a10;
        if (b10 <= a10 && b10 <= c10) min = b10;
        if (c10 <= a10 && c10 <= b10) min = c10;
        return min;
    }

    private static int getMax3(int a10, int b10, int c10) {
        int max = a10;
        if (a10 >= b10 && a10 >= c10) max = a10;
        if (b10 >= a10 && b10 >= c10) max = b10;
        if (c10 >= a10 && c10 >= b10) max = c10;
        return max;
    }
}