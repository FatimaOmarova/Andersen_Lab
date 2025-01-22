package groupId;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class CoworkingSpaceDAO {
    public static void addCoworkingSpace(String type, int price, boolean availability) {
        String query = "INSERT INTO coworkingspace (type, price, availability) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, type);
            ps.setInt(2, price);
            ps.setBoolean(3, availability);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static void getAvailableSpaces() {
        String query = "SELECT * FROM coworkingspace WHERE availability = true";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            List<String> availableSpaces = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("coworkingspace_id");
                String type = rs.getString("type");
                int price = rs.getInt("price");
                availableSpaces.add(String.format("ID: %d, Type: %s, Price: %d", id, type, price));
            }
            if (availableSpaces.isEmpty()) {
                System.out.println("No available coworking space is found.");
            } else {
                availableSpaces.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static void getSpaces() {
        String query = "SELECT * FROM coworkingspace";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            List<String> spaces = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("coworkingspace_id");
                String type = rs.getString("type");
                int price = rs.getInt("price");
                boolean availability = rs.getBoolean("availability");
                Main.spaces.add(new CoworkingSpace(type, price, availability));
            }
            if (spaces.isEmpty()) {
                System.out.println("No coworking spaces are found.");
            } else {
                Main.spaces.forEach(System.out::println);
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static void removeSpace(int id) {
        String query_1 = "DELETE FROM reservation WHERE coworkingspace_id = ?";
        String query_2 = "DELETE FROM coworkingspace WHERE coworkingspace_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement psReservations = conn.prepareStatement(query_1);
             PreparedStatement psSpace = conn.prepareStatement(query_2)) {

            psReservations.setInt(1, id);
            psReservations.executeUpdate();

            psSpace.setInt(1, id);
            int r = psSpace.executeUpdate();

            if (r > 0) {
                System.out.println("Space and related reservations removed successfully");
            } else {
                System.out.println("No coworking space found with the specified ID");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static void updateType(int id, String newType) {
        String query = "UPDATE coworkingspace SET type = ? WHERE coworkingspace_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, newType);
            ps.setInt(2, id);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static void updatePrice(int id, double newPrice) {
        String query = "UPDATE coworkingspace SET price = ? WHERE coworkingspace_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDouble(1, newPrice);
            ps.setInt(2, id);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static void updateAvailability(int id, boolean newAvailability) {
        String query = "UPDATE coworkingspace SET availability = ? WHERE coworkingspace_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setBoolean(1, newAvailability);
            ps.setInt(2, id);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static boolean existsById(int id) {
        String query = "SELECT COUNT(*) FROM coworkingspace WHERE coworkingspace_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return false;
    }

    public static int findIdByType(String type) {
        String query = "SELECT coworkingspace_id FROM coworkingspace WHERE type = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, type);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("coworkingspace_id");
                } else {
                    throw new SQLException("No coworking space found with the specified type.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return -1;
        }
    }




}