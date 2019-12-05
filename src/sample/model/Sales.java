package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sales {

    private int id;
    private Client client;
    private Salesman salesman;
    private Date date;
    private ObservableList<SoldMerchandise> soldMerchandises = FXCollections.observableArrayList();
    private Float totalValue;

    public Sales(int id, Client client, Salesman salesman, Date date, ObservableList<SoldMerchandise> soldMerchandises, Float totalValue) {
        this.id = id;
        this.client = client;
        this.salesman = salesman;
        this.date = date;
        this.soldMerchandises = soldMerchandises;
        this.totalValue = totalValue;
    }

    public Sales(Client client, Salesman salesman, Date date, ObservableList<SoldMerchandise> soldMerchandises, Float totalValue) {
        this.client = client;
        this.salesman = salesman;
        this.date = date;
        this.soldMerchandises = soldMerchandises;
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

    public ObservableList<SoldMerchandise> getSoldMerchandises() {
        return soldMerchandises;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", client=" + client +
                ", salesman=" + salesman +
                ", date=" + date +
                ", soldMerchandises=" + soldMerchandises +
                ", totalValue=" + totalValue +
                '}';
    }
}
