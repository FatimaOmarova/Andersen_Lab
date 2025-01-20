package groupId;

import java.util.Optional;

public class CoworkingSpace {
    private int id;
    private String type;
    private int price;
    private boolean availability;

    public CoworkingSpace(int id, String type, int price, boolean availability) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.availability = availability;
        Main.spaces.add(this);
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

    public void print() {
        System.out.println(this);
    }

    public static void removeSpace(int id) {
        try {
            Optional<CoworkingSpace> removed = Main.spaces.stream().filter(space -> space.getId() == id).findFirst();
            if (removed.isEmpty()) {
                throw new CustomException("No coworking space is found within specified id!");
            }
            Main.spaces.remove(removed.get());
            System.out.println("Space removed successfully.");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getAvailableSpaces() {
        try {
            boolean check = Main.spaces.stream().filter(CoworkingSpace::isAvailability).toList().isEmpty();
            if (check) {
                throw new CustomException("No available coworking space is found");
            }
            System.out.println(Main.spaces.stream().filter(CoworkingSpace::isAvailability).toList());
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getSpaces() {
        System.out.println(Main.spaces);
    }

}
