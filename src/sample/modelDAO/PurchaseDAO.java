package sample.modelDAO;

import sample.model.Client;
import sample.model.Provider;
import sample.model.Purchase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public interface PurchaseDAO {

    Purchase insert (Provider provider, Date date, Float totalValue) throws SQLException;
    Purchase update(Provider provider, Date date, Float totalValue) throws SQLException;
    boolean delete(int id) throws SQLException;
    ArrayList<Purchase> list() throws SQLException;
}
