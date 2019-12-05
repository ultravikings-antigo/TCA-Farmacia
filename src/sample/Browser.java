package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
    public static final String REPORT = "/view/report.fxml";
    public static final String SALESMAN = "/view/salesman.fxml";
    public static final String CLIENT = "/view/client.fxml";
    public static final String CLIENT_REGISTER = "/view/clientRegister.fxml";
    public static final String SALE_ADD_ITEM = "/view/saleAddItem.fxml";
    public static final String FINALIZE = "/view/finalizeSale.fxml";



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

    public static void loadFreeWindow(String fxml){
        try {
            Pane root;

            root = FXMLLoader.load(
                    Browser.class.getResource(
                            fxml
                    )
            );


            Scene scene = new Scene(root,root.getPrefWidth(), root.getPrefHeight());
            Stage stage = new Stage();

            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}