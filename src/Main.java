import org.javatuples.Pair;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

enum ActionСodes {

    EXIT(0),

    //1)Добавить слово
    ADD(1),
    //2)Перевести
    TRANSLATE(2),
    
    //4)Вывести весь словарь,
    SHOW_ALL(3),

    //5)удалить какое-то слово,
    REMOVE(4);

    ActionСodes(int codeAction) {
        this.code = codeAction;
    }

    public static ActionСodes byOrdinal(int ord) throws Exception {
        for (ActionСodes m : ActionСodes.values()) {
            if (m.code == ord) {
                return m;
            }
        }
        throw new Exception("Не правильный код выбора");
    }
    private final int code;
}
public class Main {
    public  static  LanguageDictionary  languageDictionary = new LanguageDictionary("RU", "EN");

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        ActionСodes selectCodeAction;

        do {
            System.out.println("Выберите действие:" );
            System.out.println("""
                        0 - Выход
                        1 - Добавить запись
                        2 - Перевести
                        3 - Показать все записи
                        4 - Удалить Запись
                      
                    """);
            try {
                Scanner scanner = new Scanner(System.in);
                Integer select = scanner.nextInt();
                selectCodeAction = ActionСodes.byOrdinal(select);

                if (selectCodeAction == ActionСodes.EXIT) {
                    break;
                }

                switch (selectCodeAction) {
                    case ADD -> AddWord();
                    case SHOW_ALL -> ShowAllWords();
                    case REMOVE -> RemoveWord();
                    case TRANSLATE -> TranslateWord();
                   
                    default -> System.out.println("Не правильный выбор");
                }

            } catch (Exception e) {
                System.out.println("Не правильный выбор");
            }

        } while (true);
    }

    private static void TranslateWord() {
        System.out.print("Введите слово для перевода:" );
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        String translate = languageDictionary.translate(word);
        if(translate != null) {
            System.out.println(word + " => " + translate);
        } else {
            System.out.println("Такого слова нет в словаре");
            System.out.println("Введите перевод для добавления слова в словарь или пустую строку для возврата в меню");
            System.out.print(": ");
            Scanner scanner2 = new Scanner(System.in);
            String translate2 = scanner2.nextLine();
            if(translate2.length() > 0) {
                languageDictionary.addWord(word, translate2);
            }
        }
    }

    private static void RemoveWord() {
        System.out.print("Введите слово для удаления:" );
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        Boolean isRemove = languageDictionary.remove(word);
        if(isRemove) {
            System.out.println("Cлово " + word + " удалено");
        } else {
            System.out.println("Такого слова нет в словаре");
        }
    }

    private static void ShowAllWords() {
        System.out.println("содержимое словаря " + languageDictionary.getDirectionStr());
        languageDictionary.showAll();
    }

    private static void AddWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("введите слово для добавления: ");
        String word = scanner.next();
        System.out.println();
        System.out.print("введите пеервод: ");
        String translate = scanner.next();
        System.out.println();

        if(word.length() > 0 && translate.length() > 0) {

            Boolean result = languageDictionary.addWord(word, translate);
            if (result) {
                System.out.println("Слово добавлено");
            } else {
                System.out.println("Такое слово уж есть в словаре");
            }
        } else {
            System.out.println("Слова не могут быть пустыми");
        }
    }

}


class LanguageDictionary {

    TreeMap<String, String> list = new TreeMap<>();

    /**
     * признак с какого языка переводим
     */
    private String langFrom;

    /**
     * Признак на какой язык переводим
     */
    private String langTo;

    LanguageDictionary(String from, String to) {
        this.langFrom = from;
        this.langTo = to;
    }


    public String getLangFrom() {
        return langFrom;
    }

    public String getLangTo() {
        return langTo;
    }

    /**
     *  для дальнейшего включения в соллекцию словарей
     * @return
     */
    public Pair<String,String> getDirection() {
        return new Pair<String, String>(langFrom, langTo);
    }

    /**
     * вывод текстового представления направления перевода
     * @return
     */
    public String getDirectionStr() {
        return langFrom + " => " + langTo;
    }



    Boolean addWord(String word, String translate) {
        if (this.list.containsKey(word)) {
            return false;
        } else {
            this.list.put(word, translate);
            return true;
        }
    }
    String translate(String word) {
        return this.list.get(word);
    }


    void showAll() {

        Set<String> keys = this.list.keySet();

        keys.forEach( word -> {
            System.out.println(word + " => " + this.list.get(word));
        });

    }


    Boolean remove(String word) {
        if(list.containsKey(word)) {
            this.list.remove(word);
            return true;
        } else {
            return false;
        }
    }
}