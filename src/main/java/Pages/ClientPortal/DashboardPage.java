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
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author "Sivaraman M"
 */
public class DashboardPage extends BaseBrowserConfiguration {
    WebDriver driver;
    WaitUtils waitUtils;
    TestUtilities testUtilities;
    private static final Logger log = LogManager.getLogger(DashboardPage.class);

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.testUtilities = new TestUtilities(driver);
        PageFactory.initElements(driver, this);
    }

    //all the side options - Dashboard - Cards - Driver - BulkOpertaions - Reports - Request - Moxey Store - Profile - Settings - Logout
    @FindBy(xpath = "(//li[@class='menu-item swipe '][normalize-space()='dashboard'])[1]")
    WebElement dashboardPage;
    @FindBy(xpath = "(//li[@class='menu-item swipe '][normalize-space()='accounts'])[1]")
    WebElement accountsPage;
    @FindBy(xpath = "(//li[@class='menu-item swipe '][normalize-space()='drivers'])[1]")
    WebElement driversPage;
    @FindBy(xpath = "(//li[@class='menu-item swipe '][normalize-space()='bulk operation'])[1]")
    WebElement bulkOperationsPage;
    @FindBy(xpath = "(//li[contains(@class,'menu-item swipe ')][normalize-space()='reports'])[1]")
    WebElement reportsPage;
    @FindBy(xpath = "(//li[contains(@class,'menu-item swipe ')][normalize-space()='requests'])[1]")
    WebElement requestPage;
    @FindBy(xpath = "(//li[contains(@class,'menu-item swipe ')][normalize-space()='profile'])[1]")
    WebElement profilePage;
    @FindBy(xpath = "(//li[contains(@class,'menu-item swipe ')][normalize-space()='settings'])[1]")
    WebElement settingsPage;
    @FindBy(xpath = "(//li[contains(@class,'menu-item swipe ')][normalize-space()='logout'])[1]")
    WebElement logout;

    @FindBy(xpath = "//h4[normalize-space()='dashboard']")
    WebElement textDashboard;

    @FindBy(xpath = "//p[normalize-space()='available prefund']")
    WebElement AvailablePrefundText;
    @FindBy(xpath = "(//span[normalize-space()='SAR'])[1]")
    WebElement SARText;
    @FindBy(xpath = "//div[contains(@class, 'cards_card__N6FX7')]//span[contains(@class, 'cards_card_value_text__lsxhy')]\n")
    WebElement AvailablePrefundAmountText;
    @FindBy(xpath = "//p[normalize-space()='total drivers']")
    WebElement totalDriversText;

    //toast
    @FindBy(css = "div.Toastify__toast-body")
    WebElement toastMessage;


    public String DashboardAvailablePrefundAmount() {
        String availablePrefundText = AvailablePrefundText.getText().trim();
        String sarText = SARText.getText().trim();
        String availablePrefundAmountText = AvailablePrefundAmountText.getText().trim();
        return String.format("%s %s %s", availablePrefundText, sarText, availablePrefundAmountText);
    }

    public void validateDashboard() {
        log.info("validate dashboard page");
    }


    public String getDashboardTitle() {
        Boolean checkDashboard = waitUtils.isToastMessageVisible(toastMessage);
        if (checkDashboard.equals(true)) {
            log.error(testUtilities.captureToastMessage(toastMessage));
        }
        String titleDashboard = textDashboard.getText();
        return titleDashboard;
    }

    public AccountsPage clickOnAccountsPage() {
        try {
            accountsPage.click();
            log.info("Clicked on accounts page");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return new AccountsPage(driver);
    }

    public ReportsPage clickOnReportsPage() {
        try{
            reportsPage.click();
            log.info("Clicked on Reports Page");
        }catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return new ReportsPage(driver);
    }
}

