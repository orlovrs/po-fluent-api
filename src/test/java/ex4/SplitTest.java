package ex4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.excersice4.OptionPage;

import java.util.concurrent.TimeUnit;

public class SplitTest {
    WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void selectOption1Test() {
        driver.get(String.format("file:///%s/app/options.html?ab=1", System.getProperty("user.dir")));

        String optionName = "option 2";
        new OptionPage(driver)
                .setOption(optionName)
                .checkOptionIsSet(optionName);
    }

    @Test
    void selectOption2Test() {
        driver.get(String.format("file:///%s/app/options.html?ab=2", System.getProperty("user.dir")));

        String optionName = "option 2";
        new OptionPage(driver)
                .setOption(optionName)
                .checkOptionIsSet(optionName);
    }
}
