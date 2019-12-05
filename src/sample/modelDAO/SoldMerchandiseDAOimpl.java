package sample.modelDAO;

import sample.model.ConnectionCreator;
import sample.model.SoldMerchandise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SoldMerchandiseDAOimpl implements SoldMerchandiseDAO {

    private static String INSERT = "INSERT INTO Sold_Merchandise(Sale_Id, Name, Amount ,Price, Discount) VALUES(?, ?, ?, ?, ?)";

    @Override
    public void insert(SoldMerchandise sm, int lastId) throws SQLException {
        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(INSERT);

        stm.setInt(1, lastId);
        stm.setString(2, sm.getName());
        stm.setInt(3, sm.getAmount());
        stm.setFloat(4, sm.getPrice());
        stm.setInt(5, sm.getDiscount());

        stm.executeUpdate();

        con.close();
        stm.close();
    }
}
