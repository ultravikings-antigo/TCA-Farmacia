package sample.modelDAO;

import sample.model.Client;
import sample.model.Merchandise;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MerchandiseDAO {

    Merchandise insert (String name, int amount,Float price);
    Merchandise update(String name, int amount,Float price);
    boolean delete(String name, int id);
    ArrayList<Merchandise> list() throws SQLException;

}
