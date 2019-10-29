package sample.modelDAO;

import sample.model.Client;
import sample.model.Provider;
import sample.model.Purchase;
import sample.model.Salesman;

import java.util.ArrayList;
import java.util.Date;

public interface SalesDAO {

    Purchase insert (Client client, Salesman salesman, Date date, Float totalValue);
    Purchase edit (Client client, Salesman salesman, Date date, Float totalValue);
    boolean delete(int id);
    ArrayList<Purchase> list();
}
