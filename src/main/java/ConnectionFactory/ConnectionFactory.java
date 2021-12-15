package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

    private static String user = "root";
    private static String password = "femina123";
    private static String dataBase = "prova_14-12";
    private static String url = "jdbc:mysql://localhost:3306/" + dataBase;

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, user, password);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createDataBase(){

        String sqlCreate = "CREATE SCHEMA `prova_14-12`";
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(sqlCreate);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
