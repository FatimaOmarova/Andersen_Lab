public class Menu {
    protected static void adminMenu() {
        System.out.println("Admin Menu: ");
        System.out.println("1. Add a new coworking space\n" +
                "2. Remove a coworking space\n" +
                "3. Update a coworking space\n" +
                "4. View all reservations\n" +
                "5. Log out");
        while (true) {
        int choice = Main.scanner.nextInt();
        Main.scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Adding a new coworking space");
                Admin.addCoworkingSpace();
                break;

            case 2:
                System.out.println("Removing a coworking space");
                Admin.removeCoworkingSpace();
                break;

            case 3:
                System.out.println("Updating a coworking space");
                Admin.updateCoworkingSpace();
                break;

            case 4:
                System.out.println("Viewing all reservations");
                Admin.viewAllReservations();
                break;
            case 5:
                System.out.println("Logging out");
                Main.loggedInUser = null;
                Login.login();
                return;
            default:
                System.out.println("Entered information is invalid");
                adminMenu();
                break;
        }
    }
    }

    protected static void customerMenu() {
        System.out.println("Customer Menu: ");
        System.out.println("1. View available coworking spaces\n" +
                "2. Make a reservation\n" +
                "3. View specific reservation\n" +
                "4. Cancel a reservation\n" +
                "5. Log out");
        while (true) {
            int choice = Main.scanner.nextInt();
            Main.scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Displaying available coworking spaces");
                    Customer.browseSpaces();
                    break;
                case 2:
                    System.out.println("Making a reservation");
                    Customer.makeReservation();
                    break;

                case 3:
                    System.out.println("Viewing reservation");
                    Customer.viewReservation();
                    break;

                case 4:
                    System.out.println("Canceling a reservation");
                    Customer.cancelReservation();
                    break;

                case 5:
                    System.out.println("Logging out");
                    Main.loggedInUser = null;
                    Login.login();
                    return;

                default:
                    System.out.println("Entered information is invalid");
                    customerMenu();
                    break;
            }
        }
    }
}
