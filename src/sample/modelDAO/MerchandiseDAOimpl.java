package sample.modelDAO;

import sample.model.Client;
import sample.model.ConnectionCreator;
import sample.model.Merchandise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MerchandiseDAOimpl implements MerchandiseDAO {

    private static String LISTA = "select * from Merchandise";

    @Override
    public Merchandise insert(String name, int amount, Float price) {
        return null;
    }

    @Override
    public Merchandise update(String name, int amount, Float price) {
        return null;
    }

    @Override
    public boolean delete(String name, int id) {
        return false;
    }

    @Override
    public ArrayList<Merchandise> list() throws SQLException {
        ArrayList<Merchandise> merchandises = new ArrayList<>();

        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(LISTA);

        ResultSet rs = stm.executeQuery();

        while(rs.next()){
            int id = rs.getInt("Id");
            String name = rs.getString("Name");
            int amount = rs.getInt("Amount");
            float price = rs.getFloat("Price");

            Merchandise m = new Merchandise(id,name,amount,price);

            merchandises.add(m);
        }

        rs.close();
        stm.close();
        con.close();

        return merchandises;
    }
}