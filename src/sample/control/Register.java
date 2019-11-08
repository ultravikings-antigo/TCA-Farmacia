package sample.control;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import sample.Browser;



public class Register {

    @FXML
    private JFXTextField tfName;

    @FXML
    private Text txtName;

    @FXML
    private JFXTextField tfAddress;

    @FXML
    private Text txtAddress;

    @FXML
    private JFXTextField tfTelephone;

    @FXML
    private Text txtTelephone;

    @FXML
    private JFXTextField tfCpf;

    @FXML
    private Text txtCpf;

    @FXML
    private JFXTextField tfEmail;

    @FXML
    private Text txtEmail;

    @FXML
    private JFXPasswordField tfPassword1;

    @FXML
    private Text txtPassword1;

    @FXML
    private JFXPasswordField tfPassword2;

    @FXML
    private Text txtPassword2;

    @FXML
    private Text txtTelephoneError;


    @FXML
    public void actionBack(){
        Browser.loadWindows(Browser.LOGIN);
    }

    @FXML
    public void actionRegister(){
        if (tfName.getText().equals("")){
            txtName.setVisible(true);
        }else{
            txtName.setVisible(false);
            if (tfAddress.getText().equals("")){
                txtAddress.setVisible(true);
            }else{
                txtAddress.setVisible(false);
                if (tfTelephone.getText().equals("")){
                    txtTelephone.setVisible(true);
                }else{
                    txtTelephone.setVisible(false);
                    if (tfTelephone.getLength() < 7){
                        txtTelephoneError.setVisible(true);
                    }else{
                        txtTelephoneError.setVisible(false);
                        if (tfCpf.getText().equals("")){
                            txtCpf.setVisible(true);
                        }else{
                            txtCpf.setVisible(false);
                            if (tfEmail.getText().equals("")){
                                txtEmail.setVisible(true);
                            }else{
                                txtEmail.setVisible(false);
                                if (tfPassword1.getText().equals("")){
                                    txtPassword1.setVisible(true);
                                }else{
                                    txtPassword1.setVisible(false);

                                    if (tfPassword2.getText().equals("")){
                                        txtPassword2.setVisible(true);
                                    }else{
                                        txtPassword2.setVisible(false);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
