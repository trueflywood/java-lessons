public class Main {
    public static void main(String[] args) {
        printPiramid();
        System.out.println("\n");
        printTriangleOne();
        System.out.println("\n");
        printTriangleTwo();
        System.out.println("\n");
        printSlash();
        System.out.println("\n");
        printBackSlash();
        System.out.println("\n");
        printRomb();
        System.out.println("\n");
        printSquare();
        System.out.println("\n");
        printOctagon();

    }

    /**
     * переменная отвечающая за символ пустоты
     */
     static String empty = " ";

    /**
     * Символ отвечающий за фигуру
     */
    static String star = "*";

    /**
     * Печать равностороннего треугольника
     */
    public static void printPiramid() {
        int line = 8;

        for (int i = 0; i < line; i++) {
            System.out.println(empty.repeat(line - i - 1) + star.repeat(1 + (i * 2)));
        }
    }

    /**
     * Печать прямоугольного треугольника
     */
    public static void printTriangleOne() {
        int line = 7;

        for (int i = 0; i < line; i++) {
            System.out.println(star.repeat(1 + i));
        }
    }

    /**
     * Печать прямоугольного треугольника 2
     */
    public static void printTriangleTwo() {
        int line = 7;

        for (int i = 0; i < line; i++) {
            System.out.println(star.repeat(line - i));
        }
    }

    /**
     * печать символа слеша
     */
    public static void printSlash() {
        int line = 8;

        for (int i = 0; i < line; i++) {
            System.out.println(empty.repeat(line - i - 1) + star);
        }
    }

    /**
     * Печать символа обратного слеша
     */
    public static void printBackSlash() {
        int line = 8;

        for (int i = 0; i < line; i++) {
            System.out.println(empty.repeat(i) + star);
        }
    }

    /**
     * Печать ромбика
     */
    public static void printRomb() {
        int line = 9;

        for (int i = 0; i < line; i++) {
            System.out.println(empty.repeat(line - i - 1) + star.repeat(1 + (i * 2)));
        }
        for (int i = line-1; i > 0; i--) {
            System.out.println(empty.repeat(line - i) + star.repeat( (i * 2) - 1));
        }
    }

    /**
     * Печать прямоугольника
     */
    public static void printSquare() {
        int line = 8;
        int rows = 5;

        for (int i = 0; i < line; i++) {
            System.out.println((star + empty).repeat(rows));
        }

    }

    /**
     * Печать "круга"
     */
    public static void printOctagon() {

        String text = """
             * *
      *               *
   *                     *   

*                           *
*                           *

   *                     *
      *               *
             * *
            """;

        System.out.print(text);
    }

}