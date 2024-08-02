package ConfigurationHelper.Utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void waitUntilElementVisible(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }
    public void waitUntilElementInVisible(WebElement locator) {
        wait.until(ExpectedConditions.invisibilityOf(locator));
    }
    public void waitUntilElementClickable(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilElementIsDisplayed(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

}
