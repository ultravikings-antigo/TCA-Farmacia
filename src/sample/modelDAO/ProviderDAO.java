package sample.modelDAO;

import sample.model.Provider;

import java.util.ArrayList;

public interface ProviderDAO {

    Provider insert (String name, String telephone, String email);
    Provider update(String name, String telephone, String email);
    boolean delete(String name, int id);
    ArrayList<Provider> list();
}
