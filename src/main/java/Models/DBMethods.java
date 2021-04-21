package Models;

public class DBMethods {
    DAO dao = new DAO();

    public User getUser(String person_number) {
       return dao.getUser(person_number);
    }

   // public void updateAccountBalance(Account account){
  //      dao.updateBalance(account);
  //  }   this is executed in  setTransaction()

    public Account getAccountBalance(int accountNumber){
        return dao.getAccount(accountNumber);
    }

    public void addTransaction(Transaction transaction){
        dao.setTransaction(transaction);
    }
}
