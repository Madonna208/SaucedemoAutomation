package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase
{
    LoginPage loginObject;
    @DataProvider(name = "Login")
    public Object[][] Login() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
        };
    }

    @Test(dataProvider = "Login")
    public void loginSuccessfully(String username, String password)
    {
        loginObject = new LoginPage(driver);
        loginObject.UserLogin(username,password);
    }
}
