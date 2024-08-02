package Pages.ClientPortal;


import ConfigurationHelper.Utilites.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author "Sivaraman M"
 */
public class AccountsPage {
    WebDriver driver;
    WaitUtils waitUtils;
    public AccountsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }
}
