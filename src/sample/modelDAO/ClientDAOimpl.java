package sample.modelDAO;

import sample.model.Client;

import java.util.ArrayList;

public class ClientDAOimpl implements ClientDAO{
    @Override
    public Client insert(String name, String address, String cpf, String telephone, String email) {
        return null;
    }

    @Override
    public Client edit(String name, String address, String cpf, String telephone, String email) {
        return null;
    }

    @Override
    public boolean exclude(String name, int id) {
        return false;
    }

    @Override
    public ArrayList<Client> list() {
        return null;
    }
}
