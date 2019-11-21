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

    private static String LIST = "select * from Merchandise";
    private static String INSERT = "INSERT INTO Merchandise(Name, Amount, Price) VALUES (?, ?, ?)";
    private static String SEARCHLIST = "SELECT * FROM Merchandise WHERE Name LIKE ?";
    private static String UPDATE = "UPDATE Merchandise SET Name = ?, Price = ?, Amount = ? WHERE Id = ?";

    @Override
    public Merchandise insert(String name, int amount, Float price) throws SQLException{
        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(INSERT);

        Merchandise m = new Merchandise(name, amount, price);

        stm.setString(1, m.getName());
        stm.setInt(2, m.getAmount());
        stm.setFloat(3, m.getPrice());

        stm.executeUpdate();

        stm.close();
        con.close();
        return m;
    }

    @Override
    public void update(Merchandise m) throws SQLException{
        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(UPDATE);

        stm.setString(1, m.getName());
        stm.setFloat(2, m.getPrice());
        stm.setInt(3, m.getAmount());
        stm.setInt(4, m.getId());

        stm.executeUpdate();

        con.close();
        stm.close();
    }


    @Override
    public boolean delete(String name, int id) {
        return false;
    }

    @Override
    public ArrayList<Merchandise> list() throws SQLException {
        ArrayList<Merchandise> merchandises = new ArrayList<>();

        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(LIST);

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

    @Override
    public ArrayList<Merchandise> searchList(String text) throws SQLException {
        ArrayList<Merchandise> merchandises = new ArrayList<>();

        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(SEARCHLIST);
        stm.setString(1, '%'+text+'%');

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