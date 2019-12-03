package sample.model;

public class SoldMerchandise {

    private int id;
    private String name;
    private Merchandise merchandise;
    private Sales sales;
    private int amount;
    private Float price;
    private int discount;

    public SoldMerchandise(int id, String name, Merchandise merchandise, Sales sales, int amount, Float price, int discount) {
        this.id = id;
        this.name = name;
        this.merchandise = merchandise;
        this.sales = sales;
        this.amount = amount;
        this.price = price;
        this.discount = discount;
    }

    public SoldMerchandise(){

    }

    public SoldMerchandise(String name, Merchandise merchandise, Sales sales, int amount, Float price, int discount) {
        this.name = name;
        this.merchandise = merchandise;
        this.sales = sales;
        this.amount = amount;
        this.price = price;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Merchandise getMerchandise() {
        return merchandise;
    }

    public void setMerchandise(Merchandise merchandise) {
        this.merchandise = merchandise;
    }

    public Sales getSales() {
        return sales;
    }

    public void setSales(Sales sales) {
        this.sales = sales;
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
}
