package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.modelDAO.*;

import java.sql.SQLException;

public class Control {
    ClientDAO clientDAO = new ClientDAOimpl();
    MerchandiseDAO merchandiseDAO = new MerchandiseDAOimpl();
    ProviderDAO providerDAO = new ProviderDAOimpl();
    PurchaseDAO purchaseDAO = new PurchaseDAOimpl();
    SalesDAO salesDAO = new SalesDAOimpl();
    SalesmanDAO salesmanDAO = new SalesmanDAOimpl();

    private ObservableList<Client> clients;
    private ObservableList<Merchandise> merchandises;
    private ObservableList<Provider> providers;
    private ObservableList<Purchase> purchases;
    private ObservableList<Sales> sales;
    private ObservableList<Salesman> salesmen;

    private Control(){
        clients = FXCollections.observableArrayList();
        merchandises = FXCollections.observableArrayList();
        providers = FXCollections.observableArrayList();
        purchases = FXCollections.observableArrayList();
        sales = FXCollections.observableArrayList();
        salesmen = FXCollections.observableArrayList();
    }

    private static Control instance = new Control();

    public static Control getInstance(){
        return instance;
    }

    public Salesman login(String name, String password) throws SQLException {
        Salesman s = null;
        s = salesmanDAO.login(name, password);

        return s;
    }



}
