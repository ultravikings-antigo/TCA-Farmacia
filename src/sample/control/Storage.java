package sample.control;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import sample.Browser;
import sample.model.Control;
import sample.model.Merchandise;

import java.awt.*;
import java.sql.SQLException;

public class Storage {

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

    @FXML
    private TextArea taName;

    @FXML
    private TextArea taValue;

    @FXML
    private TextArea taQuantity;

    @FXML
    private TextField tfSearch;

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

    }

    @FXML
    private void editCommitPrice() throws SQLException{
        Merchandise m = tbvStorage.getSelectionModel().getSelectedItem();

        Control.getInstance().updateMerchandise(m);    }

    @FXML
    private void editCommitName() throws SQLException{
        Merchandise m = tbvStorage.getSelectionModel().getSelectedItem();

        Control.getInstance().updateMerchandise(m);
    }

    @FXML
    private void editCommitAmount() throws SQLException{
        Merchandise m = tbvStorage.getSelectionModel().getSelectedItem();

        Control.getInstance().updateMerchandise(m);
    }

    @FXML
    private void actionSearch(KeyEvent evt){
        String text = ((TextField)evt.getSource()).getText();

        try{
            if(text.length() <= 2){
                Control.getInstance().merchandiseList();
            }else{

                if(text.length() >= 3){
                    Control.getInstance().merchandiseSearch(text);
                }
            }
        }catch (SQLException e){
            System.out.printf("Erro ao realizar busca");
        }
    }

    @FXML
    public void actionBack(){
        Browser.loadWindows(Browser.MENU);
    }
}
