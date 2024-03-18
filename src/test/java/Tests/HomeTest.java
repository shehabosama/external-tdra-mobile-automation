package Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import pages.HomePage.HomePageAbstract;
import pages.HomePage.HomePageAndroid;
import pages.HomePage.HomePageiOS;
import utilities.readers.PropertiesReader;

public class HomeTest extends BaseTest {

    HomePageAbstract homePage;
    public HomeTest() throws Exception {
        setUp();
         if(PropertiesReader.getValue("Platform").equalsIgnoreCase("Android"))
         {
             homePage = new HomePageAndroid(driver);
         }
         else {
             homePage = new HomePageiOS(driver);
         }
    }
    @Test()
    public void ValidateSkipBtnTest()  {
        Assert.assertTrue(homePage.validationSkip());
    }

}
