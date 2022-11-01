package ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.excersice2.ClickPage;
import pages.excersice2.MainPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertsOldTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uitestingplayground.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void oldTest() {
        MainPage page = new MainPage(driver);
        assertTrue(page.isTitleShown());
        page.clickClickLink();
        ClickPage clickPage = new ClickPage(driver);
        assertTrue(clickPage.isTitleShown());
        clickPage.clickButton();
        assertTrue(clickPage.getButtonClass().contains("btn-success"));
    }
}
