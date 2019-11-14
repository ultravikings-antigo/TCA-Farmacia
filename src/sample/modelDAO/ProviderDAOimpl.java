package sample.modelDAO;

import sample.model.ConnectionCreator;
import sample.model.Provider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProviderDAOimpl implements ProviderDAO {
    private static String INSERT = "INSERT INTO Provider(name, telephone, email) VALUES (?, ?, ?)";
    private static String IDSEARCH = "SELECT (*) FROM Provider WHERE Id = ?";

    @Override
    public Provider insert(String name, String telephone, String email) throws SQLException {
        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(INSERT);

        Provider p = new Provider(name, telephone, email);

        stm.setString(1, p.getName());
        stm.setString(2, p.getTelephone());
        stm.setString(3, p.getEmail());

        stm.executeQuery();

        stm.close();
        con.close();
        return p;
    }

    @Override
    public Provider update(String name, String telephone, String email) {
        return null;
    }

    @Override
    public boolean delete(String name, int id) {
        return false;
    }

    @Override
    public ArrayList<Provider> list() {
        return null;
    }

    @Override
    public Provider IdSearch(int id) throws SQLException {
        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(IDSEARCH);
        ResultSet res;

        stm.setInt(1, id);

        Provider p = new Provider();

        res =  stm.executeQuery();
        while (res.next()){
            p.setId(res.getInt("Id"));
            p.setName(res.getString("Name"));
            p.setTelephone(res.getString("Telephone"));
            p.setEmail(res.getString("Email"));

        }

        return p;
    }
}
