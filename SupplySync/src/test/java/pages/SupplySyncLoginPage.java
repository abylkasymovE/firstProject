package pages.sup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SupplySyncLoginPage {
    public SupplySyncLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "email")
    public WebElement login;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(css = "button[type=submit]")
    public WebElement loginButton;

}
