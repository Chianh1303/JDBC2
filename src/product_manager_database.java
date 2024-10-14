import java.sql.*;

public class product_manager_database {

        private String hostName = "localhost:3306";
        private String dbName = "product_manager";
        private String username = "root";
        private String password = "root@123";

        private String connectionURL = "jdbc:mysql://"+hostName+"/"+dbName;

        public Connection connect(){
            //Tạo đối tượng Connection
            Connection coon = null;

            try {
                coon = DriverManager.getConnection(connectionURL, username, password);
                System.out.println("Kết nối thành công");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return coon;
        }
        public void update(){}

    public static void main(String[] args) {
        product_manager_database db = new product_manager_database();
        Connection coon =db.connect();
        String query = "select id ,nameProduct ,price, detail, manufacturer, numbers, statuss from product where status = paid or number = 99";
        PreparedStatement ps = null;
        ResultSet rs = null; //lưu kết quả truy vấn
        try {
            ps = coon.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nameProduct = rs.getString("nameProduct");
                double price = rs.getDouble("price");
                String detail = rs.getString("detail");
                String manufacturer = rs.getString("manufacturer");
                String numbers = rs.getString("numbers");
                String statuss = rs.getString("statuss");
                System.out.println(id + " - " + nameProduct + " - " + price + " - " + detail + " - " + manufacturer+ " - " +numbers+ " - " +statuss);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }



