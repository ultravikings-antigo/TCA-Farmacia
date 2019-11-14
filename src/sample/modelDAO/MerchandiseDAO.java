package sample.modelDAO;

import sample.model.Client;
import sample.model.Merchandise;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MerchandiseDAO {

    Merchandise insert (String name, int amount,Float price) throws SQLException;
    Merchandise update(String name, int amount,Float price) throws SQLException;
    boolean delete(String name, int id) throws SQLException;
    ArrayList<Merchandise> list() throws SQLException;
    ArrayList<Merchandise> searchList(String text) throws SQLException;

}
