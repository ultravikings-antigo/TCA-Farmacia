package sample.modelDAO;

import sample.model.Client;
import sample.model.ConnectionCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAOimpl implements ClientDAO{

    private static String INSERT = "INSERT INTO Client(Name,Address,Cpf,Telephone,Email) VALUES (?,?,?,?,?)";
    private static String UPDATE = "UPDATE Client ";
    private static String DELETE = "DELETE * FROM Client WHERE Id = ?";
    private static String LIST = "SELECT * FROM Client";
    private static String IDSEARCH = "SELECT * FROM Client WHERE Id = ?";


    @Override
    public Client insert(String name, String address, String cpf, String telephone, String email) throws SQLException {
        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(INSERT);
        Client c = new Client(name, address, cpf, telephone, email);

        stm.setString(1, c.getName());
        stm.setString(2, c.getAddress());
        stm.setString(3, c.getCpf());
        stm.setString(4, c.getTelephone());
        stm.setString(5, c.getEmail());

        stm.executeQuery();

        stm.close();
        con.close();
        return c;
    }

    @Override
    public Client update(String name, String address, String cpf, String telephone, String email) {
        return null;
    }

    @Override
    public boolean delete(String name, int id) {
        return false;
    }

    @Override
    public ArrayList<Client> list() {
        return null;
    }

    @Override
    public Client idSearch(int id) throws SQLException {
        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(IDSEARCH);
        stm.setInt(1, id);

        ResultSet res = stm.executeQuery();
        Client c = new Client();

        while (res.next()){

            c.setId(res.getInt("Id"));
            c.setName(res.getString("Name"));
            c.setAddress(res.getString("Address"));
            c.setCpf(res.getString("Cpf"));
            c.setEmail(res.getString("Email"));
            c.setTelephone(res.getString("Telephone"));
        }

        return c;
    }
}
