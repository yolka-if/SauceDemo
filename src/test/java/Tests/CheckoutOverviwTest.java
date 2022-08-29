package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutOverviwTest extends BaseTest {


    @Test
    public void buyProduct() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        assertTrue(productsPage.isOpend());
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCard();
        cartPage.goToCheckout();
        checkoutPage.fillCheckout("Test", "Test", "23454");
        cartPage.clickFinish();
        assertTrue(driver.findElement(By.id("checkout_complete_container")).isDisplayed(),
                "Нет сообщения об успешной покупке");
    }

    @Test
    public void checkInfoAboutTotalCost() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        assertTrue(productsPage.isOpend());
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCard();
        cartPage.goToCheckout();
        checkoutPage.fillCheckout("Test", "Test", "23454");
        assertEquals(checkoutOverviewPage.getItemTotal(), "Item total: $29.99");
        assertEquals(checkoutOverviewPage.getTax(), "Tax: $2.40");
        assertEquals(checkoutOverviewPage.getTotalCost(), "Total: $32.39");

    }
}


