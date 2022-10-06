package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsListPage extends BasePage {


    private final By PAGE_TITLE = By.cssSelector(".title");

    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    public boolean isOpend() {
        return waitForVisibility(PAGE_TITLE);

    }

    public void addToCart(String product) {
        String locator = String.format("//div[text() = '%s']//ancestor::div[@class='inventory_item']//button",
                product);
        driver.findElement(By.xpath(locator)).click();
    }


}
