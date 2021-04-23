package Models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account account = new Account(33333, 0);

    @Test
    public void setAccount_balance() {
        account.setAccount_balance(1000);
        Assert.assertEquals(1000, account.getAccount_balance(), 0);

    }

    @Test
    public void getAccount_balance() {
        account.setAccount_balance(2000);
        Assert.assertEquals(2000, account.getAccount_balance(), 0);
    }

    @Test
    public void getAccount_number() {
        account.setAccount_number(7777);
        Assert.assertEquals(7777, account.getAccount_number());
    }

    @Test
    public void setAccount_number() {
        account.setAccount_number(7777);
        Assert.assertEquals(7777, account.getAccount_number());
    }
}