package Models;

public class Account {
    private double account_balance;

    public Account(double account_balance){
        setAccount_balance(account_balance);
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    public double getAccount_balance() {
        return account_balance;
    }
}
