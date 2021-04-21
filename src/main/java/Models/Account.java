package Models;

public class Account {
    private int account_number;
    private double account_balance;

    public Account(int account_number, double account_balance){
        setAccount_number(account_number);
        setAccount_balance(account_balance);
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public void setAccount_balance(double account_balance) {
        this.account_balance = account_balance;
    }

    public int getAccount_number() {
        return account_number;
    }

    public double getAccount_balance() {
        return account_balance;
    }
}
