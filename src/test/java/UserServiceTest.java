import org.junit.Test;
import org.junit.Assert;
public class UserServiceTest {
    UserDb MockUser = new UserDb("admin", "123456");

    @Test
    public void testIfUserExistAndPasswordCorrect() {
        UserService connection = new UserService(MockUser);
        boolean result = connection.changePassword("admin", "Password12345!");
        Assert.assertTrue(result);
    }

    @Test
    public void testIfUserExistAndPasswordWeak() {
        UserService connection = new UserService(MockUser);
        boolean result = connection.changePassword("admin", "Weak");
        Assert.assertFalse(result);
    }

    @Test
    public void testIfUserNotExistAndPasswordCorrect() {
        UserService connection = new UserService(MockUser);
        boolean result = connection.changePassword("serviceAccount", "Password12345!");
        Assert.assertFalse(result);
    }
}
