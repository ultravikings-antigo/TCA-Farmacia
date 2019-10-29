package sample.modelDAO;

import java.util.ArrayList;

public interface SalesmanDAO {

    SalesmanDAO insert (String name, Float salary, String address, String telephone, String cpf, String email, Boolean admin);
    SalesmanDAO update(String name, Float salary, String address, String telephone, String cpf, String email, Boolean admin);
    boolean delete(int id);
    ArrayList<SalesmanDAO> list();
}
