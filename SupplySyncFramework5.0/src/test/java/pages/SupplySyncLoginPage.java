package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class SupplySyncLoginPage {

    @FindBy(name = "email")
    public WebElement login;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(css = "button[type=submit]")
    public WebElement loginButton;

    public SupplySyncLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String email, String pass) {
        login.sendKeys(email);
        password.sendKeys(pass);
        loginButton.click();
        // Wait for navigation after login
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));
    }
}
