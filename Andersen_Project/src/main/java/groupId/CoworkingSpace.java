package groupId;

import java.util.Optional;

public class CoworkingSpace {
    private int id;
    private String type;
    private int price;
    private boolean availability;

    public CoworkingSpace(String type, int price, boolean availability) {
        this.type = type;
        this.price = price;
        this.availability = availability;
        CoworkingSpaceDAO.addCoworkingSpace(type, price, availability);
    }

    public CoworkingSpace(String line) {
        String[] parts = line.split(",");
        this.id = Integer.parseInt(parts[0]);
        this.type = parts[1];
        this.price = Integer.parseInt(parts[2]);
        this.availability = Boolean.parseBoolean(parts[3]);
        Main.spaces.add(this);
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public boolean isAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "CoworkingSpace{" + "id=" + id + ", type='" + type + ", price=" + price + ", availability=" + availability + '}';
    }

    public static void removeSpace(int id) {
        CoworkingSpaceDAO.removeSpace(id);
    }

    public static void getAvailableSpaces() {
        CoworkingSpaceDAO.getAvailableSpaces();
    }
    public static boolean existById(int id){
        return CoworkingSpaceDAO.existsById(id);
    }
    public static void getSpaces() {
        CoworkingSpaceDAO.getSpaces();
    }

}