package sample.modelDAO;

import sample.model.Provider;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProviderDAO {

    Provider insert (String name, String telephone, String email) throws SQLException;
    Provider update(String name, String telephone, String email) throws SQLException;
    boolean delete(String name, int id) throws SQLException;
    ArrayList<Provider> list() throws SQLException;
    Provider IdSearch(int id) throws SQLException;
}
