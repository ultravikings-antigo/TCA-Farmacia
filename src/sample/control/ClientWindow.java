package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import sample.Browser;
import sample.model.Client;
import sample.model.Control;
import sample.model.Salesman;

import java.sql.SQLException;

public class ClientWindow {

    @FXML
    public Label lbLogado;

    @FXML
    private TableView<Client> tbClient;

    @FXML
    private TableColumn<Client,Integer> tcClientId;

    @FXML
    private TableColumn<Client,String> tcClientName;

    @FXML
    private TableColumn<Client,String> tcClientAddress;

    @FXML
    private TableColumn<Client,String> tcClientCPF;

    @FXML
    private TableColumn<Client,String> tcClientEmail;

    @FXML
    private TableColumn<Client,String> tcClientTelephone;

    @FXML
    private void initialize() throws SQLException {
        Salesman logado = Control.getInstance().logado();
        if(logado == null){
            lbLogado.setText("Logar");
        }else{
            lbLogado.setText(logado.getName());
        }

        tcClientAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tcClientCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tcClientEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcClientId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcClientName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcClientTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        tcClientAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        tcClientCPF.setCellFactory(TextFieldTableCell.forTableColumn());
        tcClientEmail.setCellFactory(TextFieldTableCell.forTableColumn());
        tcClientName.setCellFactory(TextFieldTableCell.forTableColumn());
        tcClientTelephone.setCellFactory(TextFieldTableCell.forTableColumn());

        tbClient.getItems().addAll(Control.getInstance().clientList());
    }

    @FXML
    public void actionBack(){
        Browser.loadWindow(Browser.MENU);
    }

    @FXML
    public void actionLogin(){
        Browser.loadWindow(Browser.LOGIN);
    }

    @FXML
    public void actionClose() {
        Control.getInstance().deslogar();
        lbLogado.setText("Logar");
    }

    @FXML
    private void editCommitName(TableColumn.CellEditEvent cellEditEvent) throws SQLException{

        Client c = tbClient.getSelectionModel().getSelectedItem();
        c.setName(cellEditEvent.getNewValue().toString());

        Control.getInstance().updateClient(c);
    }

    @FXML
    private void editCommitAddress(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Client c = tbClient.getSelectionModel().getSelectedItem();
        c.setAddress(cellEditEvent.getNewValue().toString());

        Control.getInstance().updateClient(c);
    }


    @FXML
    private void editCommitTelephone(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Client c = tbClient.getSelectionModel().getSelectedItem();
        c.setTelephone(cellEditEvent.getNewValue().toString());

        Control.getInstance().updateClient(c);
    }

    @FXML
    private void editCommitCpf(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Client c = tbClient.getSelectionModel().getSelectedItem();
        c.setCpf(cellEditEvent.getNewValue().toString());

        Control.getInstance().updateClient(c);
    }

    @FXML
    private void editCommitEmail(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Client c = tbClient.getSelectionModel().getSelectedItem();
        c.setEmail(cellEditEvent.getNewValue().toString());

        Control.getInstance().updateClient(c);
    }

    @FXML
    private void clientRegister(){
        Browser.loadFreeWindow(Browser.CLIENT_REGISTER);
    }
}
