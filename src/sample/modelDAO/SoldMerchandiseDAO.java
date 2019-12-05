package sample.modelDAO;

import sample.model.SoldMerchandise;

import java.sql.SQLException;

public interface SoldMerchandiseDAO {

    void insert(SoldMerchandise sm, int saleId) throws SQLException;
}
