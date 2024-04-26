package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateTariffPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[text()='Tariffs']")
    public WebElement tariffsButton;

    @FindBy(css = "button[class='sc-jJoQJp ieRzNh MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root sc-eGRUor dTmEKg sc-gIDmLj fpapDT sc-gDGHff fkfylB']")
    public WebElement createTariffButton;

    @FindBy(id = "mui-component-select-branchId")
    public WebElement clickBranch;

    @FindBy(css = "li[data-value='4']")
    public WebElement chooseBranch;

    @FindBy(id = "mui-2")
    public WebElement tariffNameInput;

    @FindBy(id = "mui-3")
    public WebElement deliveryTimeInput;

    @FindBy(id = "mui-component-select-type")
    public WebElement clickTypeOfDelivery;

    @FindBy(css = "li[data-value='CITY_EXPRESS']")
    public WebElement typeOfDeliveryOption;

    @FindBy(id = "mui-4")
    public WebElement deliveryCostInput;

    @FindBy(id = "mui-component-select-regionId")
    public WebElement clickSelectRegion;

    @FindBy(css = "li[data-value='11']")
    public WebElement selectRegionOption;

    @FindBy(css = "input[value='true']")
    public WebElement availabilityOfCardCheckbox;

    @FindBy(id = "mui-5")
    public WebElement geographicCoordinatesInput;

    @FindBy(id = "mui-6")
    public WebElement additionalInfoInput;

    @FindBy(css = "button[type='submit']")
    public WebElement createButton;

    @FindBy(xpath = "//div[contains(@class, 'notification-success') or contains(text(), 'Tariff created successfully')]")
    public WebElement successMessage;

    public CreateTariffPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public String getSuccessMessageText() {
        return successMessage.getText();
    }

    public void createTariff(String name, String deliveryTime, String deliveryCost, String geoCoordinates, String additionalInfo) {
        tariffsButton.click();
        createTariffButton.click();
        fillTariffDetails(name, deliveryTime, deliveryCost, geoCoordinates, additionalInfo);
        submitTariffForm();
    }

    public void fillTariffDetails(String name, String deliveryTime, String deliveryCost, String geoCoordinates, String additionalInfo) {
        clickBranch.click();
        chooseBranch.click();
        tariffNameInput.sendKeys(name);
        deliveryTimeInput.sendKeys(deliveryTime);
        clickTypeOfDelivery.click();
        typeOfDeliveryOption.click();
        deliveryCostInput.sendKeys(deliveryCost);
        clickSelectRegion.click();
        selectRegionOption.click();
        availabilityOfCardCheckbox.click();
        geographicCoordinatesInput.sendKeys(geoCoordinates);
        additionalInfoInput.sendKeys(additionalInfo);
    }

    public void submitTariffForm() {
        createButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[contains(@class, 'notification-success') or contains(text(), 'Tariff created successfully')]"), "Tariff created successfully"));
    }
}
