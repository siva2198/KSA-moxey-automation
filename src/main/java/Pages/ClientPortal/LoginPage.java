package Pages.ClientPortal;


import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://ksa-test.moxey.ai/cards-ui/authenticate/login
public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
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


    public void enterUserNameAndPassword(String username, String password) {
        usernameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        signInButton.click();
    }
    public DashboardPage enterOTP(String otp) {
        enterOTP.sendKeys(otp);
        verifyOTPButton.click();
        return new DashboardPage(BaseBrowserConfiguration.getDriver());
    }




}


