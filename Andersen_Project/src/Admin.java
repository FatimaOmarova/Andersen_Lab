import java.util.Scanner;

public class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static void addCoworkingSpace() {
        System.out.println("Enter space details(id, type, price, availability):");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        input.nextLine();
        String type = input.nextLine();
        int price = input.nextInt();
        boolean availability = input.nextBoolean();
        CoworkingSpace space = new CoworkingSpace(id, type, price, availability);
        System.out.println("Space added successfully.");
    }

    public static void removeCoworkingSpace() {
        System.out.println("Enter space id you want to remove:");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        CoworkingSpace.removeSpace(id);
        System.out.println("Space removed successfully.");
    }

    public static void updateCoworkingSpace() {
        System.out.println("Enter space id you want to update:");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        CoworkingSpace.removeSpace(id);
        input.nextLine();
        addCoworkingSpace();
        System.out.println("Space updated successfully.");
    }

    public static void viewAllReservations() {
        Reservation.getAllReservations();
    }
}
