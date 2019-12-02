package sample.control;

import javafx.fxml.FXML;
import javafx.scene.layout.BackgroundRepeat;
import sample.Browser;
import sample.model.Control;

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

    @FXML
    private void actionReport(){
        Browser.loadWindow(Browser.REPORT);

    }
}
