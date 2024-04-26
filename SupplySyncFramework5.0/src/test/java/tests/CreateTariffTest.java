package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateTariffPage;
import pages.SupplySyncLoginPage;
import utilities.Config;
import utilities.Driver;

public class CreateTariffTest {

    public WebDriver driver;
    public CreateTariffPage createTariffPage;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(Config.getProperty("supplySync"));
        SupplySyncLoginPage supplySyncLoginPage = new SupplySyncLoginPage();
        // Login before the test
        supplySyncLoginPage.login("admin@codewise.com", "codewise123");
        createTariffPage = new CreateTariffPage(driver);
    }

    @AfterSuite
    public void tearDown() {
        // Close browser session
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void testCreateTariff() {
        createTariffPage.createTariff("Tariff Name", "5", "100", "Geo Coordinates", "Additional Info");



        // Extract the text of the success message directly from the page object
        String actualSuccessMessage = createTariffPage.getSuccessMessageText();

        // Perform assertion
        Assert.assertTrue(actualSuccessMessage.contains("Tariff created successfully"), "Tariff creation success message not displayed");
    }


}
