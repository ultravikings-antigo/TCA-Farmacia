package sample.modelDAO;

import java.util.ArrayList;

public interface ProviderDAO {

    ProviderDAO insert (String name, String telephone, String email);
    ProviderDAO update(String name, String telephone, String email);
    boolean delete(String name, int id);
    ArrayList<ProviderDAO> list();
}
