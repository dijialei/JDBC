import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionJdbc {
    public static void main(String[] args) {
        String username = "root";
        String passwork = "admin";
        String url = "jdbc:mysql://127.0.0.1:3306/compta";
        try {
            Connection connection = DriverManager.getConnection(url,username,passwork);
            System.out.println(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
