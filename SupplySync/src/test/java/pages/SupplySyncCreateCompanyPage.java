package pages.sup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SupplySyncCreateCompanyPage {

    public SupplySyncCreateCompanyPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='sc-iidyiZ bFJLTQ']/button")
    public WebElement createCompanyBtn;

    public void createCompany(){
        createCompanyBtn.click();
    }

    @FindBy(name = "name")
    public WebElement companyName;

    @FindBy(name = "email")
    public WebElement companyEmail;

    @FindBy(name = "address")
    public WebElement companyAddress;

    @FindBy(name = "phoneNumber")
    public WebElement companyPhoneNumber;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement createButton;


}
