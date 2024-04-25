package pages.sup;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;
import java.util.Random;

public class TariffPage {
    public TariffPage() {PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Tariffs']")
    public WebElement tariffsButton;

    @FindBy(css = "button[class='sc-jJoQJp ieRzNh MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root sc-eGRUor dTmEKg sc-gIDmLj fpapDT sc-gDGHff fkfylB']")
    public WebElement createTariffButton;

    @FindBy(id = "mui-component-select-branchId")
    public WebElement clickBranch;

    @FindBy(css = "li[data-value='4']")
    public WebElement chooseBranch;

    @FindBy(id = "mui-2")
    public WebElement tariffName;

    @FindBy(id = "mui-3")
    public WebElement deliveryTime;

    @FindBy(id = "mui-component-select-type")
    public WebElement clickTypeOfDelivery;

    @FindBy(css = "li[data-value='CITY_EXPRESS']")
    public WebElement typeOfDelivery;

    @FindBy(id = "mui-4")
    public WebElement deliveryCost;

    @FindBy(id = "mui-component-select-regionId")
    public WebElement clickSelectRegion;

    @FindBy(css = "li[data-value='11']")
    public WebElement selectRegion;

    @FindBy(css = "input[value='true']")
    public WebElement availabilityOfCard;

    @FindBy(id = "mui-5")
    public WebElement geographicCoordinates;

    @FindBy(id = "mui-6")
    public WebElement additionalInfo;

    @FindBy(css = "button[type='submit']")
    public WebElement createButton;

    @FindBy (xpath = "(//button[@class='sc-jJoQJp ieRzNh MuiButtonBase-root sc-hiCibw bIExuc MuiIconButton-root MuiIconButton-sizeSmall'])[1]")
    public WebElement tariffList;

    @FindBy (xpath = "(//div[@class='sc-aaqME kuwDhH'])[1]")
    public WebElement nameOfTariff;

    @FindBy (xpath = "(//button[@class='sc-jJoQJp ieRzNh MuiButtonBase-root sc-hiCibw kVxtLs MuiIconButton-root MuiIconButton-sizeMedium'])[1]")
    public WebElement editDeleteButton;

    @FindBy (xpath = "(//li[@class='sc-jJoQJp ieRzNh MuiMenuItem-root MuiMenuItem-gutters MuiButtonBase-root sc-jOxtWs iooOuN sc-hcupDf kXRKGO'])[2]")
    public WebElement deleteButton;

    @FindBy(css = "button[class='sc-jJoQJp ieRzNh MuiButton-root MuiButton-contained MuiButton-containedError MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root sc-eGRUor hHAfIf sc-gIDmLj fpaoOd']")
    public WebElement confirmDeleting;





}