package ConfigurationHelper.Utilites;

import org.openqa.selenium.WebElement;

public class TestUtilities {

    public void uploadFile(WebElement locator){
        try{
        locator.sendKeys(System.getProperty("user.dir") +"/src/test/resources/TestData/UtilFiles/Test file.pdf");
    }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
