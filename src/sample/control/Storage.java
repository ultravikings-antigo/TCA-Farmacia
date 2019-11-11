package sample.control;

import javafx.fxml.FXML;
import sample.Browser;

public class Storage {
    @FXML
    public void actionBack(){
        Browser.loadWindows(Browser.MENU);
    }
}
