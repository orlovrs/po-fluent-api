package pages.excersice4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionPage {

    protected WebDriver driver;

    @FindBy(how = How.CSS, using = "input[type='submit']")
    WebElement submitButton;

    @FindBy(how = How.ID, using = "option")
    WebElement optionInput;

    public OptionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public OptionPage setOption(String option) {
        optionInput.sendKeys(option);
        submitButton.click();
        return this;
    }

    public OptionPage checkOptionIsSet(String option) {
        assertEquals(option, driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        return this;
    }
}