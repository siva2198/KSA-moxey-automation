package StepDefinition;

import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import Pages.ClientPortal.DashboardPage;
import Pages.ClientPortal.ReportsPage;
import io.cucumber.java.en.And;
import org.jsoup.Connection;
import org.junit.Assert;

public class ClientReportsDownloadTest {
private DashboardPage dashboardPage = new DashboardPage(BaseBrowserConfiguration.getDriver());
ReportsPage reportsPage = new ReportsPage(BaseBrowserConfiguration.getDriver());

    @And("User click on Reports Page")
    public void userClickOnReportsPage() {
        try {
            dashboardPage.clickOnReportsPage();
            Assert.assertFalse();
        }
    }
}
