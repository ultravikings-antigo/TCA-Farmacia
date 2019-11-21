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

public class SalesWindow {

    @FXML
    private TableView<Merchandise> tbMerchandise;

    @FXML
    private TableView<SalesWindow> tbSales;

    @FXML
    private TableColumn<Merchandise,Integer> tcSalesId;

    @FXML
    private TableColumn<Merchandise,String> tcSalesName;

    @FXML
    private TableColumn<Merchandise,Integer> tcSalesStorage;

    @FXML
    private TableColumn<Merchandise,Float> tcSalesValue;

    @FXML
    private TableColumn<SalesWindow,Integer> tcMerchandiseId;

    @FXML
    private TableColumn<SalesWindow,String> tcMerchandiseName;

    @FXML
    private TableColumn<SalesWindow,Integer> tcMerchandiseStorage;

    @FXML
    private TableColumn<SalesWindow,Float> tcMerchandiseValue;

    @FXML
    private TableColumn<SalesWindow,Integer> tcSalesDiscount;

    @FXML
    private TableColumn<SalesWindow,Float> tcSalesTotalValue;

    public void initialize() throws SQLException {
        tcMerchandiseId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tcMerchandiseName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tcMerchandiseStorage.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        tcMerchandiseValue.setCellValueFactory(new PropertyValueFactory<>("Price"));

        tbMerchandise.setItems(Control.getInstance().merchandiseList());

        tcSalesId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tcSalesDiscount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        tcSalesName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tcSalesStorage.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        tcSalesTotalValue.setCellValueFactory(new PropertyValueFactory<>("Total_Value"));
        tcSalesValue.setCellValueFactory(new PropertyValueFactory<>("Value"));
    }

    @FXML
    private void actionLogin(){
        Browser.loadWindow(Browser.LOGIN);
    }

    @FXML
    private void actionSale() throws SQLException{
        tbMerchandise.getSelectionModel().getSelectedItem();

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
        Browser.loadWindow(Browser.MENU);

    }

}
