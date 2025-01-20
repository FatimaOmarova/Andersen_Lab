package groupId;

import java.util.*;

public class Main {
    public static Map<String, Admin> adminList = new HashMap<>();
    public static Map<Integer, Customer> customerList = new HashMap<>();
    public static String loggedInUser = null;
    public static List<CoworkingSpace> spaces = new ArrayList<>();
    public static List<Reservation> reservations = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static String fileName = "C:\\Users\\fatim\\OneDrive\\Desktop\\java\\Andersen\\Andersen_Project\\src\\spaces.txt";

    static {
        adminList.put("admin", new Admin("admin", "admin123"));
        customerList.put(1, new Customer(1, "Fatima", "cust123"));
        customerList.put(2, new Customer(2, "Andersen", "ander123"));
        reservations.add(new Reservation(101, 3, 1, 20231225, 9, 12));
        reservations.add(new Reservation(102, 4, 2, 20231226, 13, 16));
        FileHandling.loadSpacesfromFile(fileName);
    }

    public static void main(String[] args) {
        try{
            CustomClassLoader loader =  new CustomClassLoader();
            Class<?> loadedClass = loader.loadClass("groupId.Main");
            Object instance = loadedClass.getDeclaredConstructor().newInstance();
            System.out.println("Class loaded successfully " + loadedClass.getName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Login.login();
    }
}