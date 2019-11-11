package sample.control;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sample.Browser;
import sample.model.Control;
import sample.model.Salesman;

import java.sql.SQLException;

public class Login {

    @FXML
    private JFXTextField tfUser;

    @FXML
    private JFXPasswordField tfPassword;

    @FXML
    private Text txtUser;

    @FXML
    private Text txtPassword;

    @FXML
    private Text txtError;

    @FXML
    public void actionRegister(){
        Browser.loadWindows(Browser.REGISTER);
    }

    @FXML
    public void actionLogin() throws SQLException {
        if (tfUser.getText().equals("")){
            txtUser.setVisible(true);
        }else{
            txtUser.setVisible(false);
            if (tfPassword.getText().equals("")){
                txtPassword.setVisible(true);
            }else{
                txtPassword.setVisible(false);

                Salesman s = Control.getInstance().login(tfUser.getText(),tfPassword.getText());

                if (s == null){
                    txtError.setVisible(true);
                }else{
                    Browser.loadWindows(Browser.MENU);
                }
            }
        }
    }
}
