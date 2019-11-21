package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.control.BaseWindow;

import java.io.IOException;

public class Browser {

    public static final String BASE = "/view/base.fxml";
    public static final String LOGIN = "/view/login.fxml";
    public static final String REGISTER = "/view/register.fxml";
    public static final String MENU = "/view/menu.fxml";
    public static final String SALES = "/view/sales.fxml";
    public static final String STORAGE = "/view/storage.fxml";
    public static final String MERCHANDISE_REGISTER = "/view/merchandiseRegister.fxml";

    private static BaseWindow controller;

    public static void setController(BaseWindow controller) {
        Browser.controller = controller;
    }

    public static void loadWindow(String fxml) {
        try {
            controller.setWindow((Node) FXMLLoader.load(Browser.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}