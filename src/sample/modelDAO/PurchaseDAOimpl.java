package sample.modelDAO;

import sample.model.Provider;
import sample.model.Purchase;

import java.util.ArrayList;
import java.util.Date;

public class PurchaseDAOimpl implements PurchaseDAO {
    @Override
    public Purchase insert(Provider provider, Date date, Float totalValue) {
        return null;
    }

    @Override
    public Purchase edit(Provider provider, Date date, Float totalValue) {
        return null;
    }

    @Override
    public boolean exclude(int id) {
        return false;
    }

    @Override
    public ArrayList<Purchase> list() {
        return null;
    }
}
