package sample.control;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class Base{

    @FXML
    private StackPane base;

    public void setWindow(Node node){
        base.getChildren().setAll(node);
    }
}
