package sample.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import sample.Browser;
import sample.model.Control;
import sample.model.Merchandise;

import java.io.IOException;
import java.sql.SQLException;

public class StorageWindow {

    @FXML
    private TableView<Merchandise> tbvStorage;

    @FXML
    private TableColumn<Merchandise, Integer> tcId;

    @FXML
    private TableColumn<Merchandise, String> tcName;

    @FXML
    private TableColumn<Merchandise, Integer> tcAmount;

    @FXML
    private TableColumn<Merchandise, Float> tcPrice;

    private Parent content;

    public void initialize() throws SQLException {
        tcId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tcPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));
        tcAmount.setCellValueFactory(new PropertyValueFactory<>("Amount"));

        tcName.setCellFactory(TextFieldTableCell.forTableColumn());
        tcPrice.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        tcAmount.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        tbvStorage.setItems(Control.getInstance().merchandiseList());
    }

    @FXML
    private void actionLogin(){
        Browser.loadWindow(Browser.LOGIN);
    }

    @FXML
    private void editCommitPrice(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Merchandise m = tbvStorage.getSelectionModel().getSelectedItem();
        m.setPrice(Float.valueOf(cellEditEvent.getNewValue().toString()));


        Control.getInstance().updateMerchandise(m);
    }

    @FXML
    private void editCommitName(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Merchandise m = tbvStorage.getSelectionModel().getSelectedItem();
        m.setName(String.valueOf(cellEditEvent.getNewValue().toString()));

        Control.getInstance().updateMerchandise(m);
    }

    @FXML
    private void editCommitAmount(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Merchandise m = tbvStorage.getSelectionModel().getSelectedItem();
        m.setAmount(Integer.valueOf(cellEditEvent.getNewValue().toString()));

        Control.getInstance().updateMerchandise(m);
    }

    @FXML
    private void merchandiseRegister() throws IOException {
        Browser.loadFreeWindow(Browser.MERCHANDISE_REGISTER);

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
    public void actionBack(){
        Browser.loadWindow(Browser.MENU);
    }
}
