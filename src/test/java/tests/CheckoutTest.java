package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {


    @Test
    public void successfulCheckout() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCard();
        cartPage.goToCheckout();
        checkoutPage.fillCheckout("Test", "Test", "23454");
        assertTrue(driver.findElement(By.cssSelector(".summary_info")).isDisplayed());

    }

    @Test
    public void checkoutWithoutFirstName() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCard();
        cartPage.goToCheckout();
        checkoutPage.fillCheckout("", "Test", "23454");
        assertEquals(checkoutPage.getError(), "Error: First Name is required");
    }

    @Test
    public void checkoutWithoutLastName() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCard();
        cartPage.goToCheckout();
        checkoutPage.fillCheckout("Test", "", "23454");
        assertEquals(checkoutPage.getError(), "Error: Last Name is required");
    }

    @Test
    public void checkoutWithoutPostalcode() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCard();
        cartPage.goToCheckout();
        checkoutPage.fillCheckout("Test", "Test", "");
        assertEquals(checkoutPage.getError(), "Error: Postal Code is required");
    }

    @Test
    public void cancelCheckout() {
        loginPage.open();
        loginPage.login("performance_glitch_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCard();
        cartPage.goToCheckout();
        checkoutPage.clickCancel();
        try {
            assertTrue(driver.findElement(By.cssSelector(".summary_info")).isDisplayed());
        } catch (NoSuchElementException e) {
            System.out.println("Блок с итоговой информацией по доставке и стоимости не отображается");
        }
        assertEquals(cartPage.getCost("Sauce Labs Backpack"), "$29.99", "Цена не верная");
    }
}
