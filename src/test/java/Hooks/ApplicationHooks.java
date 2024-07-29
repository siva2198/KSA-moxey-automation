package Hooks;

import ConfigurationHelper.DriverFactory.BaseBrowserConfiguration;
import ConfigurationHelper.Utilites.ConfigurationPropertiesReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {
    private BaseBrowserConfiguration baseBrowserConfiguration;
    private WebDriver driver;
    private ConfigurationPropertiesReader configurationPropertiesReader;
    Properties properties;

    @Before(order = 0)
    public void getProperty() {
        configurationPropertiesReader = new ConfigurationPropertiesReader();
        properties = configurationPropertiesReader.loadProperties();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = properties.getProperty("browser");
        baseBrowserConfiguration = new BaseBrowserConfiguration();
        driver = baseBrowserConfiguration.initializeDriver(browserName);
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void screenShotForFailedScenarios(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenShotName = scenario.getName().replace(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath,"image/png",screenShotName);
        }
    }
}
