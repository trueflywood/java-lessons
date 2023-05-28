import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        MenuFileDir fileFolderMenu = new MenuFileDir();

        try {
            MainMenu.ActionСodes action1 = null;
            do {
                action1 =  mainMenu.showMainMenu();
                if (action1 != MainMenu.ActionСodes.EXIT) {
                    MenuFileDir.ActionСodes action2 =  fileFolderMenu.showMainMenu();
                    CRUD.selectAction(action1, action2);
                }
            } while (action1 != MainMenu.ActionСodes.EXIT);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
 class CRUD {

    public static void selectAction(MainMenu.ActionСodes step1, MenuFileDir.ActionСodes step2) {

        if (step2 == MenuFileDir.ActionСodes.FOLDER) {
            switch (step1) {
                case CREATE -> createFolder();
                case READ -> readFolder();
                case UPDATE -> updateFolder();
                case DELETE -> deleteFolder();
            }
        } else {
            switch (step1) {
                case CREATE -> createFile();
                case READ -> readFile();
                case UPDATE -> updateFile();
                case DELETE -> deleteFile();
            }
        }
    }

    public static boolean confirm() {

        String ans = "";
        do {
            System.out.print("вы уверены? (y/n): ");
            Scanner scanner = new Scanner(System.in);
            ans = scanner.nextLine();
        } while (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("n"));
        return ans.equalsIgnoreCase("y");
    }

    public static String getName() {
        System.out.print("Введите имя: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static String getName(String text) {
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String getFileText() {
        System.out.print("Введите текст файла: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

     public static void createFile()  {
         String fileName  = CRUD.getName();
         File file = new File(fileName);

         if (file.isFile()) {
             System.out.println("фаил с таким именем уже существует");
             return;
         }

         try {
             file.createNewFile();
             System.out.println("фаил создан");
         } catch (IOException e) {
             System.out.println("не получилось создать фаил");
         }

         if(file.isFile() && file.canWrite()) {
             String text = CRUD.getFileText();
             try {
                 FileWriter writer = new FileWriter(file);
                 writer.write(text);
                 writer.close();
             } catch (IOException e) {
                 System.out.println("не получилось записать в фаил");
             }
         }
     }
     public static void createFolder() {

        String folderName  = getName();
         File file = new File(folderName);
         if (file.isDirectory()) {
             System.out.println("папка с таким именем уже существует");
             return;
         }

         if (file.mkdir()) {
             System.out.println("папка создана");
         }

    }
     public static void readFile() {

         String fileName  = CRUD.getName();
         File file = new File(fileName);
         if (!file.isFile()) {
             System.out.println("фаил с таким именем не существует");
             return;
         }

         if(file.isFile() && file.canRead()) {
             try {
                 FileReader fr = new FileReader(file);

                 BufferedReader reader = new BufferedReader(fr);

                 String text = reader.readLine();
                 System.out.println(text);
             } catch (IOException e) {
                 System.out.println("не получилось прочитать фаил");
             }
         }



    }
     public static void readFolder() {
         String fileName  = CRUD.getName();
         File file = new File(fileName);
         if (!file.isFile()) {
             System.out.println("папки с таким именем не существует");
             return;
         }

         if(file.isFile() && file.canRead()) {
            File[] list = file.listFiles();
             for (File subFile : list) {
                 System.out.println(subFile.getName() + " - " + (file.isDirectory() ? "папка" : "фаил"));
             }
         }


    }
     public static void updateFile() {

         String fileName  = CRUD.getName();
         File file = new File(fileName);
         if (!file.isFile()) {
             System.out.println("файла с таким именем не существует");
             return;
         }

         String newFileName  = CRUD.getName("Ведите новое имя");
         File file2 = new File(newFileName);
         if (file2.isFile()) {
             System.out.println("файла с таким именем уже существует");
             return;
         }
         if (CRUD.confirm()) {
             file.renameTo(file2);
             System.out.println("фаил переименован");
         }
    }
     public static void updateFolder() {

         String fileName  = CRUD.getName();
         File file = new File(fileName);
         if (!file.isFile()) {
             System.out.println("папка с таким именем не существует");
             return;
         }

         String newFileName  = CRUD.getName("Ведите новое имя");
         File file2 = new File(newFileName);
         if (file2.isFile()) {
             System.out.println("папка с таким именем уже существует");
             return;
         }
         if (CRUD.confirm()) {
             file.renameTo(file2);
             System.out.println("папка переименована");
         }


    }
     public static void deleteFile() {
         String fileName  = CRUD.getName();
         File file = new File(fileName);
         if (!file.isFile()) {
             System.out.println("файл с таким именем не существует");
             return;
         }

         if (CRUD.confirm()) {
             if (file.delete()) {
                 System.out.println("фаил удален");
             }
         }
    }
     public static void deleteFolder() {
         String fileName  = CRUD.getName();
         File file = new File(fileName);
         if (!file.isFile()) {
             System.out.println("папка с таким именем не существует");
             return;
         }

         if (CRUD.confirm()) {
             if (file.delete()) {
                 System.out.println("папка удалена");
             }
         }
    }
}

class MenuFileDir  {

    enum ActionСodes {
        FILE(0, "Фаил" ),
        FOLDER(1, "Директория");


        ActionСodes(int codeAction, String text) {
            this.code = codeAction;
            this.text = text;
        }

        public static MenuFileDir.ActionСodes byOrdinal(int ord) throws Exception {
            for (MenuFileDir.ActionСodes m : MenuFileDir.ActionСodes.values()) {
                if (m.code == ord) {
                    return m;
                }
            }
            throw new Exception("Не правильный код выбора");
        }
        private final int code;
        private final String text;

    }

    public MenuFileDir.ActionСodes showMainMenu() throws Exception {
        MenuFileDir.ActionСodes selectCodeAction;

        do {
            System.out.println("Выберите действие:" );
            for (MenuFileDir.ActionСodes m : MenuFileDir.ActionСodes.values()) {
                System.out.println("    " + m.code + " - " + m.text);
            }

            try {
                Scanner scanner = new Scanner(System.in);
                Integer select = scanner.nextInt();
                selectCodeAction = MenuFileDir.ActionСodes.byOrdinal(select);
                return  selectCodeAction;
            } catch (Exception e) {
                System.out.println("Не правильный код выбора");
                throw new Exception("Не правильный код выбора");
            }
        } while (true);
    }
}

class MainMenu {

    enum ActionСodes {
        EXIT(0, "ВЫХОД" ),
        CREATE(1, "Создать"),
        DELETE(2, "Удалить"),
        READ(3, "Прочитать"),
        UPDATE(4, "Изменить имя");

        ActionСodes(int codeAction, String text) {
            this.code = codeAction;
            this.text = text;
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
        private final String text;

    }

    public ActionСodes showMainMenu() throws Exception {
        ActionСodes selectCodeAction;

        do {
            System.out.println("Выберите действие:" );
            for (ActionСodes m : ActionСodes.values()) {
                System.out.println("    " + m.code + " - " + m.text);
            }

            try {
                Scanner scanner = new Scanner(System.in);
                Integer select = scanner.nextInt();
                selectCodeAction = ActionСodes.byOrdinal(select);
                return  selectCodeAction;
            } catch (Exception e) {
                System.out.println("Не правильный код выбора");
                throw new Exception("Не правильный код выбора");
            }
        } while (true);
    }

}