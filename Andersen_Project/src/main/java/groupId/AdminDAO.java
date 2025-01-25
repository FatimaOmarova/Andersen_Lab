package groupId;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    public static void getAdmin(String username, String password){
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM admin WHERE username = ? AND password = ?";

            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, username);
                ps.setString(2, password);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Main.loggedInUser = "Admin";
                        System.out.println("Admin logged in successfully.");
                        Admin user = new Admin(username, password);
                        Menu.adminMenu(user);
                    } else {
                        System.out.println("Entered information is invalid");
                        Login.login();
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

}
