import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {


       JdbcLogin base = new JdbcLogin();
        try {
            base.StartBdd();
            base.execAndShow(
                    "1)Вывести топ 5 книг с наибольшем тиражом",
                    "SELECT * FROM `dbo.books` order by Pressrun desc limit 5; "
            );
            base.execAndShow(
                    "2)Вывести книги где цена больше 10 и меньше 50",
                    "select * from `dbo.books` where (price >10 and price < 50)"
            );
            base.execAndShow(
                    "3) Вывести книги где N коде меньше цены",
                    "select * from `dbo.books` where price > N"
            );
            base.execAndShow(
                    "4) Вывести книги где N коде больше тиража",
                    "select * from `dbo.books` where N > Pressrun");
            base.execAndShow(
                    "5) Вывести книги которые занимают в списке 10-15 место по общей сумме (тираж * цена) ",
                    "select *, (price * Pressrun) as sum from `dbo.books` order by sum desc limit 10,5");
            base.execAndShow(
                    "6)Вывести 2 процента старых книг",
                    "SELECT * FROM( SELECT *, @counter := @counter +1 AS counter FROM (select @counter:=0) AS initvar, `dbo.books` where date not like '' ORDER BY Date asc ) AS X where counter <= (2/100 * @counter)");
            base.execAndShow(
                    "7)Вывести книги которые были выпущены с 1996 года по 1998",
                    "select * from `dbo.books`  where year(date) >= 1996 and year(date) <= 1998 order by date");
            base.execAndShow(
                    "8)Вывести книги которые были выпущены в мае или в июле",
                    "select * from `dbo.books`  where month(date) = 5 or month(date) = 7 ");
            base.execAndShow(
                    "9)Вывести топ 5 новых книг которые были выпущены зимой в отсортированном виде по цене (убывание)",
                    "select * from (select * from `dbo.books` where  month(date) = 12 or month(date) = 1 or month(date) = 2 order by Date desc limit 5) as x order by Price desc");


            base.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ошибка подключения");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }


}


