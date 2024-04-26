package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class DeleteTariffPage {

    @FindBy(xpath = "//span[text()='Tariffs']")
    public WebElement tariffButton;

    @FindBy(xpath = "//td[text()='Hawaii']")
    public WebElement firstTariff;

    @FindBy(xpath = "(//button[@class='sc-jJoQJp ieRzNh MuiButtonBase-root sc-hiCibw kVxtLs MuiIconButton-root MuiIconButton-sizeMedium'])[1]")
    public WebElement editDeleteButton;

    @FindBy(xpath = "(//li[@class='sc-jJoQJp ieRzNh MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root sc-jOxtWs iooOuN sc-hcupDf kXRKGO'])[2]")
    public WebElement deleteButton;

    @FindBy(css = "button[class='sc-jJoQJp ieRzNh MuiButton-root MuiButton-contained MuiButton-containedError MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root sc-eGRUor hHAfIf sc-gIDmLj fpaoOd']")
    public WebElement confirmDeletingButton;

    // Method to get the locator of the success message element
    public By getSuccessMessageLocator() {
        return By.xpath("//div[contains(@class, 'notification-success') or contains(text(), 'Tariff removed successfully')]");
    }

    public WebElement getSuccessMessage() {
        return Driver.getDriver().findElement(getSuccessMessageLocator());
    }

    public DeleteTariffPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void deleteTariff() {
        tariffButton.click();
        firstTariff.click();
        editDeleteButton.click();
        deleteButton.click();
        confirmDeletingButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(getSuccessMessageLocator(), "Tariff removed successfully"));
        } catch (TimeoutException e) {
            throw new TimeoutException("Timeout waiting for success message: Tariff removed successfully");
        }
    }

    public boolean isTariffDeletionSuccessMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(getSuccessMessageLocator()));
            return successMessage.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}

