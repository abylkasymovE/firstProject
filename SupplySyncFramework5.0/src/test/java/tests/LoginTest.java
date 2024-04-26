package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SupplySyncLoginPage;
import utilities.Config;
import utilities.Driver;

import java.time.Duration;

public class LoginTest {

    public WebDriver driver;
    public SupplySyncLoginPage supplySyncLoginPage;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(Config.getProperty("supplySync"));
        supplySyncLoginPage = new SupplySyncLoginPage();
        supplySyncLoginPage.login("admin@codewise.com", "codewise123"); // Login before each test
    }

    @AfterSuite
    public void tearDown() {
        // Close browser session
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void testLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Failed to navigate to dashboard after login");
    }


}
