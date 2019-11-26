package sample.control;

import javafx.fxml.FXML;
import sample.Browser;

public class MenuWindow {

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
        Browser.loadWindow(Browser.MENU);
    }
}
