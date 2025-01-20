package groupId;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Reservation {
    private int reservationId;
    private int spaceId;
    private int customerId;
    private String date;
    private String startTime;
    private String endTime;

    public Reservation(int spaceId, int customerId, String date, String startTime, String endTime) {
        this.spaceId = spaceId;
        this.customerId = customerId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        ReservationDAO.addReservation(spaceId, customerId, date, startTime, endTime);
    }

    public int getReservationId() {
        return reservationId;
    }

    public int getSpaceId() {
        return spaceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", spaceId=" + spaceId +
                ", customerId=" + customerId +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public void print() {
        System.out.println(this);
    }

    public static void getAllReservations() {
        ArrayList<String> reservations = ReservationDAO.getAllReservation();
        reservations.forEach(System.out::println);
    }


    public static void makeReservation(int customerId, int spaceId, String date, String startTime, String endTime) {
            Reservation reservation = new Reservation(spaceId, customerId, date, startTime, endTime);
            System.out.println("Reservation added successfully.");
    }

    public static void cancelReservation() {
        System.out.println("Enter the id of the reservation you want to remove:");
        int id = Main.scanner.nextInt();
        ReservationDAO.cancelReservation(id);
    }

    public static void viewReservation() {
        System.out.println("Enter the id of the reservation you want to view:");
        int reservationId = Main.scanner.nextInt();
        ReservationDAO.viewReservationById(reservationId);
    }


}
