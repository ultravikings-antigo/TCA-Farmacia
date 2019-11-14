package sample.model;

import java.util.Date;

public class Sales {

    private int id;
    private Client client;
    private Salesman salesman;
    private Date date;
    private Float totalValue;

    public Sales(int id, Client client, Salesman salesman, Date date, Float totalValue) {
        this.id = id;
        this.client = client;
        this.salesman = salesman;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Sales(Client client, Salesman salesman, Date date, Float totalValue) {
        this.client = client;
        this.salesman = salesman;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Sales() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Salesman getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman salesman) {
        this.salesman = salesman;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Float totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", client=" + client +
                ", salesman=" + salesman +
                ", date=" + date +
                ", totalValue=" + totalValue +
                '}';
    }
}
