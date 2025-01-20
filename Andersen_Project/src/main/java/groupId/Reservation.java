package groupId;

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
        System.out.println(Main.reservations);
    }

    public static void removeReservation(int id) {
        Main.reservations.removeIf(reservation -> reservation.getReservationId() == id);
    }

    public static void getReservation(int reservationId) {

        System.out.println(Main.reservations.stream().filter(reservation -> reservation.getReservationId() == reservationId).findFirst());
    }
    public static boolean isValidRequest(int spaceId, int customerId){
        boolean spaceExist = Main.spaces.stream().anyMatch(space -> space.getId()==spaceId);
        boolean available = Main.spaces.stream().filter(space -> space.getId() == spaceId).allMatch(CoworkingSpace::isAvailability);
        boolean customerExist = Main.customerList.containsKey(customerId);
        return (spaceExist && available && customerExist);
    }
    public static boolean makeReservation(int reservationId, int spaceId, int customerId, int date, int startTime, int endTime) {
        if(isValidRequest(spaceId, customerId)) {
            Reservation reservation = new Reservation(reservationId, spaceId, customerId, date, startTime, endTime);
            System.out.println("Reservation added successfully.");
            return true;
        }
        return false;
    }

    public static void cancelReservation() {
        System.out.println("Enter the id of the reservation you want to remove:");
        int id = Main.scanner.nextInt();
        removeReservation(id);
        System.out.println("Reservation removed successfully.");
    }

    public static void viewReservation() {
        System.out.println("Enter the id of the reservation you want to view:");
        int reservationId = Main.scanner.nextInt();
        getReservation(reservationId);
    }


}
