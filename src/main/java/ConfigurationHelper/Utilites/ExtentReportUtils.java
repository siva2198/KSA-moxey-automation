package ConfigurationHelper.Utilites;

import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ExtentReportUtils {
    private static ExtentTest testLogger;
    private WebDriver driver;

    //set the current test logger
    public static ExtentTest setTestLogger(ExtentTest logger) {
        testLogger = logger;
        return testLogger;
    }

    //Log information
    public static void logInfo(String message) {
        if(testLogger != null) {
            testLogger.log(Status.INFO,message);
        }
    }

    //Log error
    public static void logError(String message) {
        if(testLogger != null) {
            testLogger.log(Status.WARNING,message);
        }
    }

//Capture screenshots
    public static void captureScreenShot(String screenShotName) {
        if(testLogger != null) {
            File src = ((TakesScreenshot) BaseBrowserConfiguration.getDriver()).getScreenshotAs(OutputType.FILE);
            String path = System.getProperty("user.dir") + "/test-output/SparkReport" + screenShotName+".png";
            File file = new File(path);
            try {
                FileHandler.copy(src,file);
            } catch (IOException e) {
                logError("Screenshot capture failed: " + e.getMessage());
            }
        }
    }
}
