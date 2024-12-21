import java.util.Map;
import java.util.Scanner;

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

        Admin admin = Main.adminList.get(username);
        if (admin != null && admin.getPassword().equals(password)) {
            Main.loggedInUser = "Admin";
            System.out.println("Admin logged in successfully.");
            Menu.adminMenu();
        } else {
            System.out.println("Entered information is invalid");
            login();
        }
    }
    private static void customerLogin() {
        System.out.print("Enter Customer id: ");
        int id = Main.scanner.nextInt();
        Main.scanner.nextLine();
        System.out.print("Enter Customer username: ");
        String username = Main.scanner.nextLine();
        System.out.print("Enter Customer password: ");
        String password = Main.scanner.nextLine();

        Customer customer = Main.customerList.get(id);
        if (customer != null && customer.getUserName().equals(username) &&customer.getPassword().equals(password) ) {
            Main.loggedInUser = username;
            System.out.println("Customer logged in successfully.");
            Menu.customerMenu();
        } else {
            System.out.println("Entered information is invalid");
            login();
        }
    }
    }
