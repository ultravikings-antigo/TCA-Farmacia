package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Browser;
import sample.model.Control;
import sample.model.Merchandise;

import java.sql.SQLException;

public class Sales {

    @FXML
    private TableView<Merchandise> tbSales;

    @FXML
    private TableColumn<Merchandise,Integer> tcSalesId;

    @FXML
    private TableColumn<Merchandise,String> tcSalesName;

    @FXML
    private TableColumn<Merchandise,Integer> tcSalesStorage;

    @FXML
    private TableColumn<Merchandise,Float> tcSalesValue;

    public void initialize() throws SQLException {
        tcSalesId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tcSalesName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tcSalesStorage.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        tcSalesValue.setCellValueFactory(new PropertyValueFactory<>("Price"));

        tbSales.setItems(Control.getInstance().merchandiseList());
    }

    @FXML
    public void actionBack()
    {
        Browser.loadWindows(Browser.MENU);

    }
}
