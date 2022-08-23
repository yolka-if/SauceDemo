import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductTest extends BaseTest {

    @Test
    public void buyProduct() {
        driver.get(URL);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//div[text() = 'Sauce Labs Backpack']//ancestor::div[@class='inventory_item']//button")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        String cost = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Backpack']//ancestor::div[@class='cart_item']//div[@class='inventory_item_price']")).getText();
        assertEquals(cost, "$29.99");
        String title = driver.findElement(By.xpath("//div[text() = 'Sauce Labs Backpack']//ancestor::div[@class='cart_item']//div[@class='inventory_item_name']")).getText();
        assertEquals(title, "Sauce Labs Backpack");
    }
}
