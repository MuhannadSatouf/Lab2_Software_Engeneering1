package Models;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    String pers_num = "333333";
    String name = "Ivan Åkesson";
    int acc_num = 32015782;

    User testUser = new User(pers_num, name, acc_num);

    @Test
    public void getPerson_number() {
        Assert.assertEquals(pers_num, testUser.getPerson_number());
    }

    @Test
    public void setPerson_number() {
        String pn = "00000";
        testUser.setPerson_number(pn);
        Assert.assertEquals(pn, testUser.getPerson_number());
    }

    @Test
    public void getName() {
        Assert.assertEquals(name, testUser.getName());
    }

    @Test
    public void setName() {
        String nm = "name";
        testUser.setName(nm);
        Assert.assertEquals(nm, testUser.getName());
    }

    @Test
    public void getPassword() {
        String pass = "secret";
        testUser.setPassword(pass);
        Assert.assertEquals(pass, testUser.getPassword());
    }

    @Test
    public void getAccount_number() {
        Assert.assertEquals(acc_num, testUser.getAccount_number());
    }

    @Test
    public void setAccount_number() {
        int acc = 22222;
        testUser.setAccount_number(acc);
        Assert.assertEquals(acc, testUser.getAccount_number());
    }
}