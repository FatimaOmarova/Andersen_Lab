import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
    private int reservationId;
    private int spaceId;
    private int customerId;
    private int date;
    private int startTime;
    private int endTime;
    public Reservation(int reservationId, int spaceId, int customerId, int date, int startTime, int endTime) {
        this.reservationId = reservationId;
        this.spaceId = spaceId;
        this.customerId = customerId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        Main.reservations.add(this);
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
    public int getDate() {
        return date;
    }
    public int getStartTime() {
        return startTime;
    }
    public int getEndTime() {
        return endTime;
    }
    @Override public String toString() {
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
    public static void getAllReservations(){
        System.out.println(Main.reservations);
    }
    public static void removeReservation(int id){
        Main.reservations.removeIf(reservation -> reservation.getReservationId() == id);
    }
    public static void getReservation(int reservationId){
        System.out.println(Main.reservations.stream().filter(reservation -> reservation.getReservationId() == reservationId).findFirst());
    }


}
