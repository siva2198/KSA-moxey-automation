package StepDefinition;

import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import Pages.ClientPortal.DashboardPage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class DashboardComponentsTest {
    DashboardPage dashboardPage = new DashboardPage(BaseBrowserConfiguration.getDriver());


    @Then("get the current available prefund balance")
    public void getTheCurrentAvailablePrefundBalance() {
        String availablePrefundAmount = dashboardPage.DashboardAvailablePrefundAmount();
        System.out.println(availablePrefundAmount);
    }

    @Then("User is on the dashboard Page")
    public void userIsOnTheDashboardPage() throws InterruptedException {
        dashboardPage.validateDashboard();
    }


    @Then("Page title should be {string}")
    public void pageTitleShouldBe(String expectedPageTitle) {
        String actualPageTitle = dashboardPage.getDashboardTitle();
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
        System.out.println("page title should be " + expectedPageTitle);
    }
}
