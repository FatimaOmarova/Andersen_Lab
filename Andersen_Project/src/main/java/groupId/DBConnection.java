package groupId;

import java.sql.*;

public class DBConnection {
    private static final String url = "jdbc:postgresql://localhost:5433/CoworkingApp";
    private static final String username = "postgres";
    private static final String password = "12345";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
