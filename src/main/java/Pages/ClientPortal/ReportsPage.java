package Pages.ClientPortal;


import ConfigurationHelper.Utilites.TestUtilities;
import ConfigurationHelper.Utilites.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author "Sivaraman M"
 */
public class ReportsPage {
    WebDriver driver;
    WaitUtils waitUtils;
    TestUtilities testUtilities;
    private static final Logger log = LogManager.getLogger(ReportsPage.class);

    public ReportsPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        testUtilities = new TestUtilities(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//li[normalize-space()='account payouts'])[1]")
    WebElement accountPayoutReportsPage;
    @FindBy(xpath = "(//li[normalize-space()='prefund'])[1]")
    WebElement prefundReportsPage;
    @FindBy(xpath = "(//li[normalize-space()='ledger'])[1]")
    WebElement ledgerReportsPage;
    @FindBy(xpath = "(//li[normalize-space()='b2b payments'])[1]")
    WebElement b2bPaymentsReportsPage;
    @FindBy(xpath = "(//li[normalize-space()='driver payment requests'])[1]")
    WebElement driverPaymentRequestsReportsPage;

    @FindBy(xpath = "(//button[normalize-space()='download report'])[1]")
    WebElement downloadReportButton;

    @FindBy(css = "div.Toastify__toast-body")
    WebElement toastMessage;

    public void clickAccountPayoutReports() {
        try {
            accountPayoutReportsPage.click();
            log.info("Clicked account payout report button");
        }catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    public void clickPrefundReports() {
        try {
            prefundReportsPage.click();
            log.info("Clicked prefund report button");
        }catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    public void clickLedgerReports(){
        try {
            ledgerReportsPage.click();
            log.info("Clicked ledger report button");
        }catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    public void clickB2bPaymentsReports(){
        try {
            b2bPaymentsReportsPage.click();
            log.info("Clicked b2b payment report button");
        }catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    public void clickDriverPaymentRequestsReports(){
        try {
            driverPaymentRequestsReportsPage.click();
            log.info("Clicked driver payment report button");
        }catch (Exception e) {
            log.error(e.getMessage());
        }
    }
    public void clickDownloadReportButton() {
        try {
            downloadReportButton.click();
            log.info("Clicked download report button");
        }catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public String validateToastMessage() {
        Boolean otpCheck = waitUtils.isToastMessageVisible(toastMessage);
        if (otpCheck.equals(true)) {
            log.info("Message : " + testUtilities.captureToastMessage(toastMessage));
        }
        String actualToastMessage = testUtilities.captureToastMessage(toastMessage);
        return actualToastMessage;
    }

}