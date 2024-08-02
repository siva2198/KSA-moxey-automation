package StepDefinition;

import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import Pages.ClientPortal.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginClientTest {
    private LoginPage loginPage = new LoginPage(BaseBrowserConfiguration.getDriver());
    BaseBrowserConfiguration baseBrowserConfiguration = new BaseBrowserConfiguration();

    @Given("User is able to launch the browser and navigate to Client Portal")
    public void userIsAbleToLaunchTheBrowserAndNavigateToURL() {
        baseBrowserConfiguration.getClientBaseURL();
    }

    @When("User enters the Username and Password and OTP")
    public void userEntersTheUsernameAndPasswordAndOTP(){
        loginPage.enterUserNameAndPassword("rttransporter@moxey.ai","Moxey@123");
        loginPage.enterOTPAndClickVerify();
    }

    @Then("Get the get the current URL")
    public void getthegetthecurrenturl() {
        System.out.println(BaseBrowserConfiguration.getDriver().getCurrentUrl());
    }
}
