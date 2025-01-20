package groupId;

import java.sql.*;

public class Login {
    protected static void login() {
        System.out.println("Enter 1 for Admin login, 2 for Customer login, or 0 to exit:");
        int choice = Main.scanner.nextInt();
        Main.scanner.nextLine();
        switch (choice) {
            case 1:
                adminLogin();
                break;
            case 2:
                customerLogin();
                break;
            case 0:
                System.out.println("Exited successfully.");
                System.exit(0);
                break;
            default:
                System.out.println("Entered information is invalid");
                login();
                break;
        }
    }

    private static void adminLogin() {
        System.out.print("Enter admin username: ");
        String username = Main.scanner.nextLine();
        System.out.print("Enter admin password: ");
        String password = Main.scanner.nextLine();
        AdminDAO.getAdmin(username, password);
    }

    private static void customerLogin() {
        System.out.print("Enter Customer username: ");
        String username = Main.scanner.nextLine();
        System.out.print("Enter Customer password: ");
        String password = Main.scanner.nextLine();
        CustomerDAO.getCustomer(username, password);
    }
}
