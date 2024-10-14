import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConection {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "root";
    private static final String PASSWORD = "root@123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
