package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import sample.model.Client;
import sample.model.Control;
import sample.model.Salesman;

import java.sql.SQLException;

public class FinalizeSale {

    @FXML
    private ComboBox<Client> cbClients;

    @FXML
    private ComboBox<Salesman> cbSalesman;

    @FXML
    private Button btCancel;

    public void initialize() throws SQLException {
        cbClients.setItems(Control.getInstance().clientList());
        cbSalesman.setItems(Control.getInstance().salesmenList());
    }

    @FXML
    private void fecharTelaAction(){
        Stage stage = (Stage) btCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void actionConclude() throws SQLException{
        if(cbClients.getSelectionModel().getSelectedItem() != null && cbSalesman.getSelectionModel().getSelectedItem() != null){
            Control.getInstance().getSale().setSalesman(cbSalesman.getSelectionModel().getSelectedItem());
            Control.getInstance().getSale().setClient(cbClients.getSelectionModel().getSelectedItem());
            Control.getInstance().finalizeSale();

            fecharTelaAction();
        }
        else {
            Alert a = new Alert(Alert.AlertType.WARNING, "ERRO!\nSelecione os itens necessários", ButtonType.CLOSE);
        }
    }

    @FXML
    private void actionCancel(){
        fecharTelaAction();
    }

}
