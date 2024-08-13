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

// page_url = https://ksa-test.moxey.ai/cards-ui/authenticate/login
public class LoginPage extends BaseBrowserConfiguration{
    WebDriver driver;
    WaitUtils waitUtils;
   TestUtilities testUtilities;
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.testUtilities = new TestUtilities(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-username")
    WebElement usernameTextField;
    @FindBy(id = "input-paassword")
    WebElement passwordTextField;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInButton;
    @FindBy(xpath = "//a[normalize-space()='Forgot Password']")
    WebElement forgotPasswordLink;
    @FindBy(xpath = "//input[@aria-label='Please enter verification code. Digit 1']")
    WebElement enterOTP;
    @FindBy(css = ".btn.btn-primary.btn-lg.mt-4")
    WebElement verifyOTPButton;
    @FindBy(css = "div.Toastify__toast-body")
    WebElement toastMessage;


    public void enterUserNameAndPassword(String username, String password) {
        log.info("Entering User Name and Password");
        waitUtils.waitUntilElementClickable(usernameTextField);
        usernameTextField.sendKeys(username);
        waitUtils.waitUntilElementClickable(passwordTextField);
        passwordTextField.sendKeys(password);
        signInButton.click();
    }

    public DashboardPage enterOTPAndClickVerify() {
        log.info("Entering OTP and Click Verify");
        waitUtils.waitUntilElementVisible(enterOTP);
        testUtilities.captureToastMessage(toastMessage);
        log.info(testUtilities.captureToastMessage(toastMessage));
        String otp = properties.getProperty("loginOTP");
        enterOTP.sendKeys(otp);
        waitUtils.waitUntilElementClickable(verifyOTPButton);
        verifyOTPButton.click();
        return new DashboardPage(BaseBrowserConfiguration.getDriver());
    }
}


