package groupId;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ReservationDAO {

    public static void addReservation(int spaceId, int customerId, String date, String startTime, String endTime) {
        String query = "INSERT INTO reservation (spaceId, customerId, date, startTime, endTime) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, String.valueOf(spaceId));
            ps.setString(2, String.valueOf(customerId));
            ps.setString(3, date);
            ps.setString(4, startTime);
            ps.setString(5, endTime);
            System.out.println("Reservation booked succesfully");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }


    public static ArrayList<String> getAllReservation() {
        String query = "SELECT * FROM reservation";
        ArrayList<String> reservations = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("reservation_id");
                int spaceId = rs.getInt("coworkingspace_id");
                int customerId = rs.getInt("customer_id");
                String date = rs.getString("reservation_date");
                String startTime = rs.getString("starttime");
                String endTime = rs.getString("endtime");

                String reservationDetails = String.format(
                        "Reservation id: %d, Space id: %d, Customer id: %d, Date: %s, Start time: %s, End time: %s",
                        id, spaceId, customerId, date, startTime, endTime
                );
                reservations.add(reservationDetails);
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
        return reservations;
    }

    public static boolean isRequestValid(int spaceId, int customerId) {
        String query = "SELECT 1 FROM coworkingspace WHERE coworkingspace_id = ? UNION SELECT 1 FROM customer WHERE customer_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, spaceId);
            ps.setInt(2, customerId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }

    public static void cancelReservation(int reservationId) {
        String query = "DELETE FROM reservation WHERE reservation_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, reservationId);
            System.out.println("Reservation cancelled successfully");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    public static void viewReservationById(int reservationId) {
        String query = "SELECT * FROM reservation WHERE reservation_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, reservationId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int spaceId = rs.getInt("coworkingspace_id");
                    int customerId = rs.getInt("customer_id");
                    String date = rs.getString("reservation_date");
                    String startTime = rs.getString("starttime");
                    String endTime = rs.getString("endtime");
                    System.out.printf("Reservation id: %d, Space id: %d, Customer id: %d, Date: %s, Start time: %s, End time: %s%n",
                            reservationId, spaceId, customerId, date, startTime, endTime);
                } else {
                    System.out.println("No reservation found with the given id");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
