package sample.model;

public class Merchandise {

    private int id;
    private String name;
    private int amount;
    private Float price;

    public Merchandise(int id, String name, int amount, Float price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Merchandise(String name, int amount, Float price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Merchandise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
