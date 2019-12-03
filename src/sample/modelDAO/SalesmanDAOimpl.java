package sample.modelDAO;

import com.sun.xml.internal.bind.v2.model.core.ID;
import sample.model.ConnectionCreator;
import sample.model.Merchandise;
import sample.model.Sales;
import sample.model.Salesman;

import java.sql.*;
import java.util.ArrayList;

public class SalesmanDAOimpl implements SalesmanDAO {

    private static String INSERT = "insert into Salesman(Name,Salary,Address,Telephone,Cpf,Password,Email,Admin)  values(?,?,?,?,?,?,?,?)";
    private static String LOGIN = "select * from Salesman where Name like ? and Password like ?";
    private static String IDSEARCH = "SELECT * FROM Salesman WHERE Id = ?";
    private static String LIST = "SELECT * FROM Salesman";
    private static String UPDATE = "UPDATE Salesman SET Name = ? , Salary = ? , Address = ?, Telephone = ?, Cpf = ?, Password = ?, Email = ?, Admin = ? WHERE Id = ?";

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
    public Salesman update(Salesman s) throws SQLException {

        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(UPDATE);

        //stm.setInt(1,s.getId());
        stm.setString(1, s.getName());
        stm.setFloat(2,s.getSalary());
        stm.setString(3,s.getAddress());
        stm.setString(4,s.getTelephone());
        stm.setString(5,s.getCpf());
        stm.setString(6,s.getPassword());
        stm.setString(7,s.getEmail());
        stm.setBoolean(8,s.getAdmin());
        stm.setInt(9,s.getId());

        stm.executeUpdate();

        con.close();
        stm.close();

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
    public ArrayList<Salesman> list() throws SQLException {
        ArrayList<Salesman> salesmen = new ArrayList<>();

        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(LIST);

        ResultSet rs = stm.executeQuery();


        while(rs.next()){
            int id = rs.getInt("Id");
            String name = rs.getString("Name");
            float salary = rs.getFloat("Salary");
            String endereco = rs.getString("Address");
            String telefone = rs.getString("Telephone");
            String cpf = rs.getString("Cpf");
            String password = rs.getString("Password");
            String email = rs.getString("Email");
            Boolean admin = rs.getBoolean("Admin");

            Salesman s = new Salesman(id,name,salary,endereco,telefone,cpf,password,email,admin);

            salesmen.add(s);
        }

        rs.close();
        stm.close();
        con.close();

        return salesmen;
    }

    @Override
    public Salesman idSearch(int id) throws SQLException {
        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(IDSEARCH);
        stm.setInt(1, id);
        ResultSet res = stm.executeQuery();

        Salesman s = new Salesman();

        while (res.next()){
            s.setId(res.getInt("Id"));
            s.setName(res.getString("Name"));
            s.setSalary(res.getFloat("Salary"));
            s.setAddress(res.getString("Address"));
            s.setTelephone(res.getString("Telephone"));
            s.setCpf(res.getString("Cpf"));
            s.setPassword(res.getString("Password"));
            s.setEmail(res.getString("Email"));
            s.setAdmin(res.getBoolean("Admin"));
        }

        return s;
    }
}
