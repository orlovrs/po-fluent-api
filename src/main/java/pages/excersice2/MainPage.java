package pages.excersice2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(how = How.CSS, using = "#title")
    WebElement title;

    @FindBy(how = How.XPATH, using = "//a[text() = 'Click']")
    WebElement clickLink;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickClickLink() {
        clickLink.click();
    }

    public boolean isTitleShown() {
        return title.isDisplayed();
    }
}