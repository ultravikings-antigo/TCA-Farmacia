package sample.control;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
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

public class SalesWindow {

    @FXML
    private Label lbLogado;


    ///TABLE SALES
    @FXML
    private TableView<SoldMerchandise> tbvSales;

    @FXML
    private TableColumn<SoldMerchandise, String> tcSalesName;

    @FXML
    private TableColumn<SoldMerchandise, Integer> tcSalesAmount;

    @FXML
    private TableColumn<SoldMerchandise, Integer> tcSalesDiscount;

    @FXML
    private TableColumn<SoldMerchandise, Float> tcSalesTotalPrice;

    @FXML
    private TableColumn<SoldMerchandise, Float> tcSalesPrice;

    ///TABLE MERCHANDISE
    @FXML
    private TableView<Merchandise> tbvMerchandise;

    @FXML
    private TableColumn<Merchandise, Integer> tcMerchandiseId;

    @FXML
    private TableColumn<Merchandise, String> tcMerchandiseName;

    @FXML
    private TableColumn<Merchandise, Float> tcMerchandisePrice;

    @FXML
    private TableColumn<Merchandise, Integer> tcMerchandiseStorage;

    public void initialize() throws SQLException {
        Salesman logado = Control.getInstance().logado();
        if(logado == null){
            lbLogado.setText("Logar");
        }else{
            lbLogado.setText(logado.getName());
        }

        ///TABLE MERCHANDISE
        tcMerchandiseId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tcMerchandiseName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tcMerchandiseStorage.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        tcMerchandisePrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tbvMerchandise.setItems(Control.getInstance().merchandiseList());


        ///TABLE SALES
        tcSalesName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tcSalesDiscount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        tcSalesAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
        tcSalesPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tcSalesTotalPrice.setCellValueFactory(new PropertyValueFactory<>("TotalPrice"));

        tcSalesAmount.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        tcSalesDiscount.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        ///INITIALIZING A NEW SALE
        Control.getInstance().getSale().setClient(new Client());

        if(Control.getInstance().getLogedSalesman() != null){
            Control.getInstance().getSale().setSalesman(Control.getInstance().getLogedSalesman());
        }
        else {
            Control.getInstance().getSale().setSalesman(new Salesman());
        }

        Control.getInstance().getSale().setDate(Date.from(Instant.now()));
        Control.getInstance().getSale().setTotalValue((float)0.0);

        tbvMerchandise.setItems(Control.getInstance().merchandiseList());
        tbvSales.setItems(Control.getInstance().getSale().getSoldMerchandises());

        Control.getInstance().getSale().getSoldMerchandises().addListener(new ListChangeListener<SoldMerchandise>() {
            @Override
            public void onChanged(Change<? extends SoldMerchandise> c){
                try {
                    if(!Control.getInstance().getSale().getSoldMerchandises().isEmpty()){
                        Control.getInstance().updateMerchandiseStorage(tbvMerchandise.getSelectionModel().getSelectedItem().getId(), Control.getInstance().getSoldMerchandise().getAmount());
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    private void actionLogin(){
        Browser.loadWindow(Browser.LOGIN);
    }

    @FXML
    private void actionAddItem(){
        SoldMerchandise soldMerchandise = new SoldMerchandise();
        soldMerchandise.setPrice(tbvMerchandise.getSelectionModel().getSelectedItem().getPrice());
        soldMerchandise.setName(tbvMerchandise.getSelectionModel().getSelectedItem().getName());

        Control.getInstance().atualizeSoldMerchandise(soldMerchandise);

        Browser.loadFreeWindow(Browser.SALE_ADD_ITEM);

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
    private void finalizeSale()throws SQLException{

        if(!Control.getInstance().getSale().getSoldMerchandises().isEmpty()){
            Browser.loadFreeWindow(Browser.FINALIZE);
        }
    }

    @FXML
    private void actionBack()
    {
        Browser.loadWindow(Browser.MENU);
    }
}
