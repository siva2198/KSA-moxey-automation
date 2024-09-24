package StepDefinition;

import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import ConfigurationHelper.Utilites.ExtentReportUtils;
import Pages.ClientPortal.DashboardPage;
import Pages.ClientPortal.ReportsPage;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ClientReportsDownloadTest {
    private DashboardPage dashboardPage = new DashboardPage(BaseBrowserConfiguration.getDriver());
    ReportsPage reportsPage = new ReportsPage(BaseBrowserConfiguration.getDriver());
    ExtentTest logger = ExtentReportUtils.setTestLogger(ExtentCucumberAdapter.getCurrentStep());


    @And("User click on Reports Page")
    public void userClickOnReportsPage() {
        try {
            dashboardPage.clickOnReportsPage();
            if (reportsPage.isToastMessageVisible()) {
                logger.info("Exceptions : " + reportsPage.validateToastMessage());
            }
        } catch (Exception e) {

        }
    }

    @When("User select Account Payouts and clicks on download button")
    public void userSelectAccountPayoutsAndClicksOnDownloadButton() {
        try {
            reportsPage.clickAccountPayoutReports();
            if (reportsPage.isToastMessageVisible()) {
                logger.info("Exceptions : " + reportsPage.validateToastMessage());
            }
        } catch (Exception e) {
        }
    }
}
