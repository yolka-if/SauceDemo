package tests;

import pages.ProductsListPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        ProductsListPage productsPage = new ProductsListPage(driver);
        assertTrue(productsPage.isOpend());

    }
    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauc","Epic sadface: Username and password do not match any user in this service"},
                {"standard_usr", "secret_sauce","Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce","Epic sadface: Username is required"}
        };
    }


    @Test(dataProvider = "loginData")
    public void negativLogin(String userName, String password, String error) {
        loginPage.open();
        loginPage.login(userName, password);
        Assert.assertEquals(loginPage.getError(),
                error);

    }




}
