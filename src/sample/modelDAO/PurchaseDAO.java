package sample.modelDAO;

import sample.model.Client;
import sample.model.Provider;
import sample.model.Purchase;

import java.util.ArrayList;
import java.util.Date;

public interface PurchaseDAO {

    Purchase insert (Provider provider, Date date, Float totalValue);
    Purchase edit (Provider provider, Date date, Float totalValue);
    boolean delete(int id);
    ArrayList<Purchase> list();
}
