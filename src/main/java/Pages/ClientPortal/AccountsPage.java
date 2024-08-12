package Pages.ClientPortal;


import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import ConfigurationHelper.Utilites.TestUtilities;
import ConfigurationHelper.Utilites.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * @author "Sivaraman M"
 */
public class AccountsPage extends BaseBrowserConfiguration {
    private static final Logger log = LogManager.getLogger(DashboardPage.class);
    WebDriver driver;
    WaitUtils waitUtils;
    TestUtilities testUtilities;

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.waitUtils = new WaitUtils(driver);
        this.testUtilities = new TestUtilities(driver);
    }

    @FindBy(xpath = "//button[normalize-space()='fees']")
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

    public void clickRequestPrefundButton() {
        try {
            waitUtils.waitUntilElementClickable(requestPrefundButton);
            requestPrefundButton.click();
            log.info("Clicked request prefund button");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void fillRequestPrefundAmountInput() {
        try {
            waitUtils.waitUntilElementVisible(requestPrefundAmountInput);
            log.info("request prefund amount input" + requestPrefundAmountInput);
            testUtilities.getRequestPrefundAmount(requestPrefundAmountInput);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void fillRequestPrefundBankRefNoInput() {
        try {
        log.info("request prefund bank ref no "+requestPrefundBankRefNoInput);
        String bankRefNo = testUtilities.getBankReferenceNumber(requestPrefundBankRefNoInput);
        requestPrefundBankRefNoInput.sendKeys(bankRefNo);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void fillRequestPrefundInternalRefNoInput() {
        try {
        log.info("request prefund internal refno "+requestPrefundInternalRefNoInput);
        String intRefNo=testUtilities.getInternalReferenceNumber(requestPrefundInternalRefNoInput);
        requestPrefundInternalRefNoInput.sendKeys(intRefNo);}
        catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void fillRequestPrefundCommentsInput() {
        try {
        log.info("request prefund comments "+requestPrefundCommentsInput);
       String commentsInput =  testUtilities.getComments(requestPrefundCommentsInput);
       requestPrefundCommentsInput.sendKeys(commentsInput);}
        catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public void fillRequestPrefundFileUploadInput() {
        testUtilities.uploadFile(requestPrefundFileUploadInput);
    }

    public void fillRequestPrefundSubmitButton() {
        requestPrefundSubmitButton.click();
        waitUtils.waitUntilElementInVisible(requestPrefundButton);
    }
}
