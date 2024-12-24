import java.util.*;

public class Main {
    public static Map<String, Admin> adminList = new HashMap<>();
    public static Map<Integer, Customer> customerList = new HashMap<>();
    public static String loggedInUser = null;
    public static List<CoworkingSpace> spaces = new ArrayList<>();
    public static List<Reservation> reservations = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);


    static {
        adminList.put("admin", new Admin("admin", "admin123"));
        customerList.put(1, new Customer(1, "Fatima", "cust123"));
        customerList.put(2, new Customer(2, "Andersen", "ander123"));

        spaces.add(new CoworkingSpace(1, "Meeting Office", 500, true));
        spaces.add(new CoworkingSpace(2, "Open Space", 200, true));
        spaces.add(new CoworkingSpace(3, "Private Room", 300, false));
        spaces.add(new CoworkingSpace(4, "Entertainment Area", 600, false));

        reservations.add(new Reservation(101, 3, 1, 20231225, 9, 12));
        reservations.add(new Reservation(102, 4, 2, 20231226, 13, 16));
    }

    public static void main(String[] args) {
        Login.login();
    }
}