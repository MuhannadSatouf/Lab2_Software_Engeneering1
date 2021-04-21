package Models;

public class DBMethods {
    DAO dao = new DAO();

    public User getUser(String person_number) {
       return dao.getUser(person_number);
    }

    public void updateAccountBalance(Account account){
        dao.updateBalance(account);
    }

    public Account getAccount(){
        return dao.getAccount();
    }


}
