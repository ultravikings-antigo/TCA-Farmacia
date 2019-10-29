package sample.modelDAO;

import sample.model.Client;

import java.util.ArrayList;

public class ClientDAOimpl implements ClientDAO{

    private static String INSERT = "INSERT INTO Client(Name,Address,Cpf,Telephone,Email) VALUES (?,?,?,?,?)";
    private static String UPDATE = "UPDATE Client ";
    private static String DELETE = "DELETE * FROM Client WHERE Id = ?";
    private static String LIST = "SELECT * FROM Client";

    @Override
    public Client insert(String name, String address, String cpf, String telephone, String email) {
        return null;
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
}
