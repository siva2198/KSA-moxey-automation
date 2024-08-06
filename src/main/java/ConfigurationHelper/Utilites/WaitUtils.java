package ConfigurationHelper.Utilites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger log = LogManager.getLogger(WaitUtils.class);

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitUntilElementVisible(WebElement locator) {
        try {
            wait.until(ExpectedConditions.visibilityOf(locator));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

    public void waitUntilElementInVisible(WebElement locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOf(locator));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void waitUntilElementClickable(WebElement locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void waitUntilElementIsDisplayed(WebElement locator) {
        try {
            wait.until(ExpectedConditions.visibilityOf(locator));
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

}
