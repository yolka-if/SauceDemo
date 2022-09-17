package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void buyProductWithRemove() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.addToCart("Sauce Labs Bike Light");
        productsPage.clickCard();
        cartPage.clickRemove("Sauce Labs Backpack");
        cartPage.goToCheckout();
        checkoutPage.fillCheckout("Test", "Test", "23454");
    if (!cartPage.isProductCardExists("Sauce Labs Backpack")){
        System.out.println("Товар был удалён");
        } else  {
        assertTrue(false, "Tовар не был удалён");
        }
    }


}
