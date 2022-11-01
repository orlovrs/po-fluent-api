package ex3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.excersice2.ClickPage;
import pages.excersice2.MainPage;
import pages.excersice3.LoginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RedirectionOldTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void successfulTestOld() {
        new LoginPage(driver)
                .loginWithCredentials("standard_user", "secret_sauce")
                .isOnThePage();
    }

    @Test
    void negativeTestOld() {
        new LoginPage(driver)
                .loginWithCredentials("standard_user2", "secret_sauce");

        new LoginPage(driver)
                .checkErrorMessagesPresent();
    }
}
