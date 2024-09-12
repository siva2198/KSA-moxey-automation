package StepDefinition;

import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import ConfigurationHelper.Utilites.ExcelReaderUtils;
import Pages.ClientPortal.DashboardPage;
import Pages.ClientPortal.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Map;

public class LoginClientTest {
    private LoginPage loginPage = new LoginPage(BaseBrowserConfiguration.getDriver());
    BaseBrowserConfiguration baseBrowserConfiguration = new BaseBrowserConfiguration();
    private ExcelReaderUtils excelReaderUtils = new ExcelReaderUtils();
    ExtentTest extentTest;

    @Given("User is able to launch the browser and navigate to Client Portal")
    public void userIsAbleToLaunchTheBrowserAndNavigateToURL() {
        baseBrowserConfiguration.getClientBaseURL();
    }

    @When("User enters the Username and Password and OTP")
    public void userEntersTheUsernameAndPasswordAndOTP() {
        loginPage.enterUserNameAndPassword("rttransporter@moxey.ai", "Moxey@123");
        extentTest.info("user entered the username and password");
        DashboardPage dashboardPage = loginPage.enterOTPAndClickVerify();
        dashboardPage.validateDashboard();
    }

    @When("the client admin enter the credentials and verify the OTP")
    public void theClientAdminEnterTheCredentialsAndVerifyTheOTP() throws IOException {
        int UserRole = 1;
        Map<String, String> credentials = excelReaderUtils.getLoginCredential(UserRole);

        String username = credentials.get("username");
        String password = credentials.get("password");

        loginPage.enterUserNameAndPassword(username, password);
        DashboardPage dashboardPage = loginPage.enterOTPAndClickVerify();
        dashboardPage.validateDashboard();

    }

    @When("the Hf enter the credentials and verify the OTP")
    public void theHfEnterTheCredentialsAndVerifyTheOTP() throws IOException {
        int UserRole = 2;
        Map<String, String> credentials = excelReaderUtils.getLoginCredential(UserRole);
        String username = credentials.get("username");
        String password = credentials.get("password");

        loginPage.enterUserNameAndPassword(username, password);
        DashboardPage dashboardPage = loginPage.enterOTPAndClickVerify();
        dashboardPage.validateDashboard();
    }

    @When("the HC enter the credentials and verify the OTP")
    public void theHCEnterTheCredentialsAndVerifyTheOTP() throws IOException {
        int UserRole = 3;
        Map<String, String> credentials = excelReaderUtils.getLoginCredential(UserRole);
        String username = credentials.get("username");
        String password = credentials.get("password");

        loginPage.enterUserNameAndPassword(username, password);
        DashboardPage dashboardPage = loginPage.enterOTPAndClickVerify();
        dashboardPage.validateDashboard();
    }

    @When("the Cashier enter the credentials and verify the OTP")
    public void theCashierEnterTheCredentialsAndVerifyTheOTP() throws IOException {
        int UserRole = 4;
        Map<String, String> credentials = excelReaderUtils.getLoginCredential(UserRole);
        String username = credentials.get("username");
        String password = credentials.get("password");

        loginPage.enterUserNameAndPassword(username, password);
        DashboardPage dashboardPage = loginPage.enterOTPAndClickVerify();
        dashboardPage.validateDashboard();
    }

    @Then("Get the get the current URL")
    public void getthegetthecurrenturl() {
        System.out.println(BaseBrowserConfiguration.getDriver().getCurrentUrl());
    }
}
