package StepDefinition;

import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import Pages.ClientPortal.DashboardPage;
import Pages.ClientPortal.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DashboardComponents {
    DashboardPage dashboardPage = new DashboardPage(BaseBrowserConfiguration.getDriver());

    @Then("page title should be {string}")
    public void pageTitleShouldBe(String expectedPageTitle) throws InterruptedException {
        String actualPageTitle = dashboardPage.getDashboardTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
        System.out.println("page title should be " + expectedPageTitle);
    }

    @Then("get the current available prefund balance")
    public void getTheCurrentAvailablePrefundBalance() {
        String availablePrefundAmount = dashboardPage.DashboardAvailablePrefundAmount();
        System.out.println(availablePrefundAmount);
    }

    @Then("User is on the dashboard Page")
    public void userIsOnTheDashboardPage() throws InterruptedException {
        dashboardPage.validateDashboard();
    }


}
