package groupId;

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

    public void addCoworkingSpace() {
        System.out.println("Enter space details(type, price, availability):");
        Scanner input = new Scanner(System.in);
        String type = input.nextLine();
        int price = input.nextInt();
        boolean availability = input.nextBoolean();
        CoworkingSpace space = new CoworkingSpace(type, price, availability);
        System.out.println("Space added successfully.");
    }

    public void removeCoworkingSpace() {
        System.out.println("Enter space id you want to remove:");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        CoworkingSpace.removeSpace(id);
    }

    public void updateCoworkingSpace() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the space ID you want to update:");
        int id = input.nextInt();
        input.nextLine();

        System.out.println("What you like to update?type/price/availability");
        String choice = input.nextLine().toLowerCase();

        switch (choice) {
            case "type":
                System.out.println("Enter the new type:");
                String newType = input.nextLine();
                CoworkingSpaceDAO.updateType(id, newType);
                break;
            case "price":
                System.out.println("Enter the new price:");
                double newPrice = input.nextDouble();
                input.nextLine();
                CoworkingSpaceDAO.updatePrice(id, newPrice);
                break;
            case "availability":
                System.out.println("Enter the new availability:");
                boolean newAvailability = input.nextBoolean();
                input.nextLine();
                CoworkingSpaceDAO.updateAvailability(id, newAvailability);
                break;
            default:
                System.out.println("Invalid choice. Please select 'type', 'price', or 'availability'");
        }

        System.out.println("Coworking space updated successfully.");
    }


    public void viewAllReservationsService() {
        Reservation.getAllReservations();
    }
}
