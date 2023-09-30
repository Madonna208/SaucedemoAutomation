package tests;

import org.testng.annotations.Test;
import pages.LogoutPage;

public class LogoutTest extends TestBase{
    LogoutPage logOutObject;
    @Test
    public void UserLogOut()
    {
        logOutObject = new LogoutPage(driver);
        logOutObject.logOut();
    }
}
