package Pages.ClientPortal;


import ConfigurationHelper.Utilites.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author "Sivaraman M"
 */
public class AccountsPage {
    WebDriver driver;
    WaitUtils waitUtils;
    public AccountsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }
    @FindBy (xpath = "//button[normalize-space()='fees']")
    WebElement feesButton;
    @FindBy(xpath = "//button[normalize-space()='limit']")
    WebElement limitButton;
    @FindBy(xpath = "//button[normalize-space()='team balance']")
    WebElement teamBalanceButton;
    @FindBy(xpath = "//button[normalize-space()='transporter payments']")
    WebElement transporterPaymentsButton;
    @FindBy(xpath = "//button[@type='button'][normalize-space()='request prefund']")
    WebElement requestPrefundButton;


    //Prefund request form
    @FindBy(xpath = "//input[@id='amount']")
    WebElement requestPrefundAmountInput;
    @FindBy(xpath = "//input[@id='requestBankRefNo']")
    WebElement requestPrefundBankRefNoInput;
    @FindBy(xpath = "//input[@id='requestinternalRefNo']")
    WebElement requestPrefundInternalRefNoInput;
    @FindBy(xpath = "//textarea[@id='comments']")
    WebElement requestPrefundCommentsInput;
    @FindBy(xpath = "//input[@name='file']")
    WebElement requestPrefundFileUploadInput;
    @FindBy(xpath = "//button[@class='btn btn-primary text-capitalize']")
    WebElement requestPrefundSubmitButton;

    //Action Button - without sorting
    @FindBy(xpath = "//div[@class='dropdown']/button[@type='button']")
    WebElement actionButton;

}
