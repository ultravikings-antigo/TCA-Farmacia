package sample.modelDAO;

import java.util.ArrayList;

public class SalesmanDAOimpl implements SalesmanDAO {
    @Override
    public SalesmanDAO insert(String name, Float salary, String address, String telephone, String cpf, String email, Boolean admin) {
        return null;
    }

    @Override
    public SalesmanDAO edit(String name, Float salary, String address, String telephone, String cpf, String email, Boolean admin) {
        return null;
    }

    @Override
    public boolean exclude(int id) {
        return false;
    }

    @Override
    public ArrayList<SalesmanDAO> list() {
        return null;
    }
}
