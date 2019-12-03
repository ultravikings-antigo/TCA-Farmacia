package sample.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.util.converter.IntegerStringConverter;
import sample.Browser;
import sample.model.*;

import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;

public class SalesWindow {

    @FXML
    private Label lbLogado;

    @FXML
    private TableView<Merchandise> tbMerchandise;





    @FXML
    private TableView<SoldMerchandise> tbSales;






    @FXML
    private TableColumn<Merchandise,Integer> tcSalesId;

    @FXML
    private TableColumn<Merchandise,String> tcSalesName;

    @FXML
    private TableColumn<Merchandise,Integer> tcSalesStorage;

    @FXML
    private TableColumn<Merchandise,Float> tcSalesValue;




    @FXML
    private TableColumn<SoldMerchandise,Integer> tcMerchandiseId;

    @FXML
    private TableColumn<SoldMerchandise,String> tcMerchandiseName;

    @FXML
    private TableColumn<SoldMerchandise,Integer> tcMerchandiseStorage;

    @FXML
    private TableColumn<SoldMerchandise,Float> tcMerchandiseValue;

    @FXML
    private TableColumn<SoldMerchandise,Integer> tcSalesDiscount;

    @FXML
    private TableColumn<SoldMerchandise,Float> tcSalesTotalValue;






    private Sales sale;

    public void initialize() throws SQLException {

        Salesman logado = Control.getInstance().logado();
        if(logado == null){
            lbLogado.setText("Logar");
        }else{
            lbLogado.setText(logado.getName());
        }

        tcMerchandiseId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tcMerchandiseName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tcMerchandiseStorage.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        tcMerchandiseValue.setCellValueFactory(new PropertyValueFactory<>("Price"));

        tbMerchandise.setItems(Control.getInstance().merchandiseList());






        tcSalesId.setCellValueFactory(new PropertyValueFactory<>("Id"));

        tcSalesDiscount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        tcSalesDiscount.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        tcSalesName.setCellValueFactory(new PropertyValueFactory<>("Name"));

        tcSalesStorage.setCellValueFactory(new PropertyValueFactory<>("Amount"));

        tcSalesTotalValue.setCellValueFactory(new PropertyValueFactory<>("Total_Value"));

        tcSalesValue.setCellValueFactory(new PropertyValueFactory<>("Price"));


        sale = new Sales(null, Control.getInstance().getLogedSalesman(), Date.from(Instant.now()), (float)0.0);

        tbSales.setItems(sale.getMerchandises());
    }

    @FXML
    private void actionLogin(){
        Browser.loadWindow(Browser.LOGIN);
    }

    @FXML
    private void actionAddItem(){
        Merchandise m = tbMerchandise.getSelectionModel().getSelectedItem();

        System.out.println(m);

        SoldMerchandise soldMerchandise = new SoldMerchandise();

        soldMerchandise.setName(m.getName());
        soldMerchandise.setAmount(m.getAmount());
        soldMerchandise.setPrice(m.getPrice());
        soldMerchandise.setMerchandise(m);

        sale.getMerchandises().add(soldMerchandise);

        tbSales.setItems(sale.getMerchandises());
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

    @FXML
    private void ecDesconto(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        SoldMerchandise s = tbSales.getSelectionModel().getSelectedItem();
        s.setAmount(Integer.valueOf(cellEditEvent.getNewValue().toString()));

    }
}
