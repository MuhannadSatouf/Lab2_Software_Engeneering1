package Models;

public class User {
    private String person_number;
    private String name;
    private String password;
    private int account_number;

    public User(String person_number, String name, int account_number){
        setPerson_number(person_number);
        setName(name);
        setAccount_number(account_number);

    }

    public String getPerson_number() {
        return person_number;
    }

    public void setPerson_number(String person_number) {
        this.person_number = person_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

}
