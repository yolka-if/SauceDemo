package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    static By CHECKOUT_BUTTON = By.id("checkout");
    static By FINISH_BUTTON = By.id("finish");
    private final By PAGE_TITLE = By.cssSelector(".title");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCost(String product) {
        String locator = String.format("//div[text() = '%s']//ancestor::div[@class='cart_item']//div[@class='inventory_item_price']",
                product);
        return driver.findElement(By.xpath(locator)).getText();
    }

    public String getTitle(String productTitle) {
        String locator = String.format("//div[text() = '%s']//ancestor::div[@class='cart_item']//div[@class='inventory_item_name']",
                productTitle);
        return driver.findElement(By.xpath(locator)).getText();
    }

    public void goToCheckout() {

        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void clickRemove(String productTitle) {
        String locator = String.format("//div[text() = 'Sauce Labs Backpack']//ancestor::div[@class='cart_item']//button[@class='btn btn_secondary btn_small cart_button']",
                productTitle);
        driver.findElement(By.xpath(locator)).click();
    }

    public void clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public boolean isOpened() {
        return waitForVisibility(PAGE_TITLE);
    }

    public boolean isProductCardExists(String producrName){
        try {return driver.findElement(By.xpath(String.format("//div[text() = '%s']//ancestor::div[@class='cart_item']//div[@class='inventory_item_name']",producrName))).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }

    }

}
