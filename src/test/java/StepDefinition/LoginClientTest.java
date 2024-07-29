package StepDefinition;

import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import Pages.ClientPortal.DashboardPage;
import Pages.ClientPortal.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginClientTest {
    private LoginPage loginPage = new LoginPage(BaseBrowserConfiguration.getDriver());

    @Given("User is able to launch the browser and navigate to Client Portal")
    public void userIsAbleToLaunchTheBrowserAndNavigateToURL() {
        BaseBrowserConfiguration.getDriver().get("https://ksa-test.moxey.ai/cards-ui/authenticate/login");
    }

    @When("User enters the Username and Password and OTP")
    public void userEntersTheUsernameAndPasswordAndOTP() throws InterruptedException {
        loginPage.enterUserNameAndPassword("rttransporter@moxey.ai","Moxey@123");
        Thread.sleep(2000);
        loginPage.enterOTP("123456");
        Thread.sleep(2000);
    }

    @Then("Get the get the current URL")
    public void getthegetthecurrenturl() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(BaseBrowserConfiguration.getDriver().getCurrentUrl());
    }
}
