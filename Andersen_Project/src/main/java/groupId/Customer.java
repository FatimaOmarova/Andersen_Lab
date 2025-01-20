package groupId;

public class Customer {
    private String username;
    private String password;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
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

    public void makeReservationService() {
        System.out.println("Enter the details of the space you want to reserve:(space, customer, date, start time, end time)");
        int spaceId = Main.scanner.nextInt();
        int customerId = Main.scanner.nextInt();
        Main.scanner.nextLine();
        String date = Main.scanner.nextLine();
        String startTime = Main.scanner.nextLine();
        String endTime = Main.scanner.nextLine();
        Reservation.makeReservation(spaceId, customerId, date, startTime, endTime);
    }

    public void cancelReservationService() {
        Reservation.cancelReservation();
    }

    public void viewReservationService() {
        Reservation.viewReservation();
    }
}
