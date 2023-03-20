import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x;
        boolean result;
        int resultInt;

        System.out.println("определение положительного числа");
        System.out.print("введите число:");
        x = scanner.nextInt();
        result = IsPositiv(x);
        if (result) {
            System.out.println("Число положительное");
        } else  {
            System.out.println("Число отрицательное");
        }
        System.out.println();

        System.out.println("определение орицательного числа");
        System.out.print("введите число:");
        x = scanner.nextInt();
        result = IsNeqativ(x);
        if (result) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
        System.out.println();

        System.out.println("определение числа на равестро 0");
        System.out.print("введите число:");
        x = scanner.nextInt();
        result = IsZero(x);
        if (result) {
            System.out.println("Число равно 0");
        } else {
            System.out.println("Число не равно 0");
        }
        System.out.println();


        System.out.println("определение четного числа");
        System.out.print("введите число:");
        x = scanner.nextInt();
        result = IsEven(x);
        if (result) {
            System.out.println("Число четное");
        } else {
            System.out.println("Число не четное");
        }
        System.out.println();


        System.out.println("определение не четного числа");
        System.out.print("введите число:");
        x = scanner.nextInt();
        result = IsOdd(x);
        if (result) {
            System.out.println("Число не четное");
        } else {
            System.out.println("Число четное");
        }
        System.out.println();


        System.out.println("определение квадрата числа");
        System.out.print("введите число:");
        x = scanner.nextInt();
        resultInt = squaring(x);
        System.out.println("квадрат числа = " + resultInt);
        System.out.println();


        System.out.println("определение куба числа");
        System.out.print("введите число:");
        x = scanner.nextInt();
        resultInt = cubing(x);
        System.out.println("куб числа = " + resultInt);
        System.out.println();



        System.out.println("возведение числа в степень");
        System.out.print("введите число:");
        x = scanner.nextInt();
        int degree;
        System.out.print("введите степень больше 1:");
        degree = scanner.nextInt();
        resultInt = pow(x, degree);
        System.out.println("число " + x + " в степени " + degree + " = " + resultInt);
        System.out.println();



        System.out.println("Суммирование чисел");
        System.out.print("введите первое слогаемое:");
        x = scanner.nextInt();
        int y;
        System.out.print("введите второе слогаемое:");
        y = scanner.nextInt();
        resultInt = summa(x, y);
        if (x != resultInt) System.out.println("Сумма " + x + " + " + y + " = " + resultInt);
        System.out.println();


    }


    /**
     * Определение положительного числа
     * @param x число
     * @return boolean
     */
    public static boolean IsPositiv(int x) {
        return x >= 0 ? true : false;
    }
    /**
     * Определение отрицательного числа
     * @param x число
     * @return boolean
     */
    public static boolean IsNeqativ(int x) {
        return  !IsPositiv(x);
    }
    /**
     * Определение ноля
     * @param x число
     * @return boolean
     */
    public static boolean IsZero(int x) {
        return x == 0 ? true : false;
    }

    /**
     * Определение четного числа
     * @param x число
     * @return boolean
     */
    public static boolean IsEven(int x) {
        return x % 2 == 0 ? true : false;
    }

    /**
     * Определение отрицательного числа
     * @param x число
     * @return boolean
     */
    public static boolean IsOdd(int x) {
        return !IsEven(x);
    }

    /**
     * возведение числа в квадрат
     * @param x число
     * @return int
     */
    public static int squaring(int x) {
        return x * x;
    }

    /**
     * возведение числа в куб
     * @param x число
     * @return int
     */
    public static int cubing(int x) {
        return squaring(x) * x;
    }

    /**
     * Возведение числа в степень
     * @param x число
     * @param degree степень
     * @return значение
     */
    public static int pow(int x, int degree) {
        int y = x;
        if (degree <= 1 ) {
            System.out.println("Степень должна быть больше 1");
        }else {
            for (int i = 1; i < degree; i++) {
                y*=x;
            }
        }
        return y;
    }

    /**
     * Сумма двух чисел
     * @param a слогаемое
     * @param b слогаемое
     * @return сумма
     */
    public static int summa(int a, int b) {
        return a + b;
    }

}