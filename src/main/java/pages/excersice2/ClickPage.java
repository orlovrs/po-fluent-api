package pages.excersice2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ClickPage {

    @FindBy(how = How.CSS, using = "h3")
    WebElement title;

    @FindBy(how = How.CSS, using = "#badButton")
    WebElement button;

    public ClickPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isTitleShown() {
        return title.isDisplayed();
    }

    public void clickButton() {
        button.click();
    }

    public String getButtonClass() {
        return button.getAttribute("class");
    }
}
