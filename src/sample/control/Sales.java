package sample.control;

import javafx.fxml.FXML;
import sample.Browser;

public class Sales {

    @FXML
    public void actionBack(){
        Browser.loadWindows(Browser.MENU);
    }
}
