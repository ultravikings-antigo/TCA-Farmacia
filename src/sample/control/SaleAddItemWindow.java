package sample.control;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.model.Control;
import sample.model.Merchandise;
import sample.model.SoldMerchandise;

public class SaleAddItemWindow {

    @FXML
    private TextField tfAmount;

    @FXML
    private TextField tfDiscount;

    @FXML
    private Button closeWindow;

    @FXML
    private void actionCancel(){
        fecharTelaAction();
    }

    @FXML
    private void actionConclude(){
        int amount;
        int discount = 0;

        try{
            amount = Integer.valueOf(tfAmount.getText());
            if(tfDiscount.getText().length() != 0){
                discount = Integer.valueOf(tfDiscount.getText());
            }

            if(amount > 0){
                try {
                    SoldMerchandise soldMerchandise = Control.getInstance().getSoldMerchandise();

                    soldMerchandise.setAmount(amount);
                    soldMerchandise.setDiscount(discount);
                    soldMerchandise.setTotalPrice(soldMerchandise.getPrice() * amount);

                    Control.getInstance().atualizeSoldMerchandise(soldMerchandise);

                    Control.getInstance().addSoldMerchandise();

                    fecharTelaAction();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                Alert a = new Alert(Alert.AlertType.WARNING, "ERRO!\nInsira valores validos!", ButtonType.CLOSE);
            }

        }catch (Exception e){
            Alert a = new Alert(Alert.AlertType.WARNING, "ERRO!\nInsira valores validos!", ButtonType.CLOSE);
            a.showAndWait();
            e.printStackTrace();
        }
    }

    @FXML
    private void fecharTelaAction(){
        Stage stage = (Stage) closeWindow.getScene().getWindow();
        stage.close();
    }
}
