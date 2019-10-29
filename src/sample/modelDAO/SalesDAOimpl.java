package sample.modelDAO;

import sample.model.Client;
import sample.model.Purchase;
import sample.model.Salesman;

import java.util.ArrayList;
import java.util.Date;

public class SalesDAOimpl implements SalesDAO{
    @Override
    public Purchase insert(Client client, Salesman salesman, Date date, Float totalValue) {
        return null;
    }

    @Override
    public Purchase edit(Client client, Salesman salesman, Date date, Float totalValue) {
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
