package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.control.BaseWindow;

import java.io.IOException;

public class Main extends Application {

    public void start(Stage stage) throws Exception {

        Pane root = loadMainPane();
        stage.setScene(new Scene(root, 1280, 720));
        stage.initStyle(StageStyle.DECORATED);
        stage.setResizable(false);
        stage.show();
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(
                        Browser.BASE
                )
        );

        BaseWindow controller = loader.getController();

        Browser.setController(controller);
        Browser.loadWindow(Browser.MENU);

        return mainPane;
    }
}
