package sample.modelDAO;

import sample.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public interface SalesDAO {

    Sales insert (Client client, Salesman salesman, Date date,ArrayList<Merchandise> merchandises, Float totalValue) throws SQLException ;
    Sales update(Client client, Salesman salesman, Date date,ArrayList<Merchandise> merchandises ,Float totalValue) throws SQLException;
    boolean delete(int id) throws SQLException;
    ArrayList<Sales> list() throws SQLException;
    ArrayList<Sales> searchList(String text) throws SQLException;
}
