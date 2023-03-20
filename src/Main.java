import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Суммирование чисел");
        System.out.print("введите первое слогаемое:");
        int x = scanner.nextInt();
        System.out.print("введите второе слогаемое:");
        int y = scanner.nextInt();
        System.out.println("Сумма " + x + " + " + y + " = " + summa(x, y));
        System.out.println();


        System.out.println("Деление чисел");
        System.out.print("введите делимое:");
        int x1 = scanner.nextInt();
        System.out.print("введите делитель:");
        int y1 = scanner.nextInt();
        if (y1 != 0) {
            float resultInt1 = delenie(x1, y1);
            System.out.printf("Результат %d / %d = %.2f",  x1,  y1, resultInt1);
            System.out.println();
        } else {
            System.out.println("Деление на ноль запрещено");
        }
        System.out.println();


        System.out.println("Произведение чисел");
        System.out.print("введите первый множитель:");
        int x2 = scanner.nextInt();
        System.out.print("введите второй множитель:");
        int y2 = scanner.nextInt();
        System.out.println("Произведение " + x2 + " * " + y2 + " = " + proizvedneie(x2, y2));
        System.out.println();


        System.out.println("Разность чисел");
        System.out.print("введите уменьшаемое:");
        int x3 = scanner.nextInt();
        System.out.print("введите вычитаемое:");
        int y3 = scanner.nextInt();
        System.out.println("Разность " + x3 + " - " + y3 + " = " + raznost(x3, y3));
        System.out.println();

        // массив
        System.out.println("Заполняем массив");
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("введите элемент массива № " + (i+1) + ":");
            int arrItem = scanner.nextInt();
            arr[i] = arrItem;
            System.out.println();
        }

        System.out.println("печатаем массив");
        Print(arr);
        System.out.println();
        System.out.println("вычисляем максимум");
        int maxElement = arr[0];
        for (int element: arr) {
            if (max(maxElement, element) == -1) {
                maxElement = element;
            }
        }
        System.out.println("Максимальное значение: " + maxElement);


        System.out.println("вычисляем минимум");
        int minElement = arr[0];
        for (int element: arr) {
            if (min(minElement, element) == -1) {
                minElement = element;
            }
        }
        System.out.println("Минимальное значение: " + minElement);

        System.out.println("вычисляем среднее");
        System.out.printf("Среднее значение: %.2f", average(arr));

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

    public static int max(int a, int b) {
        if (a > b) return 1;
        if (b > a) return -1;
        return 0;
    }

    public static  int min(int a, int b) {
        return max(b, a);
    }

    public static float average(int[] arr) {
        float average = 0f;
        if (arr.length > 0) {
            int summ = 0;
            for (int num: arr) {
                summ += num;
            }
            average = (float) summ / arr.length;
        }
        return average;
    }
    
    public static void Print(int[] arr){
        System.out.print('[');

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length-1) System.out.print(",");
        }
        System.out.print(']');
    }
}
