package Models;

public class Transaction {
    private double amount;
    private final Account account;

    public Transaction(Account account){
        this.account = account;
    }

    public void deposit(double amount){
        if (amount > 0) {
            this.amount = amount;
            account.setAccount_balance(account.getAccount_balance() + amount);
        }
    }

    public boolean withdraw(double amount){
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
