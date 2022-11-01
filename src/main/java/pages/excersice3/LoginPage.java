package pages.excersice3;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "user-name")
    WebElement loginInput;

    @FindBy(how = How.ID, using = "password")
    WebElement passwordInput;

    @FindBy(how = How.ID, using = "login-button")
    WebElement loginButton;

    @FindBy(how = How.CSS, using = ".error-message-container.error h3")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage loginWithCredentials(String username, String password) {
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new MainPage(driver);
    }

    public LoginPage checkErrorMessagesPresent() {
        assertTrue(errorMessage.isDisplayed());
        return this;
    }
}