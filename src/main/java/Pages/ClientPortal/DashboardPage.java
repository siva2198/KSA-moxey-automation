package Pages.ClientPortal;


import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * @author "Sivaraman M"
 */
public class DashboardPage {
    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //all the side options - Dashboard - Cards - Driver - BulkOpertaions - Reports - Request - Moxey Store - Profile - Settings - Logout
    @FindBy(xpath = "(//li[@class='menu-item swipe active'][normalize-space()='dashboard'])[1]")
    WebElement dashboardPage;
    @FindBy(xpath = "(//li[@class='menu-item swipe active'][normalize-space()='accounts'])[1]")
    WebElement cardsPage;
    @FindBy(xpath = "(//li[@class='menu-item swipe active'][normalize-space()='accounts'])[1]")
    WebElement driversPage;
    @FindBy(xpath = "(//li[@class='menu-item swipe '][normalize-space()='Bulk Operation'])[1]")
    WebElement bulkOperationsPage;
    @FindBy(xpath = "(//li[contains(@class,'menu-item swipe')][normalize-space()='Reports'])[1]")
    WebElement reportsPage;
    @FindBy(xpath = "(//li[contains(@class,'menu-item swipe')][normalize-space()='Requests'])[1]")
    WebElement requestPage;
    @FindBy(xpath = "(//li[contains(@class,'menu-item swipe')][normalize-space()='MoXey Store'])[1]")
    WebElement moxeyStorePage;
    @FindBy(xpath = "(//li[contains(@class,'menu-item swipe')][normalize-space()='Profile'])[1]")
    WebElement profilePage;
    @FindBy(xpath = "(//li[contains(@class,'menu-item swipe')][normalize-space()='Settings'])[1]")
    WebElement settingsPage;
    @FindBy(xpath = "(//li[contains(@class,'menu-item swipe')][normalize-space()='Logout'])[1]")
    WebElement logout;

    @FindBy(xpath = "//h4[normalize-space()='dashboard']")
    WebElement textDashboard;

    @FindBy(xpath = "//div[contains(@class, 'cards_card__N6FX7')]//p[contains(@class, 'cards_card_text__Y+m-w')]\n")
    WebElement AvailablePrefundText;
    @FindBy(xpath = "//div[contains(@class, 'cards_card__N6FX7')]//span[contains(@class, 'cards_card_value_pre__yA8Dx')]\n")
    WebElement SARText;
    @FindBy(xpath = "//div[contains(@class, 'cards_card__N6FX7')]//span[contains(@class, 'cards_card_value_text__lsxhy')]\n")
    WebElement AvailablePrefundAmountText;


    public String DashboardAvailablePrefundAmount() {
        Assert.assertTrue(AvailablePrefundAmountText.isDisplayed());
        String availablePrefundText = AvailablePrefundText.getText().trim();
        String sarText = SARText.getText().trim();
        String availablePrefundAmountText = AvailablePrefundAmountText.getText().trim();
        String dashboardAvailablePrefundAmountText = availablePrefundText + " " + sarText + " " + availablePrefundAmountText;
        return dashboardAvailablePrefundAmountText;
    }

    public void validateDashboard() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertTrue(textDashboard.isDisplayed());
    }

    public String getDashboardTitle(){
        Assert.assertTrue(textDashboard.isDisplayed());
        String titleDashboard = textDashboard.getText();
        return titleDashboard;
    }}

