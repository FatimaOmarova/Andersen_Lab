package groupId;

import java.sql.*;

public class CustomerDAO {

    public static void getCustomer(String username, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM customer WHERE username = ? AND password = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, username);
                ps.setString(2, password);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        Main.loggedInUser = "Customer";
                        System.out.println("Customer logged in successfully.");
                        int customerId = rs.getInt("customer_id");
                        Customer user = new Customer(username, password);
                        Menu.customerMenu(user);
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
    public static boolean customerExists(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT 1 FROM customer WHERE customer_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, String.valueOf(id));
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }

    public static void addCustomer(String username, String password) {
        String query = "INSERT INTO customer (username, password) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ps.setString(2, password);
            System.out.println("Customer added succesfully");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static int findIdByUsername(String username) {
        String query = "SELECT customer_id FROM customer WHERE username = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("customer_id");
                } else {
                    return -1;
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return -1;
        }
    }


}
