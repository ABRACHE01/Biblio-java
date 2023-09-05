import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyJDBC {
    public static void main(String[] args) {

            String jdbcUrl = "jdbc:mysql://localhost:3306/biblo-java";
            String username = "root";
            String password = "";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Database connection established.");

            connection.close();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database:");
            e.printStackTrace();
        }
    }
}
