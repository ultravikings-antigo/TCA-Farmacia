package sample.control;

import com.itextpdf.layout.element.Table;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import sample.Browser;
import sample.model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;

public class SalesManWindow {

    @FXML
    private Label lbLogado;

    @FXML
    private TableView<Salesman> tbSalesman;

    @FXML
    private TableColumn<Salesman,Integer> tcSalesmanId;

    @FXML
    private TableColumn<Salesman,String> tcSalesmanName;

    @FXML
    private TableColumn<Salesman,String> tcSalesmanAddress;

    @FXML
    private TableColumn<Salesman,String> tcSalesmanCPF;

    @FXML
    private TableColumn<Salesman,String> tcSalesmanPassword;

    @FXML
    private TableColumn<Salesman,String> tcSalesmanEmail;

    @FXML
    private TableColumn<Salesman,Boolean> tcSalesmanAdmin;

    @FXML
    private TableColumn<Salesman,Float> tcSalesmanSalary;

    @FXML
    private TableColumn<Salesman,String> tcSalesmanTelephone;

    public void initialize() throws SQLException {
        tcSalesmanAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tcSalesmanAdmin.setCellValueFactory(new PropertyValueFactory<>("admin"));
        tcSalesmanCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tcSalesmanEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tcSalesmanId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcSalesmanName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tcSalesmanPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        tcSalesmanSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        tcSalesmanTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        tcSalesmanAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        tcSalesmanAdmin.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        tcSalesmanCPF.setCellFactory(TextFieldTableCell.forTableColumn());
        tcSalesmanEmail.setCellFactory(TextFieldTableCell.forTableColumn());
        tcSalesmanName.setCellFactory(TextFieldTableCell.forTableColumn());
        tcSalesmanPassword.setCellFactory(TextFieldTableCell.forTableColumn());
        tcSalesmanSalary.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        tcSalesmanTelephone.setCellFactory(TextFieldTableCell.forTableColumn());

        Salesman logado = Control.getInstance().logado();
        if(logado == null){
            lbLogado.setText("Logar");
        }else{
            lbLogado.setText(logado.getName());
        }

        tbSalesman.setItems(Control.getInstance().salesmenList());

    }

    @FXML
    public void actionLogin(){
        Browser.loadWindow(Browser.LOGIN);
    }

    @FXML
    public void actionBack(){
        Browser.loadWindow(Browser.MENU);
    }

    @FXML
    public void generateReport(){
        Control.getInstance().generateReportSalesman();
    }

    @FXML
    private void editCommitName(TableColumn.CellEditEvent cellEditEvent) throws SQLException{

        Salesman s = tbSalesman.getSelectionModel().getSelectedItem();
        s.setName(cellEditEvent.getNewValue().toString());

        Control.getInstance().updateSalesman(s);
    }

    @FXML
    private void editCommitAddress(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Salesman s = tbSalesman.getSelectionModel().getSelectedItem();
        s.setAddress(cellEditEvent.getNewValue().toString());

        Control.getInstance().updateSalesman(s);
    }

    @FXML
    private void editCommitAdmin(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Salesman s = tbSalesman.getSelectionModel().getSelectedItem();
        s.setAdmin(Boolean.valueOf(cellEditEvent.getNewValue().toString()));

        Control.getInstance().updateSalesman(s);
    }

    @FXML
    private void editCommitPassword(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Salesman s = tbSalesman.getSelectionModel().getSelectedItem();
        s.setPassword(cellEditEvent.getNewValue().toString());

        Control.getInstance().updateSalesman(s);
    }

    @FXML
    private void editCommitSalary(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Salesman s = tbSalesman.getSelectionModel().getSelectedItem();
        s.setSalary(Float.valueOf(cellEditEvent.getNewValue().toString()));

        Control.getInstance().updateSalesman(s);
    }

    @FXML
    private void editCommitTelephone(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Salesman s = tbSalesman.getSelectionModel().getSelectedItem();
        s.setTelephone(cellEditEvent.getNewValue().toString());

        Control.getInstance().updateSalesman(s);
    }

    @FXML
    private void editCommitCpf(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Salesman s = tbSalesman.getSelectionModel().getSelectedItem();
        s.setCpf(cellEditEvent.getNewValue().toString());

        Control.getInstance().updateSalesman(s);
    }

    @FXML
    private void editCommitEmail(TableColumn.CellEditEvent cellEditEvent) throws SQLException{
        Salesman s = tbSalesman.getSelectionModel().getSelectedItem();
        s.setEmail(cellEditEvent.getNewValue().toString());

        Control.getInstance().updateSalesman(s);
    }
}
