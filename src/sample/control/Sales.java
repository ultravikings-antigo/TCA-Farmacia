package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import sample.Browser;
import sample.model.Control;
import sample.model.Merchandise;

import java.sql.SQLException;

public class Sales {

    @FXML
    private TableView<Merchandise> tbSales;

    @FXML
    private TableView<Sales>  tbMerchandise;

    @FXML
    private TableColumn<Merchandise,Integer> tcSalesId;

    @FXML
    private TableColumn<Merchandise,String> tcSalesName;

    @FXML
    private TableColumn<Merchandise,Integer> tcSalesStorage;

    @FXML
    private TableColumn<Merchandise,Float> tcSalesValue;

    @FXML
    private TableColumn<Sales,Integer> tcMerchandiseId;

    @FXML
    private TableColumn<Sales,String> tcMerchandiseName;

    @FXML
    private TableColumn<Sales,Integer> tcMerchandiseStorage;

    @FXML
    private TableColumn<Sales,Float> tcMerchandiseValue;

    @FXML
    private TableColumn<Sales,Integer> tcMerchandiseDesconto;

    @FXML
    private TableColumn<Sales,Float> tcMerchandiseTotalValue;

    public void initialize() throws SQLException {
        tcSalesId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tcSalesName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tcSalesStorage.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        tcSalesValue.setCellValueFactory(new PropertyValueFactory<>("Price"));

        tbSales.setItems(Control.getInstance().merchandiseList());
    }

    @FXML
    private void actionLogin(){

    }

    @FXML
    private void actionSale(){

        //tbMerchandise.setItems(tbSales.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void actionSearch(KeyEvent evt){
        String text = ((TextField)evt.getSource()).getText();

        try{
            if(text.length() <= 1){
                Control.getInstance().merchandiseList();
            }else{

                if(text.length() >= 2){
                    Control.getInstance().merchandiseSearch(text);
                }
            }
        }catch (SQLException e){
            System.out.printf("Erro ao realizar busca");
        }
    }

    @FXML
    public void actionBack()
    {
        Browser.loadWindows(Browser.MENU);

    }

}
