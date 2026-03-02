import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Update these values to match your database
    private static final String URL = "jdbc:mysql://localhost:3306/triage_db"; // your DB name
    private static final String USER = "root";   // your MySQL username
    private static final String PASSWORD = "Abinaya_0210"; // your MySQL password

    // Get a connection
    public static Connection getConnection() throws SQLException {
        try {
            // Optional: load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
