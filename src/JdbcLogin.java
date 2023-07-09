import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcLogin {
    private Connection connection;

    public void StartBdd() throws ClassNotFoundException, SQLException {

        String driverName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverName); // here is the ClassNotFoundException


        String serverName = "flywood.com6.ru";
        String portNumber = "3306";
        String mydatabase = "flywood_api";
        String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + mydatabase;


        String password = "flykomp111";
        String userName = "flywood_test_user";
        this.connection = DriverManager.getConnection(url, userName, password);

    }

    public void close() throws SQLException {
        this.connection.close();
    }

    public void execAndShow(String title, String sql) throws Exception {
        if(title.equals("") || sql.equals("")) {
//            throw new Exception("Условие и реализация не могут быть пустыми");
            return;
        }
        System.out.println();
        System.out.println("Задание: "+ title);
        System.out.println("Запрос: "+ sql);
        System.out.println("Результат (только номер и название): ");

        ResultSet res = this.connection.createStatement().executeQuery(sql);
        // System.out.println(res.getArray(0));
        int count = 0;

        System.out.println("№  -  Название");
        System.out.println();
        while (res.next()) {
            count++;
            int id = res.getInt("N");
            String str1 = res.getString("Name");
            System.out.println(id + " - " + str1);
        }
        System.out.println();
        System.out.println("всего: " + count);

    }


}
