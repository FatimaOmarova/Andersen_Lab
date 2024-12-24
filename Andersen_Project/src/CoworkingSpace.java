import java.util.ArrayList;
import java.util.List;

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
        return "CoworkingSpace{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                '}';
    }

    public void print() {
        System.out.println(this);
    }

    public static void removeSpace(int id) {
        Main.spaces.removeIf(space -> space.getId() == id);
    }

    public static void getAvailableSpaces() {
        System.out.println(Main.spaces.stream().filter(CoworkingSpace::isAvailability).toList());
    }

    public static void getSpaces() {
        System.out.println(Main.spaces);
    }

}
