package ConfigurationHelper.Utilites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class WaitUtils {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final Logger log = LogManager.getLogger(WaitUtils.class);

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    //Fluent wait for toast message visible
    public boolean isToastMessageVisible(WebElement locator) {
        try {
            int timeOutSeconds = 3;
            int pollingIntervalSeconds = 1;
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeOutSeconds))
                    .pollingEvery(Duration.ofSeconds(pollingIntervalSeconds))
                    .ignoring(NoSuchElementException.class);

            WebElement toastElement = fluentWait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    WebElement  element = locator;
                    if (element.isDisplayed()) {
                        return element;
                    } else {
                        return null;
                    }
                }
            });

            return toastElement != null && toastElement.isDisplayed();
        } catch (NoSuchElementException e) {
            log.error("Toast Message was not displayed: " + e.getMessage());
            return false;
        }
    }


}
