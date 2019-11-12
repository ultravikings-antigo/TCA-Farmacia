package sample.modelDAO;

import sample.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public interface SalesDAO {

    Sales insert (Client client, Salesman salesman, Date date, Float totalValue) throws SQLException;
    Sales update(Client client, Salesman salesman, Date date, Float totalValue);
    boolean delete(int id);
    ArrayList<Sales> list();
}
