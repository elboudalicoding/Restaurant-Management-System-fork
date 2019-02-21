package tnt.crasher.restaurant_management_system.Admin_Lists;

public class FoodList {

    public int getId() {
        return id;
    }

    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getType() {
        return type;
    }

    private String description;
    private double price;
    private int type;

    public double getRating() {
        return rating;
    }

    private double rating;

    public FoodList(int id, String name, String description, double price, int type, double rating){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.rating = rating;
    }

}
