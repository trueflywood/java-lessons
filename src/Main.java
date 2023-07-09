import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {


       JdbcLogin base = new JdbcLogin();
        try {
            base.StartBdd();
            base.execAndShow(
                    "1)отобразить список авторов книг без повторений. Отсортировать по возрастанию",
                    "" // В базе нет информации об авторах книг
            );
            base.execAndShow(
                    "2) Отобразить книги по программированию издательств \"Питер\" и \"BHV\"",
                    "SELECT *  FROM `dbo.books` where Themes = \"Программирование\" and ( Izd like \"BHV%\" or Izd like \"%Питер%\");"
            );
            base.execAndShow(
                    "3) Отобразить все книги у которых количество страниц лежит в пределах от 200 до 600",
                    "SELECT *  FROM `dbo.books` where Pages between 200 and 600;"
            );
            base.execAndShow(
                    "4) Отобразить все книги Имена авторов котрых лежат в диапазоне от букв \"В\" до \"О\". Отсортиролвать по возрастанию по авторам",
                    ""// В базе нет информации об авторах книг
            );
            base.execAndShow(
                    "5) выбрать книги, относящиеся к программированию иди базам данных, и издательства которых не \"Питер\" и не \"Бином\" ",
                    "SELECT *  FROM `dbo.books` where ( Izd not like \"Бином\" and Izd not like \"Питер\") and (lower(Themes) like \"%программирование%\" or lower(Themes) like \"%базы данных%\");"
            );
            base.execAndShow(
                    "6) Выбрать из таблицы тех авторов (без повторений), у которых в имени и фамилии не мение двух букв \"А\"",
                    "" // В базе нет информации об авторах книг
            );
            base.execAndShow(
                    "7) Отобразить всех авторов и их книги. Авторов отсортировать по овозрастанию, а название книг (по авторам) по убыванию (вторичная сортировка)",
                    "" // В базе нет информации об авторах книг
            );
            base.execAndShow(
                    "8) выбрать из таблицы книги, название которых начинаются с цифры ",
                    "SELECT *  FROM `dbo.books` where Name regexp \"^[0-9].*\";"
            );
            base.execAndShow(
                     "9)выбрать из таблицы книги, название которых заканчиваются на 4 цифры",
                    "SELECT *  FROM `dbo.books` where Name regexp \".*[0-9]{4}$\";"
            );
            base.execAndShow(
                    "10) выбрать из таблицы книги, в названиях которых ровно 2 цифры",
                    "SELECT *  FROM `dbo.books` where Name regexp \"^[^0-9]*[0-9][^0-9]*[0-9][^0-9]*$\";"
            );

            base.execAndShow(
                    "11) выбрать из таблицы книги, Которые имеются в единственном экземпляре",
                    "" // В базе нет информации о количестве книг
            );
            base.execAndShow(
                    "12) выбрать из таблицы книги по программированию, не относящиеся к издательству \"BHV\", а в названиях которых есть слово \"Visual\"",
                    "SELECT *  FROM `dbo.books` where  Izd not like \"%BHV%\" and lower(Themes) like \"%программирование%\" and Name like \"%Visual%\";"
            );



            base.close();
        } catch (Exception e) {
            System.out.println("Ошибка:");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}


