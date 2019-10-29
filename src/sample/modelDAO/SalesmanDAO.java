package sample.modelDAO;

import java.util.ArrayList;

public interface SalesmanDAO {

    SalesmanDAO insert (String name, Float salary, String address, String telephone, String cpf, String email, Boolean admin);
    SalesmanDAO edit (String name, Float salary, String address, String telephone, String cpf, String email, Boolean admin);
    boolean exclude (int id);
    ArrayList<SalesmanDAO> list();
}
