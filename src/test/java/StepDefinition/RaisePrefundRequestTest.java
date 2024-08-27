package StepDefinition;

import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import Pages.ClientPortal.AccountsPage;
import Pages.ClientPortal.DashboardPage;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

import java.io.IOException;

public class RaisePrefundRequestTest {
    private static final Logger log = Logger.getLogger(RaisePrefundRequestTest.class);
    DashboardPage dashboardPage = new DashboardPage(BaseBrowserConfiguration.getDriver());
    AccountsPage accountsPage;


    @Then("Click on Accounts option")
    public void clickOnAccountsOption() {
        accountsPage = dashboardPage.clickOnAccountsPage();
    }

    @And("Click on Request Prefund button")
    public void clickOnRequestPrefundButton() {
        if (accountsPage != null) {
            accountsPage.clickRequestPrefundButton();
        } else {
            log.error("Account page is not initialized");
            throw new Error("Account page is null!");
        }
    }

    @Then("enter amount, bank reference number,internal reference no,add note, upload document and click on submit")
    public void enterAmountBankReferenceNumberInternalReferenceNoAddNoteUploadDocumentAndClickOnSubmit() throws IOException, InterruptedException {
        if (accountsPage != null) {
            accountsPage.fillRequestPrefundAmountInput();
            accountsPage.fillRequestPrefundBankRefNoInput();
            accountsPage.fillRequestPrefundInternalRefNoInput();
            accountsPage.fillRequestPrefundCommentsInput();
            accountsPage.fillRequestPrefundFileUploadInput();
            accountsPage.fillRequestPrefundSubmitButton();
        } else {
            log.error("Account page is not initialized");
            throw new Error("Account page is null!");
        }
    }


}
