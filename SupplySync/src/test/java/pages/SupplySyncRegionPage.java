package pages.sup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SupplySyncRegionPage {
    public SupplySyncRegionPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//span[text()='Regions']")
    public WebElement regionNavigate;

    @FindBy (xpath = "//button[@class='sc-jJoQJp ieRzNh MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root sc-eGRUor dTmEKg sc-gIDmLj fpapDT sc-gLDmcm cdpqXd']")
    public WebElement createRegion;

    @FindBy(name = "name")
    public WebElement regionName;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement createRegionBtn;

    @FindBy (xpath = "(//button[@class='sc-jJoQJp ieRzNh MuiButtonBase-root sc-hiCibw kVxtLs MuiIconButton-root MuiIconButton-sizeMedium'])[54]")
    public WebElement regionEditDeleteButton;

    @FindBy (xpath = "(//li[text()='Delete'])[54]")
    public WebElement regionDeleteButton;

    @FindBy(css = "button[class='sc-jJoQJp ieRzNh MuiButton-root MuiButton-contained MuiButton-containedError MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root sc-eGRUor hHAfIf sc-gIDmLj fpaoOd']")
    public WebElement regionConfirmDeleting;
}

