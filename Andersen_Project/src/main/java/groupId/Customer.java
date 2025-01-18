package groupId;

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

    public void makeReservationService(){
        System.out.println("Enter the details of the space you want to reserve:(reservation, space, date, start time, end time)");
        int reservationId = Main.scanner.nextInt();
        int spaceId = Main.scanner.nextInt();
        int customerId = Main.scanner.nextInt();
        int date = Main.scanner.nextInt();
        int startTime = Main.scanner.nextInt();
        int endTime = Main.scanner.nextInt();
        Reservation.makeReservation(reservationId, spaceId, customerId, date, startTime, endTime);

    }
    public void cancelReservationService(){
        Reservation.cancelReservation();
    }
    public void viewReservationService(){
        Reservation.viewReservation();
    }
}
