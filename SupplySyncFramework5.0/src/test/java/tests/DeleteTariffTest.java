package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DeleteTariffPage;
import pages.SupplySyncLoginPage;
import utilities.Config;
import utilities.Driver;

public class DeleteTariffTest {

    public WebDriver driver;
    public DeleteTariffPage deleteTariffPage;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(Config.getProperty("supplySync"));

        // Assuming login is done elsewhere
        deleteTariffPage = new DeleteTariffPage();

        // Login before the test
        SupplySyncLoginPage supplySyncLoginPage = new SupplySyncLoginPage();
        supplySyncLoginPage.login("admin@codewise.com", "codewise123");
    }

    @AfterSuite
    public void tearDown() {
        // Close browser session
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void testDeleteTariff() {
        deleteTariffPage.deleteTariff();


        // Check if the success message is displayed
        Assert.assertTrue(deleteTariffPage.isTariffDeletionSuccessMessageDisplayed(), "Tariff deletion success message not displayed");
    }


}

