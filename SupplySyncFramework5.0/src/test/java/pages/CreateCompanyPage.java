package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class CreateCompanyPage {

    @FindBy(xpath = "//div[@class='sc-iidyiZ bFJLTQ']/button")
    public WebElement createCompanyBtn;

    @FindBy(name = "name")
    public WebElement companyNameInput;

    @FindBy(name = "email")
    public WebElement companyEmailInput;

    @FindBy(name = "address")
    public WebElement companyAddressInput;


    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement companyPhoneNumberInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement createButton;

    @FindBy(xpath = "//div[contains(@class, 'notification-success') or contains(text(), 'Company successfully established')]")
    public WebElement successMessage;

    public CreateCompanyPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Method to get the success message element
    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public void createCompany(String name, String email, String address, String phoneNumber) {
        createCompanyBtn.click();
        fillCompanyDetails(name, email, address, phoneNumber);
        submitCompanyForm();
    }

    public void fillCompanyDetails(String name, String email, String address, String phoneNumber) {
        companyNameInput.sendKeys(name);
        companyEmailInput.sendKeys(email);
        companyAddressInput.sendKeys(address);
        companyPhoneNumberInput.click();
        companyPhoneNumberInput.sendKeys(phoneNumber);
    }

    public void submitCompanyForm() {
        createButton.click();
        // Wait for response after form submission
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getSuccessMessage()));
    }

}
