package sample.model;

public class SoldMerchandise {

    private int id;
    private String name;
    private int amount;
    private Float price;
    private int discount;
    private Float totalPrice;

    public SoldMerchandise(int id, String name, int amount, Float price, int discount, Float totalPrice) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.discount = discount;
        this.totalPrice = totalPrice;
    }

    public SoldMerchandise(String name, int amount, Float price, int discount, Float totalPrice) {
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.discount = discount;
        this.totalPrice = totalPrice;
    }

    public SoldMerchandise() {
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SoldMerchandise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", discount=" + discount +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
