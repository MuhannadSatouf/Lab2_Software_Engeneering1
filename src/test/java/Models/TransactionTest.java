package Models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionTest {

    @Test
    public void deposit() {
        Account acc1 = new Account(1111, 500);
        Transaction t1 = new Transaction(acc1);
        t1.deposit(100);
        Assert.assertEquals(600, t1.getAccount().getAccount_balance(), 0);
    }

    @Test
    public void withdraw() {
        Account acc1 = new Account(1111, 500);
        Transaction t1 = new Transaction(acc1);
        t1.withdraw(200);
        Assert.assertEquals(300, t1.getAccount().getAccount_balance(), 0);
    }
}