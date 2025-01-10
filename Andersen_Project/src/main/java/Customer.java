import java.util.Scanner;

public class Customer {
    private int id;
    private String username;
    private String password;

    public Customer(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void browseSpaces() {
        CoworkingSpace.getAvailableSpaces();
    }

    public void makeReservation() {
        System.out.println("Enter the details of the space you want to reserve:(reservation, space, date, start time, end time)");
        int reservationId = Main.scanner.nextInt();
        int spaceId = Main.scanner.nextInt();
        int customerId = Main.scanner.nextInt();
        int date = Main.scanner.nextInt();
        int startTime = Main.scanner.nextInt();
        int endTime = Main.scanner.nextInt();
        Reservation reservation = new Reservation(reservationId, spaceId, customerId, date, startTime, endTime);
        System.out.println("Reservation added successfully.");
    }

    public void cancelReservation() {
        System.out.println("Enter the id of the reservation you want to remove:");
        int id = Main.scanner.nextInt();
        Reservation.removeReservation(id);
        System.out.println("Reservation removed successfully.");
    }

    public void viewReservation() {
        System.out.println("Enter the id of the reservation you want to view:");
        int reservationId = Main.scanner.nextInt();
        Reservation.getReservation(reservationId);
    }
}
