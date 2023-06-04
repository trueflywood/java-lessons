import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("введите строку для проверки: ");
        String braseStr = scanner.nextLine();
        System.out.println(validate(braseStr));

    }


    public static boolean validate(String str) {
        final String regex = "^[\\{\\}\\[\\]\\(\\)]+$";
        boolean returnValue;

        // проверка на лишние символы
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(str);

        returnValue = matcher.find();
        if (!returnValue) return returnValue;

        // проверка на на очередность открытых и закрытых скобок
        int openFigureBraceCount = 0;
        int closeFigureBraceCount = 0;
        int openSquareBraceCount = 0;
        int closeSquareBraceCount = 0;
        int openRoundBraceCount = 0;
        int closeRoundBraceCount = 0;

        for (Character c:
             str.toCharArray()) {
            switch (c) {
                case '{' -> openFigureBraceCount++;
                case '}' -> closeFigureBraceCount++;
                case '[' -> openSquareBraceCount++;
                case ']' -> closeSquareBraceCount++;
                case '(' -> openRoundBraceCount++;
                case ')' -> closeRoundBraceCount++;
            }

            if (returnValue && (closeFigureBraceCount > openFigureBraceCount || closeRoundBraceCount > openRoundBraceCount || closeSquareBraceCount > openSquareBraceCount)) {
                returnValue = false;
                break;
            }
        }

        if (!returnValue) return returnValue;

        // проверка на закрытость всех скобок
        if (closeFigureBraceCount != openFigureBraceCount || closeRoundBraceCount != openRoundBraceCount || closeSquareBraceCount != openSquareBraceCount) {
            returnValue = false;
        }
        return returnValue;
    }

}