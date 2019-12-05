package sample.modelDAO;

import sample.model.Client;
import sample.model.Merchandise;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MerchandiseDAO {

    Merchandise insert (String name, int amount,Float price) throws SQLException;
    void update(Merchandise m) throws SQLException;
    void updateStorage(int id, int amount) throws SQLException;
    void delete(Merchandise m) throws SQLException;
    ArrayList<Merchandise> list() throws SQLException;
    ArrayList<Merchandise> searchList(String text) throws SQLException;

}
