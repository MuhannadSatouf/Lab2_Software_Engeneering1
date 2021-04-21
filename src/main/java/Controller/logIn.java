package Controller;

import Models.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Stack;

public class logIn implements Initializable {
    PreparedStatement preparedStatement = null;
    Connection connection = null;
    ResultSet resultSet = null;
    @FXML
    private Button SignInButton;

    @FXML
    private Label lbError;

    @FXML
    private TextField userIdTextField, passwordTextField;


    @FXML
    void SignInButton(ActionEvent event) {
        loginMethod();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void loginMethod() {
        Database database = new Database();
        Database.getInstance();
        String person_number = userIdTextField.getText();
        String password = passwordTextField.getText();

        String sql = "SELECT * FROM User Where person_number = ? and password = ?";

        try {
            if (!userIdTextField.getText().isEmpty() && !passwordTextField.getText().isEmpty()) {

                preparedStatement = Database.getConnection().prepareStatement(sql);
                preparedStatement.setInt(1, Integer.parseInt(person_number));
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();

                if (!resultSet.next()) {
                    lbError.setText("Please Enter a valid User name and Password");
                } else {
                    alert("Login Successful", null, "Successful");

                    viewWindow("/View/Main.fxml");
                }
            } else {
                alert("Please fill all fields", null, "Error");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        database.disconnect();
    }


    private void alert(String message, String header, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(message);
        alert.setHeaderText(header);
        alert.showAndWait();
    }

    void viewWindow(String location) {
        try {
            Parent parent1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(location)));
            Stage window = (Stage) SignInButton.getScene().getWindow();
            window.setScene(new Scene(parent1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
