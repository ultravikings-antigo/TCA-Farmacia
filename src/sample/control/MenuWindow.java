package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BackgroundRepeat;
import sample.Browser;
import sample.model.Control;
import sample.model.Salesman;

public class MenuWindow {

    @FXML
    public Label lbLogado;

    @FXML
    public void initialize(){

        Salesman logado = Control.getInstance().logado();
        if(logado == null){
            lbLogado.setText("Logar");
        }else{
            lbLogado.setText(logado.getName());
        }
    }

    @FXML
    public void actionClose() {
        Control.getInstance().deslogar();
        lbLogado.setText("Logar");
    }

    @FXML
    public void actionSales(){
        Browser.loadWindow(Browser.SALES);
    }

    @FXML
    public void actionStorage(){
        Browser.loadWindow(Browser.STORAGE);
    }

    @FXML
    private void actionLogin(){
        Browser.loadWindow(Browser.LOGIN);
    }

    @FXML
    private void actionClient(){
        Browser.loadWindow(Browser.CLIENT);
    }

    @FXML
    private void actionSalesman(){
        Salesman s = Control.getInstance().logado();

        if (s == null || !s.getAdmin()){
            Alert a = new Alert(Alert.AlertType.WARNING, "Apenas Administradores Podem Entrar Aqui", ButtonType.CLOSE);
            a.showAndWait();
        }else{
            Browser.loadWindow(Browser.SALESMAN);
        }
    }

    @FXML
    private void actionReport(){
        Browser.loadWindow(Browser.REPORT);

    }


}
