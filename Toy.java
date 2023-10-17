import java.util.UUID;

public class Toy {
    private String id;
    private String name;
    private int quantity;
    private double weight;

    public Toy(String name, int quantity, double weight) {
        this.id = UUID.randomUUID().toString(); // генерация уникального идентификатора
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }   
    

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}