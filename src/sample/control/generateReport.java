/*package sample.control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.Browser;

import java.sql.SQLException;

public class generateReport {

    @FXML
    private JFXComboBox<StorageWindow> storageWindow;

    @FXML
    private JFXDatePicker dpDataInicial;

    @FXML
    private JFXDatePicker dpDataFinal;

    @FXML
    private JFXButton btCategoria;

    @FXML
    private JFXButton btPeriodo;

    @FXML
    void initialize() throws SQLException {
        dpDataInicial.setVisible(false);
        dpDataFinal.setVisible(false);
        cbCategoria.setVisible(false);

        cbCategoria.setItems(Controle.getInstace().listarCategoria());
    }


    public void acaoVoltar(ActionEvent actionEvent) {
        Browser.loadWindows(Browser.MAIN);
    }

    public void acaoFechar(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void acaoGerar(ActionEvent actionEvent) throws SQLException {

        if(dpDataFinal.getValue() != null && dpDataInicial.getValue()!= null && cbCategoria.getSelectionModel().getSelectedItem() != null){
            ObservableList<Despesa> despesas = Controle.getInstace().verificaPeriodo(dpDataInicial.getValue(), dpDataFinal.getValue());
            Controle.getInstace().setRelatorioPeriodo(despesas);
            ObservableList<Despesa> despesas2 = Controle.getInstace().verificaCategoria(cbCategoria.getSelectionModel().getSelectedItem());
            Controle.getInstace().setRelatorioCategoria(despesas2);
            Controle.getInstace().gerarRelatorio("todos");
        }
        else{
            if (dpDataInicial.getValue() == null || dpDataFinal == null){
                Aviso( "Selecione as datas");
            }else {
                ObservableList<Despesa> despesas = Controle.getInstace().verificaPeriodo(dpDataInicial.getValue(), dpDataFinal.getValue());
                Controle.getInstace().setRelatorioPeriodo(despesas);
                Controle.getInstace().gerarRelatorio("por Periodo");
            }

            if(cbCategoria.getSelectionModel().getSelectedItem() == null){
                Aviso( "Selecione uma categoria");
            }else {
                ObservableList<Despesa> despesas = Controle.getInstace().verificaCategoria(cbCategoria.getSelectionModel().getSelectedItem());
                Controle.getInstace().setRelatorioCategoria(despesas);
                Controle.getInstace().gerarRelatorio("por Categoria");
            }
        }
    }

    public void acaoPeriodo(ActionEvent actionEvent) {
        btPeriodo.setDisable(true);
        btCategoria.setDisable(false);
        dpDataInicial.setVisible(true);
        dpDataFinal.setVisible(true);
        cbCategoria.setVisible(false);
    }

    public void acaoCategoria(ActionEvent actionEvent) {
        btCategoria.setDisable(true);
        dpDataInicial.setVisible(false);
        dpDataFinal.setVisible(false);
        cbCategoria.setVisible(true);
        btPeriodo.setDisable(false);
    }
}
*/