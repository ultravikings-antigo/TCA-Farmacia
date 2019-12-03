package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.Client;
import sample.model.Control;
import sample.model.Merchandise;

import java.sql.SQLException;

public class ClientRegisterWindow {

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfAddress;

    @FXML
    private TextField tfTelephone;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfEmail;

    @FXML
    private Button closeWindow;

    @FXML
    private void actionConclude() throws SQLException {
        String name = tfName.getText();
        String address = tfAddress.getText();
        String telephone = tfTelephone.getText();
        String cpf = tfCpf.getText();
        String email = tfEmail.getText();

        Client c = new Client(name,address,cpf,telephone,email);
        Control.getInstance().clientRegister(c);

        tfAddress.clear();
        tfName.clear();
        tfTelephone.clear();
        tfCpf.clear();
        tfEmail.clear();

        actionCancel();
    }












    @FXML
    private void actionCancel(){
        Stage stage = (Stage) closeWindow.getScene().getWindow();
        stage.close();
    }
}
