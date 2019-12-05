package sample.modelDAO;

import sample.model.ConnectionCreator;
import sample.model.Merchandise;
import sample.model.Provider;
import sample.model.Purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PurchaseDAOimpl implements PurchaseDAO {
    private static String INSERT = "INSERT INTO Purchases(Provider_Id, Date, Total_Value) VALUES (?, ?, ?);";
    private static String LIST = "SELECT (*) FROM Purchases;";

    ProviderDAO providerDAO = new ProviderDAOimpl();

    @Override
    public Purchase insert(Provider provider, Date date, Float totalValue) throws SQLException {
        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(INSERT);

        Purchase p = new Purchase(provider, date, totalValue);

        stm.setInt(1, p.getProvider().getId());
        stm.setDate(2, java.sql.Date.valueOf(String.valueOf(p.getDate())));
        stm.setFloat(3, p.getTotalValue());

        stm.executeQuery();

        stm.close();
        con.close();
        return p;
    }

    @Override
    public Purchase update(Provider provider, Date date, Float totalValue) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public ArrayList<Purchase> list() throws SQLException {
        ArrayList<Purchase> purchases = new ArrayList<>();


        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(LIST);
        ResultSet res = stm.executeQuery();

        Purchase p = new Purchase();

        while (res.next()){
            p.setId(res.getInt("Id"));
            p.setDate(res.getDate("Date"));
            p.setProvider(providerDAO.IdSearch(res.getInt("Id")));
            p.setTotalValue(res.getFloat("Total_Value"));

            purchases.add(p);
        }


        res.close();
        stm.close();
        con.close();
        return purchases;
    }
}
