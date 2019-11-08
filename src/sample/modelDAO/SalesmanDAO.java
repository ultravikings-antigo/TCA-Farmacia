package sample.modelDAO;

import sample.model.Salesman;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SalesmanDAO {

    Salesman insert (String name, Float salary, String address, String telephone, String cpf,String password,String email, Boolean admin);
    Salesman update(String name, Float salary, String address, String telephone, String cpf,String passwrod,String email,Boolean admin);
    Salesman login(String name,String password) throws SQLException;
    boolean delete(int id);
    ArrayList<Salesman> list();
}
