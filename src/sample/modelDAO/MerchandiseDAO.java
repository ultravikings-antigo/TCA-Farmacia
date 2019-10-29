package sample.modelDAO;

import sample.model.Client;

import java.util.ArrayList;

public interface MerchandiseDAO {

    Client insert (String name, String address, String cpf, String telephone, String email);
    Client edit (String name, String address, String cpf, String telephone, String email);
    boolean exclude (String name, int id);
    ArrayList<Client> list();

}
