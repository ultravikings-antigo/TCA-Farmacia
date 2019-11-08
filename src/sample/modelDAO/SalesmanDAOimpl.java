package sample.modelDAO;

import sample.model.ConnectionCreator;
import sample.model.Salesman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesmanDAOimpl implements SalesmanDAO {

    public static String LOGIN = "select * from Salesman where Name like ? and Password like ?";

    @Override
    public Salesman insert(String name, Float salary, String address, String telephone, String cpf,String password , String email, Boolean admin) {
        return null;
    }

    @Override
    public Salesman update(String name, Float salary, String address, String telephone, String cpf,String password ,String email, Boolean admin) {
        return null;
    }

    @Override
    public Salesman login(String name, String password) throws SQLException {

        Salesman s = null;

        Connection con = ConnectionCreator.getConnection();

        PreparedStatement stm = con.prepareStatement(LOGIN);

        stm.setString(1,name);
        stm.setString(2,password);

        ResultSet res = stm.executeQuery();

        while(res.next()){
            String getname = res.getString("Name");
            Float salary = res.getFloat("Salary");
            String address = res.getString("Address");
            String telephone = res.getString("Telephone");
            String cpf = res.getString("Cpf");
            String email = res.getString("Email");
            boolean admin = res.getBoolean("Admin");

            s = new Salesman(getname,salary,address,telephone,cpf,email,admin);
        }

        res.close();
        stm.close();
        con.close();

        return s;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public ArrayList<Salesman> list() {
        return null;
    }
}
