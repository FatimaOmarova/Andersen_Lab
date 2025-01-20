package groupId;

import java.util.*;

public class Main {
    public static String loggedInUser = null;
    public static List<CoworkingSpace> spaces = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static String fileName = "C:\\Users\\fatim\\OneDrive\\Desktop\\java\\Andersen\\Andersen_Project\\src\\spaces.txt";

    static {
        FileHandling.loadSpacesfromFile(fileName);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            CustomClassLoader loader = new CustomClassLoader();
            Class<?> loadedClass = loader.loadClass("groupId.Main");
            Object instance = loadedClass.getDeclaredConstructor().newInstance();
            System.out.println("Class loaded successfully " + loadedClass.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Login.login();
    }
}