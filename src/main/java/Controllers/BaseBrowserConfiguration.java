package Controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseBrowserConfiguration {
    WebDriver driver;
    @BeforeSuite(alwaysRun = true)
    public void initializeBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterSuite(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
    }
}
