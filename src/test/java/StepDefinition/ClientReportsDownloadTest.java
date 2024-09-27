package StepDefinition;

import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import ConfigurationHelper.Utilites.ExtentReportUtils;
import Pages.ClientPortal.DashboardPage;
import Pages.ClientPortal.ReportsPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;

public class ClientReportsDownloadTest {
    private static final Logger log = Logger.getLogger(ClientReportsDownloadTest.class);
    private DashboardPage dashboardPage = new DashboardPage(BaseBrowserConfiguration.getDriver());
    ReportsPage reportsPage = new ReportsPage(BaseBrowserConfiguration.getDriver());
    ExtentTest logger = ExtentReportUtils.setTestLogger(ExtentCucumberAdapter.getCurrentStep());
    SoftAssert softAssert = new SoftAssert();
    boolean isToastVisible = reportsPage.isToastMessageVisible();

    @And("User click on Reports Page")
    public void userClickOnReportsPage() {
        try {
            dashboardPage.clickOnReportsPage();
            if (isToastVisible) {
                logger.info("Exception Thrown : " + reportsPage.toastMessage());
            }
        }catch (Exception e) {

        }
    }

    @When("User select Account Payouts and clicks on download button")
    public void userSelectAccountPayoutsAndClicksOnDownloadButton() {
        try {
            reportsPage.clickAccountPayoutReports();
            if (isToastVisible) {
                logger.info("Exception Thrown : " + reportsPage.toastMessage());
            }
            reportsPage.clickDownloadReportButton();
            if (isToastVisible) {
                logger.info("Exception Thrown : " + reportsPage.toastMessage());
            }
        }catch (Exception e) {

        }
    }

    @Then("the Account Payouts reports should be downloaded successfully")
    public void theAccountPayoutsReportsShouldBeDownloadedSuccessfully() {
        log.info(reportsPage.getAccountPayoutReportsPageText() + " report downloaded successfully");
    }

    @When("User select Prefund and clicks on download button")
    public void userSelectPrefundAndClicksOnDownloadButton() {
        try {
            reportsPage.clickPrefundReports();
            if (isToastVisible) {
                logger.info("Exception Thrown : " + reportsPage.toastMessage());
            }
            reportsPage.clickDownloadReportButton();
            if (isToastVisible) {
                logger.info("Exception Thrown : " + reportsPage.toastMessage());
            }
        }catch (Exception e) {
        }
    }

    @Then("the Prefund reports should be downloaded successfully")
    public void thePrefundReportsShouldBeDownloadedSuccessfully() {
        log.info(reportsPage.getPrefundReportsPageText() + " report downloaded successfully");
    }

    @When("User select Ledger and clicks on download button")
    public void userSelectLedgerAndClicksOnDownloadButton() {
        try {
            reportsPage.clickLedgerReports();
            if (isToastVisible) {
                logger.info("Exception Thrown : " + reportsPage.toastMessage());
            }
            reportsPage.clickDownloadReportButton();
            if (isToastVisible) {
                logger.info("Exception Thrown : " + reportsPage.toastMessage());
            }
        }catch (Exception e) {
        }
    }

    @Then("the Ledger reports should be downloaded successfully")
    public void theLedgerReportsShouldBeDownloadedSuccessfully() {
        log.info(reportsPage.getLedgerReportsPageText()+" report downloaded successfully");
    }

    @When("User select Driver Payment requests and clicks on download button")
    public void userSelectDriverPaymentRequestsAndClicksOnDownloadButton() {
        try {
            reportsPage.clickDriverPaymentRequestsReports();
            if (isToastVisible) {
                logger.info("Exception Thrown : " + reportsPage.toastMessage());
            }
            reportsPage.clickDownloadReportButton();
            if (isToastVisible) {
                logger.info("Exception Thrown : " + reportsPage.toastMessage());
            }
        }catch (Exception e) {
        }
    }

    @Then("the Driver Payment Request reports should be downloaded successfully")
    public void theDriverPaymentRequestReportsShouldBeDownloadedSuccessfully() {
        log.info(reportsPage.getDriverPaymentRequestsReportsPageText() + " report downloaded successfully");
    }

    @When("User select Vendor Payments and clicks on download button")
    public void userSelectVendorPaymentsAndClicksOnDownloadButton() {
        try {
            reportsPage.clickB2bPaymentsReports();
            if (isToastVisible) {
                logger.info("Exception Thrown : " + reportsPage.toastMessage());
            }
            reportsPage.clickDownloadReportButton();
            if (isToastVisible) {
                logger.info("Exception Thrown : " + reportsPage.toastMessage());
            }
        }catch (Exception e) {
        }
    }
    @Then("the Vendor reports should be downloaded successfully")
    public void theVendorReportsShouldBeDownloadedSuccessfully() {
        log.info(reportsPage.getB2bPaymentsReportsPageText() + " report downloaded successfully");
    }

}
