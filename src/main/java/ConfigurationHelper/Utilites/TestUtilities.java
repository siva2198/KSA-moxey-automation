package ConfigurationHelper.Utilites;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static ConfigurationHelper.Utilites.SequentialNumberUtil.getNextSequentialNumber;

public class TestUtilities {
    private static final Logger log = LogManager.getLogger(TestUtilities.class);
    private static final String sequentialNumber;
    WaitUtils waitUtils;

    public TestUtilities(WebDriver driver) {
        // Initialize WaitUtils with the provided WebDriver
        this.waitUtils = new WaitUtils(driver);
    }

    static {
        try {
            sequentialNumber = getNextSequentialNumber();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadFile(WebElement locator) {
        try {
            log.info("Uploading file");
            locator.sendKeys(System.getProperty("user.dir") + "/src/test/resources/TestData/UtilFiles/Test file.pdf");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void getRequestPrefundAmount(WebElement locator) {
        log.info("getRequestPrefundAmount");
        locator.sendKeys("100");
    }

    public String getBankReferenceNumber(WebElement locator) {
        return "BANK_REF_" + sequentialNumber;
    }

    public String getInternalReferenceNumber(WebElement locator) {
        return "INTERNAL_REF_" + sequentialNumber;
    }

    public String getComments(WebElement locator) {
        return "TESTING_" + sequentialNumber;
    }

    public String captureToastMessage(WebElement locator) {
        try {
            waitUtils.waitUntilElementVisible(locator);
            log.info("captureToastMessage");
            String toastMess = locator.getText();
            return toastMess;
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }
}
