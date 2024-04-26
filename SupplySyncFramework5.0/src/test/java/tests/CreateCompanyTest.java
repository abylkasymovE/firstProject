package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateCompanyPage;
import pages.SupplySyncLoginPage;
import utilities.Config;
import utilities.Driver;

import java.time.Duration;

public class CreateCompanyTest {

    public WebDriver driver;
    public SupplySyncLoginPage supplySyncLoginPage;
    private CreateCompanyPage supplySyncCreateCompanyPage;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(Config.getProperty("supplySync"));
        supplySyncLoginPage = new SupplySyncLoginPage();
        // Login before the test
        supplySyncLoginPage.login("admin@codewise.com", "codewise123"); // Login before each test
        supplySyncCreateCompanyPage = new CreateCompanyPage();
    }

    @AfterSuite
    public void tearDown() {
        // Close browser session
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void testCreateCompany() {
        supplySyncCreateCompanyPage.createCompany("Test Company", "test@example.com", "1234 Test St, Testing", "5555555555");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(supplySyncCreateCompanyPage.getSuccessMessage()));

        // Extract the text of the success message
        String actualSuccessMessage = supplySyncCreateCompanyPage.getSuccessMessage().getText();

        // Compare the actual success message text with the expected text
        Assert.assertEquals(actualSuccessMessage, "Company successfully established", "Success message does not match expected");
    }


}
