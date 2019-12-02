package sample.control;

import javafx.fxml.FXML;
import sample.Browser;
import sample.model.Control;

public class Report {

    @FXML
    public void actionBack(){
        Browser.loadWindow(Browser.MENU);
    }

    @FXML
    public void actionSalesDay(){

    }

    @FXML
    public void actionProduct(){
        Control.getInstance().generateReportMerchandise();
    }

    @FXML
    public void actionSalesMan(){
        Control.getInstance().generateReportSalesman();
    }


}
