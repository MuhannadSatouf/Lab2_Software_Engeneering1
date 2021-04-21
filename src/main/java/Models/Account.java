package Models;

public class Account {
    private double account_balance;
    private int account_number;

    public Account(int account_number, double account_balance){
        setAccount_balance(account_balance);
        setAccount_number(account_number);
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    public double getAccount_balance() {
        return account_balance;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }
}
