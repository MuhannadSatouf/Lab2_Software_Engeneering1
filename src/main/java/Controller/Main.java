package Controller;

import Models.DBMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {
    DBMethods dbMethods = new DBMethods();

    @FXML
    private Button depositButton;

    @FXML
    private Button withdrawButton;

    @FXML
    void depositButton(ActionEvent event) {

    }

    @FXML
    void withdrawButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbMethods.getAccountBalance(123456);
    }


}
