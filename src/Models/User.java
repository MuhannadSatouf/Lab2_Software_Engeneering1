package Models;

public class User {
    private String name;
    private int id;
    private long phoneNumber;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public long getPhoneNumber() {
        return phoneNumber;
    }


    public String getPassword() {
        return password;
    }

}
