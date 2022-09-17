package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Locators extends BaseTest {

    @Test
    public void buyTest(){
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        driver.findElement(By.cssSelector("input[placeholder=Password]")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@value = 'Login']")).click();
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.tagName("span"));
        driver.findElement(By.linkText("Twitter"));
        driver.findElement(By.partialLinkText("Twi"));
    }
}
