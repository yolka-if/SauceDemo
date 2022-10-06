package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By USERNAME_IMPUT = By.id("user-name");
    private By PASSWORD_IMPUT = By.id("password");
    private By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String username, String password) {
        driver.findElement(USERNAME_IMPUT).sendKeys(username);
        driver.findElement(PASSWORD_IMPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
