package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.Browser;
import sample.model.Control;
import sample.model.Merchandise;

import java.sql.SQLException;

public class MerchandiseRegisterWindow {
    @FXML
    private TextField tfName;

    @FXML
    private TextField tfPrice;

    @FXML
    private TextField tfAmount;

    @FXML
    private AnchorPane window;

    @FXML
    private void actionCancel(){
        Browser.loadWindow(Browser.STORAGE);
    }

    @FXML
    private void actionConclude(){
        float price;
        String name = tfName.getText();
        int amount;

        try{
            price = Float.valueOf(tfPrice.getText());
            amount = Integer.valueOf(tfAmount.getText());
            try{
                Merchandise m = new Merchandise(name, amount, price);
                Control.getInstance().merchandiseRegister(m);
                tfAmount.clear();
                tfName.clear();
                tfPrice.clear();
            } catch (SQLException e){
                Alert a = new Alert(Alert.AlertType.WARNING, "ERRO!", ButtonType.CLOSE);
                a.showAndWait();
                e.printStackTrace();
            }

        } catch (Exception e){
            Alert a = new Alert(Alert.AlertType.WARNING, "ERRO!\nInsira valores validos!", ButtonType.CLOSE);
            a.showAndWait();
            e.printStackTrace();
        }
    }
}
