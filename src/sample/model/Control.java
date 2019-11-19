package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.modelDAO.*;

import java.sql.SQLException;
import java.util.InputMismatchException;

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

    public Salesman login(String name, String password) throws SQLException{
        return salesmanDAO.login(name, password);

    }

    public Salesman register(String name,String address, String telephone, String cpf, String email, String password) throws SQLException {
        Salesman s = null;

        s = salesmanDAO.insert(name, (float) 0,address,telephone,cpf,password,email,false);

        return s;
    }

    public boolean validCpf(String cpf){

        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != 11)){
            return false;
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48);
            }

            sm = 0;
            peso = 11;

            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))){
                return true;
            } else{
                return false;
            }

        }catch (InputMismatchException erro) {
            return false;
        }

    }

    public ObservableList<Merchandise> merchandiseList() throws SQLException {

        merchandises.clear();

        merchandises.addAll(merchandiseDAO.list());


        return merchandises;
    }

    public ObservableList<Merchandise> merchandiseSearch(String text) throws SQLException{
        merchandises.clear();
        merchandises.addAll(merchandiseDAO.searchList(text));

        return merchandises;
    }

    public ObservableList<Sales> salesSearch(String text) throws SQLException{
        sales.clear();
        sales.addAll(salesDAO.searchList(text));

        return sales;

    }
}
