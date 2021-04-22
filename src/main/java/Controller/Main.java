package Controller;


import Models.DBMethods;
import Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    void depositButton(ActionEvent event) {
        Transaction transaction = new Transaction(account);
        transaction.deposit(100);
        dbMethods.addTransaction(transaction);
        acc_balance.setText(String.valueOf(account.getAccount_balance()));
    }

    @FXML
    void withdrawButton(ActionEvent event) {
        // this i left for you to continue :) not much difference from deposit.
        // you do NOT need to set amount with minus - will be done by  transaction.withdrawal method
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_balance.setText(String.valueOf(account.getAccount_balance()));
        acc_number.setText(String.valueOf(account.getAccount_number()));

    }


}
