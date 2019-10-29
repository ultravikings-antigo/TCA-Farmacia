package sample.modelDAO;

import sample.model.Client;

import java.util.ArrayList;

public class MerchandiseDAOimpl implements MerchandiseDAO {
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
