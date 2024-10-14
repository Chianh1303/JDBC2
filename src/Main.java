import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();
        product_manager_database product = new product_manager_database();


        UpdateJDBC updateJDBC = new UpdateJDBC();


    }
}

