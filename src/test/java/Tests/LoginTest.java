package Tests;

import Pages.ProductsListPage;
import org.testng.Assert;
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

    @Test
    public void loginWithWrongUsername() {
        loginPage.open();
        loginPage.login("standard_usr", "secret_sauce");
        Assert.assertEquals(loginPage.getError(),
                "Epic sadface: Username and password do not match any user in this service");

    }

    @Test
    public void loginWithWrongPassword() {
        loginPage.open();
        loginPage.login("standard_usr", "secret_sauce");
        Assert.assertEquals(loginPage.getError(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithEmptyUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getError(),
                "Epic sadface: Username is required");
    }


}
