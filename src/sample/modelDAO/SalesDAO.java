package sample.modelDAO;

import javafx.collections.ObservableList;
import sample.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public interface SalesDAO {

    Sales insert (Client client, Salesman salesman, Date date, Float totalValue, ObservableList<SoldMerchandise> soldMerchandises) throws SQLException ;
    Sales update(Client client, Salesman salesman, Date date,ArrayList<SoldMerchandise> merchandises ,Float totalValue) throws SQLException;
    boolean delete(int id) throws SQLException;
    ArrayList<Sales> list() throws SQLException;
    ArrayList<Sales> searchList(String text) throws SQLException;
}
