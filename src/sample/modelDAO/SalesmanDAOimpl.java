package sample.modelDAO;

import sample.model.ConnectionCreator;
import sample.model.Sales;
import sample.model.Salesman;

import java.sql.*;
import java.util.ArrayList;

public class SalesmanDAOimpl implements SalesmanDAO {

    public static String INSERT = "insert into Salesman(Name,Salary,Address,Telephone,Cpf,Password,Email,Admin)  values(?,?,?,?,?,?,?,?)";
    public static String LOGIN = "select * from Salesman where Name like ? and Password like ?";

    @Override
    public Salesman insert(String name, Float salary, String address, String telephone, String cpf,String password , String email, Boolean admin) throws SQLException {
        Salesman s = new Salesman(name,salary,address,telephone,cpf,password,email,admin);

        Connection con = ConnectionCreator.getConnection();

        PreparedStatement stm = con
                .prepareStatement(INSERT);

        stm.setString(1,s.getName());
        stm.setFloat(2,s.getSalary());
        stm.setString(3,s.getAddress());
        stm.setString(4,s.getTelephone());
        stm.setString(5,s.getCpf());
        stm.setString(6,s.getPassword());
        stm.setString(7,s.getEmail());
        stm.setBoolean(8,s.getAdmin());

        stm.executeUpdate();

        stm.close();
        con.close();

        return s;
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
            Float salary = res.getFloat("Salary");
            String address = res.getString("Address");
            String telephone = res.getString("Telephone");
            String cpf = res.getString("Cpf");
            String email = res.getString("Email");
            boolean admin = res.getBoolean("Admin");

            s = new Salesman(name,salary,address,telephone,cpf,password,email,admin);
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
