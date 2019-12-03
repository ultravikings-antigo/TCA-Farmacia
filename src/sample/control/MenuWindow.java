package sample.control;

import javafx.fxml.FXML;
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
    private void actionSalesman(){
        Salesman s = Control.getInstance().logado();
        System.out.println(s.getAdmin());
        boolean b = s.getAdmin();
        if(!b){
            System.out.println("Você Precisa ser um Adm para entrar aq");
        }else{
            Browser.loadWindow(Browser.SALESMAN);

        }
    }

    @FXML
    private void actionReport(){
        Browser.loadWindow(Browser.REPORT);

    }


}
