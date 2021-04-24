package Controller;


import Models.DBMethods;
import Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Main implements Initializable {
    private final DBMethods dbMethods = new DBMethods();
    private final User currentUser = UserSingleton.getInstance().getUser();
    private final Account account = dbMethods.getAccount(currentUser.getAccount_number());


    @FXML
    private TextField acc_number;

    @FXML
    private TextField acc_balance;

    @FXML
    private Label lb_hello;

    @FXML
    void depositButton(ActionEvent event) {
        Transaction transaction = new Transaction(account);
        transaction.deposit(100);
        dbMethods.addTransaction(transaction);
        acc_balance.setText(String.valueOf(account.getAccount_balance()));
    }

    @FXML
    void withdrawButton(ActionEvent event) {
        Transaction transaction = new Transaction(account);
        if (!transaction.withdraw(100)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Balance is not enough to make a withdrawal");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
        dbMethods.addTransaction(transaction);
        acc_balance.setText(String.valueOf(account.getAccount_balance()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_balance.setText(String.valueOf(account.getAccount_balance()));
        acc_number.setText(String.valueOf(account.getAccount_number()));
        lb_hello.setText("Welcome, " + currentUser.getName());

    }


}
