package Pages;

import org.openqa.selenium.By;
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
        String locator = String.format("//div[text() = '%s']//ancestor::div[@class='cart_item']//button[@id='remove-sauce-labs-bike-light']",
                productTitle);
        driver.findElement(By.xpath(locator)).click();
    }

    public void clickFinish() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public boolean isOpened() {
        return waitForVisibility(PAGE_TITLE);
    }

}
