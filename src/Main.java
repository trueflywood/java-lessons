import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printPiramid();
        System.out.println("\n");
        printTriangleOne();
        System.out.println("\n");
        printTriangleTwo();
        System.out.println("\n");
        printRomb();
        System.out.println("\n");
        printSquare();
        System.out.println("\n");
    }

    /**
     * переменная отвечающая за символ пустоты
     */
     static String empty = " ";

    /**
     * Символ отвечающий за фигуру
     */
    static String star = "*";
    static Scanner scanner = new Scanner(System.in);
    /**
     * Печать равностороннего треугольника
     */
    public static void printPiramid() {
        System.out.println("введите высоту пирамиды");
        final int line = scanner.nextInt();


        for (int i = 0; i < line; i++) {
            System.out.println(empty.repeat(line - i - 1) + star.repeat(1 + (i * 2)));
        }
        System.out.println("\n");

        // NOTE контур
        for (int i = 0; i < line; i++) {
            if(i == 0 || i == line - 1) {
                System.out.println(empty.repeat(line - i - 1) + star.repeat(1 + (i * 2)));
            } else {
                System.out.println(empty.repeat(line - i - 1) + star + empty.repeat(1 + (i * 2) - 2) + star) ;
            }

        }

    }

    /**
     * Печать прямоугольного треугольника
     */
    public static void printTriangleOne() {
        System.out.println("введите высоту треугольника");
        final int line = scanner.nextInt();

        for (int i = 0; i < line; i++) {
            System.out.println(star.repeat(1 + i));
        }

        System.out.println("\n");

        // NOTE контур
        for (int i = 0; i < line; i++) {
            if(i < 2 || i == line - 1) {
                System.out.println(star.repeat(1 + i));
            } else {
                System.out.println(star + empty.repeat(1 + i -2) + star);
            }

        }
    }

    /**
     * Печать прямоугольного треугольника 2
     */
    public static void printTriangleTwo() {
        System.out.println("введите высоту треугольника");
        final int line = scanner.nextInt();

        for (int i = 0; i < line; i++) {
            System.out.println(star.repeat(line - i));
        }

        System.out.println("\n");

        // NOTE контур
        for (int i = 0; i < line; i++) {
            if(i == 0 || i >= line - 2) {
                System.out.println(star.repeat(line - i));
            } else {
                System.out.println(star + empty.repeat(line - i - 2) + star);
            }

        }
    }


    /**
     * Печать ромбика
     */
    public static void printRomb() {

        String empty = "   ";

        String star = " * ";

        System.out.println("введите длинну стороны ромба");
        final int line = scanner.nextInt();

        for (int i = 0; i < line; i++) {
            System.out.println(empty.repeat(line - i - 1) + star.repeat(1 + (i * 2)));
        }
        for (int i = line-1; i > 0; i--) {
            System.out.println(empty.repeat(line - i) + star.repeat( (i * 2) - 1));
        }

        System.out.println("\n");

        // NOTE контур
        for (int i = 0; i < line; i++) {

            if(i == 0 ) {
                System.out.println(empty.repeat(line - i - 1) + star.repeat(1 + (i * 2)));
            } else {
                System.out.println(empty.repeat(line - i - 1) + star + empty.repeat(1 + (i * 2) - 2) + star) ;
            }
        }
        for (int i = line-1; i > 0; i--) {
            if (i == 1) {
                System.out.println(empty.repeat(line - i) + star.repeat( (i * 2) - 1));
            } else {
                System.out.println(empty.repeat(line - i ) + star + empty.repeat((i * 2) - 3) + star) ;
            }
        }


    }

    /**
     * Печать прямоугольника
     */
    public static void printSquare() {
        String empty = "   ";

        String star = " * ";
        System.out.println("введите высоту прямоугольника");
        final int line = scanner.nextInt();

        System.out.println("введите ширину прямоугольника");
        final int rows = scanner.nextInt();

        for (int i = 0; i < line; i++) {
            System.out.println((star).repeat(rows));
        }
        System.out.println("\n");

        // NOTE контур
        for (int i = 0; i < line; i++) {
            if (i == 0 || i == line -1) {
                System.out.println((star).repeat(rows));
            } else {
                System.out.println(star + (empty).repeat(rows -2) + star);
            }
        }
    }

}