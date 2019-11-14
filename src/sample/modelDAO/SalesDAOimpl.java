package sample.modelDAO;

import sample.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class SalesDAOimpl implements SalesDAO{

    private static String INSERT = "insert into Sales(Client_Id,Salesman_Id,Date, Total_Value) values";
    private static String LIST = "SELECT (*) FROM Sales;";

    ClientDAO clientDAO = new ClientDAOimpl();
    SalesmanDAO salesmanDAO = new SalesmanDAOimpl();

    @Override
    public Sales insert(Client client, Salesman salesman, Date date, Float totalValue) throws SQLException {
        Sales s = new Sales(client,salesman,date,totalValue);

        Connection con = ConnectionCreator.getConnection();

        PreparedStatement stm = con
                .prepareStatement(INSERT);

        stm.setInt(1,s.getClient().getId());
        stm.setFloat(2,s.getSalesman().getId());
        stm.setDate(3, java.sql.Date.valueOf(String.valueOf(s.getDate())));
        stm.setFloat(4,s.getTotalValue());

        stm.executeUpdate();

        stm.close();
        con.close();

        return s;
    }

    @Override
    public Sales update(Client client, Salesman salesman, Date date, Float totalValue) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public ArrayList<Sales> list() throws SQLException{
        ArrayList<Sales> sales = new ArrayList<>();


        Connection con = ConnectionCreator.getConnection();
        PreparedStatement stm = con.prepareStatement(LIST);
        ResultSet res = stm.executeQuery();

        Sales s = new Sales();

        while (res.next()){
            s.setId(res.getInt("Id"));
            s.setDate(res.getDate("Date"));
            s.setTotalValue(res.getFloat("Total_Value"));
            s.setClient(clientDAO.idSearch(res.getInt("Client_Id")));
            s.setSalesman(salesmanDAO.idSearch(res.getInt("Salesman_Id")));
            sales.add(s);
        }

        return sales;
    }
}
