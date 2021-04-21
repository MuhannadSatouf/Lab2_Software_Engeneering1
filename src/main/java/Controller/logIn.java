package Controller;

import Models.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class logIn {
    Database database = new Database();
    @FXML
    private Button SignInButton;

    @FXML
    private TextField userIdTextField;

    @FXML
    private TextField PasswordTextField;

    @FXML
    void SignInButton(ActionEvent event) {
        database.connect();
    }

}
