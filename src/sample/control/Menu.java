package sample.control;

import javafx.fxml.FXML;
import sample.Browser;

public class Menu {

    @FXML
    public void actionSales(){
        Browser.loadWindows(Browser.SALES);
    }

    @FXML
    public void actionStorage(){
        Browser.loadWindows(Browser.STORAGE);
    }
}
