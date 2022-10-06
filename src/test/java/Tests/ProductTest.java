package Tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest {

    @Test
    public void checkProductInfo() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCard();
        assertEquals(cartPage.getCost("Sauce Labs Backpack"), "$29.99", "Цена не верная");
        assertEquals(cartPage.getTitle("Sauce Labs Backpack"), "Sauce Labs Backpack");
    }

}
