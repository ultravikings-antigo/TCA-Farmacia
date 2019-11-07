package sample.control;

import javafx.fxml.FXML;
import sample.Browser;

import javax.xml.soap.Text;

public class Register {

    @FXML
    private Text txtUser;

    @FXML
    private Text txtAddress;

    @FXML
    private Text txtTelephone;

    @FXML
    private Text txtCpf;

    @FXML
    private Text txtEmail;

    @FXML
    private Text txtPassword1;

    @FXML
    private Text txtPassword2;

    @FXML
    public void actionBack(){
        Browser.loadWindows(Browser.LOGIN);
    }

    @FXML
    public void actionRegister(){
        
    }

}
