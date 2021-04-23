package Models;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserSingletonTest {
    UserSingleton userSingleton = UserSingleton.getInstance();
    User user = new User();

    @Test
    public void getUser() {
        userSingleton.setUser(user);
        Assert.assertSame(user, userSingleton.getUser());
    }

    @Test
    public void setUser() {
        userSingleton.setUser(user);
        Assert.assertSame(user, userSingleton.getUser());
    }
}