import java.sql.*;
import java.util.Properties;

public class DBConnect {
    protected static Connection conn = null;

    public static Connection connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/jdbc_example";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "password");

        System.out.println("Connecting to database");
        conn = DriverManager.getConnection(url, props);
        System.out.println("Database connected successfully");
        return conn;
    }
}
