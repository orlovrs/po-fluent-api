package pages.excersice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HiddenLayersPage {

    @FindBy(how = How.CSS, using = ".btn.btn-success")
    WebElement greenButton;
    @FindBy(how = How.CSS, using = ".btn.btn-primary")
    WebElement blueButton;

    public HiddenLayersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickGreenButton() {
        greenButton.click();
    }

    public boolean isBlueButtonShown() {
        return blueButton.isDisplayed();
    }
}
