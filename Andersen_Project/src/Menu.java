import java.io.File;

public class Menu {
    protected static void adminMenu(Admin user) {
        System.out.println("Admin Menu: ");
        System.out.println("""
                1. Add a new coworking space
                2. Remove a coworking space
                3. Update a coworking space
                4. View all reservations
                5. Log out
                """);
        while (true) {
            int choice = Main.scanner.nextInt();
            Main.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Adding a new coworking space");
                    user.addCoworkingSpace();
                    break;

                case 2:
                    System.out.println("Removing a coworking space");
                    user.removeCoworkingSpace();
                    break;

                case 3:
                    System.out.println("Updating a coworking space");
                    user.updateCoworkingSpace();
                    break;

                case 4:
                    System.out.println("Viewing all reservations");
                    user.viewAllReservations();
                    break;
                case 5:
                    System.out.println("Logging out");
                    FileHandling.saveSpacesToFile(Main.fileName);
                    Main.loggedInUser = null;
                    Login.login();
                    return;
                default:
                    System.out.println("Entered information is invalid");
                    adminMenu(user);
                    break;
            }
        }
    }

    protected static void customerMenu(Customer user) {
        System.out.println("Customer Menu: ");
        System.out.println("""
                1. View available coworking spaces
                2. Make a reservation
                3. View specific reservation
                4. Cancel a reservation
                5. Log out
                """);
        while (true) {
            int choice = Main.scanner.nextInt();
            Main.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Displaying available coworking spaces");
                    user.browseSpaces();
                    break;
                case 2:
                    System.out.println("Making a reservation");
                    user.makeReservation();
                    break;

                case 3:
                    System.out.println("Viewing reservation");
                    user.viewReservation();
                    break;

                case 4:
                    System.out.println("Canceling a reservation");
                    user.cancelReservation();
                    break;

                case 5:
                    System.out.println("Logging out");
                    FileHandling.saveSpacesToFile(Main.fileName);
                    Main.loggedInUser = null;
                    Login.login();
                    return;

                default:
                    System.out.println("Entered information is invalid");
                    customerMenu(user);
                    break;
            }
        }
    }
}
