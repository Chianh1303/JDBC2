import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class API {
    public static void main(String[] args) {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        Connection conn = connectJDBC.connect();
        String query = "SELECT * FROM SanPham";

        Statement stm = null;
        try {
            stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(query);

            while (rs.next()){  //Di chuyển con trỏ xuống bản ghi kế tiếp
                int MaSP = rs.getInt("MaSP");
                String TenSP = rs.getString("TenSP");
                String MoTa = rs.getString("MoTa");
                String DonVi = rs.getString("DonVi");
                String Gia = rs.getString("Gia");
                System.out.println(MaSP + " - " + TenSP + " - " + MoTa + " - " + DonVi + " - " + Gia);
            }

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

