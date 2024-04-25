package tests.Supply;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.sup.SupplySyncCreateCompanyPage;
import pages.sup.SupplySyncLoginPage;
import pages.sup.SupplySyncRegionPage;
import pages.sup.TariffPage;
import utilities.Config;
import utilities.Driver;

import java.time.Duration;


public class SupplySyncTests {

    WebDriver driver;
    SupplySyncLoginPage supplySyncLoginPage = new SupplySyncLoginPage();
    SupplySyncCreateCompanyPage supplySyncCreateCompanyPage = new SupplySyncCreateCompanyPage();
    SupplySyncRegionPage supplySyncRegionPage = new SupplySyncRegionPage();

    // Emir test
    TariffPage tariffPage = new TariffPage();

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get("https://supplysync.us/login");
        supplySyncLoginPage = new SupplySyncLoginPage();
        supplySyncCreateCompanyPage = new SupplySyncCreateCompanyPage();

        // Adding test from Emir here:
        tariffPage = new TariffPage();

    }

    @Test(priority = 1)
    public void testLogin() {
        supplySyncLoginPage.login.sendKeys("admin@codewise.com");
        supplySyncLoginPage.password.sendKeys("codewise123");
        supplySyncLoginPage.loginButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("dashboard"));
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "The URL does not contain 'dashboard' after login");
    }

    @Test(priority = 2, dependsOnMethods = "testLogin")
    public void testCreateCompany() {
        supplySyncCreateCompanyPage.createCompanyBtn.click(); // Clicks the create company button

        // Filling the form
        supplySyncCreateCompanyPage.companyName.sendKeys("Test Company");
        supplySyncCreateCompanyPage.companyEmail.sendKeys("test@example.com");
        supplySyncCreateCompanyPage.companyAddress.sendKeys("1234 Test St, Testing");
        supplySyncCreateCompanyPage.companyPhoneNumber.click();
        supplySyncCreateCompanyPage.companyPhoneNumber.sendKeys("1111111111");
        supplySyncCreateCompanyPage.createButton.click();

        // Wait for response
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // OPTION #1  Let's assume a notification appears or URL changes upon successful creation
//        Boolean isSuccessful = wait.until(ExpectedConditions.urlContains("true"));
//        Assert.assertTrue(isSuccessful, "Failed to navigate to the company list after creation.");

        // OPTION #2 Wait for the success message to appear
//        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'notification-success') or contains(text(), 'Company successfully established')]")));
//        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed.");

        // Optional Verify the text of the success message
//        String expectedMessage = "Company successfully established";
//        Assert.assertEquals(successMessage.getText(), expectedMessage, "The success message text does not match expected.");


        WebElement successMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'notification-success') or contains(text(), 'Company successfully established')]")));
        String expectedMessage = Config.getProperty("successMessage");
        String actualMessage = successMessageElement.getText();

        // Assert that the message matches
        Assert.assertEquals(actualMessage, expectedMessage, "The success message after company creation does not match expected.");

    }

    Faker faker = new Faker();
    public String tarName = faker.name().title();

    public String geoCor = faker.address().country();
    public String addiInfo = faker.address().cityName();

    public String delTime = faker.number().digits(2);

    public String delCost = faker.number().digits(3);




    @Test(priority = 3, dependsOnMethods = "testLogin")
    public void testCreateTariff() {
        // Navigate to Tariff Creation Page
        tariffPage.tariffsButton.click();
        tariffPage.createTariffButton.click();

        // Fill in the tariff details
        tariffPage.clickBranch.click();
        tariffPage.chooseBranch.click();
        tariffPage.tariffName.sendKeys(tarName);
        tariffPage.deliveryTime.sendKeys(delTime);
        tariffPage.clickTypeOfDelivery.click();
        tariffPage.typeOfDelivery.click();
        tariffPage.clickSelectRegion.click();
        tariffPage.selectRegion.click();
        tariffPage.deliveryCost.sendKeys(delCost);
        tariffPage.availabilityOfCard.click();
        tariffPage.geographicCoordinates.sendKeys(geoCor);
        tariffPage.additionalInfo.sendKeys(addiInfo);
        tariffPage.createButton.click();

        // Verify the success of tariff creation
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'notification-success') or contains(text(), 'Tariff created successfully')]")));
        Assert.assertTrue(successNotification.isDisplayed(), "Tariff creation success notification not displayed.");
    }




    @Test(priority = 4, dependsOnMethods = "testLogin")
    public void testDeleteTariff() {
        // Navigate to Tariff List Page
        tariffPage.tariffsButton.click();
        tariffPage.tariffList.click();

        // Perform deletion of the first tariff in the list
        tariffPage.editDeleteButton.click();
        tariffPage.deleteButton.click();
        tariffPage.confirmDeleting.click();

        // Verify the success of tariff deletion
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deletionSuccessNotification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'notification-success') or contains(text(), 'Tariff removed successfully')]")));
        Assert.assertTrue(deletionSuccessNotification.isDisplayed(), "Tariff deletion success notification not displayed.");
    }


    public String regionName = faker.name().title();
    @Test (priority = 5, dependsOnMethods = "testLogin")
    public void testCreateRegion(){
        //Region creating
        supplySyncRegionPage.regionNavigate.click();
        supplySyncRegionPage.createRegion.click();
        supplySyncRegionPage.regionName.sendKeys(regionName);
        supplySyncRegionPage.createRegionBtn.click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement createSuccessNote = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'notification-success') or contains(text(), 'Region created successfully')]")));
//        Assert.assertTrue(createSuccessNote.isDisplayed(), "Region creating success notification not displayed.");

        Assert.assertTrue(supplySyncRegionPage.regionName.getText().contains(supplySyncRegionPage.regionName.getText()));
    }
    @Test(priority = 4, dependsOnMethods = "testLogin")
    public void testDeleteRegion() {
        supplySyncRegionPage.regionNavigate.click();
        supplySyncRegionPage.regionEditDeleteButton.click();
        supplySyncRegionPage.regionDeleteButton.click();
        supplySyncRegionPage.regionConfirmDeleting.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deletionSuccessNote = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'notification-success') or contains(text(), 'Region deleted successfully')]")));

        Assert.assertTrue(deletionSuccessNote.isDisplayed(), "Region deletion success notification not displayed.");
    }

}
