import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateJDBC {
    // Giả sử lớp ConnectJDBC đã có phương thức connect() trả về Connection
    ConnectJDBC connectJDBC = new ConnectJDBC();

    public void updateData() {
        Connection conn = connectJDBC.connect(); // Kết nối CSDL

        String query = "UPDATE users SET userName = ? WHERE passWords = ?";
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(query);
            pstm.setString(1, "khánh"); // Tham số đầu tiên (userName)
            pstm.setString(2, "456"); // Tham số thứ hai (passWords)

            int row = pstm.executeUpdate(); // Thực thi câu lệnh UPDATE

            if (row != 0) {
                System.out.println("Cập nhật thành công " + row + " dòng.");
            }

            // Đóng PreparedStatement
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối trong khối finally để đảm bảo nó luôn được đóng
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
public void Delete(){
        Connection conn = connectJDBC.connect();

        String query = "DELETE FROM SinhVien WHERE id =?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, 1);
            pstm.executeUpdate();
            System.out.println("Cập nhật dữ liệu thành công" );
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}
    public static void main(String[] args) {
        UpdateJDBC updateJDBC = new UpdateJDBC();
        updateJDBC.updateData(); // Gọi phương thức để cập nhật dữ liệu
        updateJDBC.Delete();
    }
}
