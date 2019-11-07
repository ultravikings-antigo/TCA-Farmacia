package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import sample.control.Base;

import java.io.IOException;

public class Browser {

    public static final String BASE = "/view/base.fxml";
    public static final String LOGIN = "/view/login.fxml";
    public static final String REGISTER = "/view/register.fxml";
    private static Base controller;

    public static void setController(Base controller) {
        Browser.controller = controller;
    }

    public static void loadWindows(String fxml) {
        try { controller.setWindow((Node) FXMLLoader.load(Browser.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}