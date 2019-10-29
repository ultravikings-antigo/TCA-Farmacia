package sample.modelDAO;

import java.util.ArrayList;

public interface ProviderDAO {

    ProviderDAO insert (String name, String telephone, String email);
    ProviderDAO edit (String name, String telephone, String email);
    boolean exclude (String name, int id);
    ArrayList<ProviderDAO> list();
}
