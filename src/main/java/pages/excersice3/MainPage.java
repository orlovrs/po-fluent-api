package pages.excersice3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPage {

    private WebDriver driver;

    @FindBy(how = How.CSS, using = ".app_logo")
    WebElement appLogo;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage isOnThePage() {
        assertTrue(appLogo.isDisplayed());
        return this;
    }
}
