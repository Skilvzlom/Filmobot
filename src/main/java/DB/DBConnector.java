package DB;

import lombok.extern.slf4j.Slf4j;
import settings.ConfigSettings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Slf4j
public class DBConnector {
    private static Connection dbConnection;

    private static final ConfigSettings settings = ConfigSettings.getInstance();

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmobotdb?user=root&password=CRImE20242024");
        } catch (ClassNotFoundException e) {
            System.out.println("Error2");
            log.warn("Error with connection to DataBase");
        } catch (SQLException e){
            System.out.println("Error3");
            System.out.println(e);
        }
        return dbConnection;
    }
}
