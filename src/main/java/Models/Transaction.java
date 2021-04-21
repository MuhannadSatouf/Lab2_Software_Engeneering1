package Models;

public class Transaction {
    private double amount;
    private Account account;

    public Transaction(Account account){
        this.account = account;
    }

    public boolean deposit(double amount){
        if (amount > 0) {
            this.amount = amount;
            account.setAccount_balance(account.getAccount_balance() + amount);
            return true;
        } else return false;
    }

    public boolean withdraw(){
        if(account.getAccount_balance() >= amount) {
            this.amount = -amount;
            account.setAccount_balance(account.getAccount_balance() - amount);
            return true;
        } else return false;
    }

    public double getAmount() {
        return amount;
    }

    public Account getAccount() {
        return account;
    }
}
