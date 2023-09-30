package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.ShoppingPage;

public class CheckOutTest extends TestBase{
    ShoppingPage shoppingObject;
    CheckOutPage checkoutObject;
    @DataProvider(name = "Info")
    public Object[][] Info() {
        return new Object[][]{
                { "Madonna", "Emad","11757"},
        };
    }

    @Test(dataProvider = "Info")
    public void UserAddToCart(String first, String last, String zip)
    {
        shoppingObject = new ShoppingPage(driver);
        checkoutObject = new CheckOutPage(driver);
        shoppingObject.AddToCart();
        checkoutObject.ProcessToCheckOut();
        checkoutObject.FillYourInformation(first,last,zip);
        checkoutObject.confirmOrder();
        Assert.assertTrue(checkoutObject.successMessage.getText().contains("Thank you for your order!"));
    }
}
