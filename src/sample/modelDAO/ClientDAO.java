package sample.modelDAO;

import sample.model.Client;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientDAO {

    Client insert (String name, String address, String cpf, String telephone, String email) throws SQLException;
    Client update(String name, String address, String cpf, String telephone, String email) throws SQLException;
    boolean delete(String name, int id) throws SQLException;
    ArrayList<Client> list() throws SQLException;
    Client idSearch(int id) throws SQLException;

}
