package Pages.ClientPortal;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// page_url = https://test.moxey.ai/cards-ui/authenticate/login
public class LoginPage  {

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


}


