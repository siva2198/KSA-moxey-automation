package ConfigurationHelper.DriverFactory;
import ConfigurationHelper.Utilites.ConfigurationPropertiesReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseBrowserConfiguration {
    public WebDriver driver;
    public ConfigurationPropertiesReader configurationPropertiesReader;
    public Properties properties;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private static final Logger log = LogManager.getLogger(BaseBrowserConfiguration.class);


    public WebDriver initializeDriver(String browser) {
        log.info("Initializing browser: " + browser);
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            tlDriver.set(new InternetExplorerDriver());
        } else {
            System.out.println("Unsupported browser: " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }

    public BaseBrowserConfiguration() {
        log.info("BaseBrowserConfiguration initialized - properties loaded with properties file");
        configurationPropertiesReader = new ConfigurationPropertiesReader();
        properties = configurationPropertiesReader.loadProperties();
    }

    public void getClientBaseURL() {
        try {
            log.info("{}trigger client base URL", this.getClass().getName());
            getDriver().get(properties.getProperty("clientBaseURL"));
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void getAdminBaseURL() {
        try {
            log.info("{}trigger admin base URL", this.getClass().getName());
            getDriver().get(properties.getProperty("adminBaseURL"));
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
