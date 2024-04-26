package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage.HomePageAbstract;
import pages.HomePage.HomePageAndroid;
import pages.HomePage.HomePageiOS;
import utilities.readers.PropertiesReader;

public class HomeGuestTest extends BaseTest {

    HomePageAbstract homePage;
    public HomeGuestTest() throws Exception {
        setUp();
         if(PropertiesReader.getValue("Platform").equalsIgnoreCase("Android"))
         {
             homePage = new HomePageAndroid(driver);
         }
         else {
             homePage = new HomePageiOS(driver);
         }
    }
    @Test(enabled = false)

    public void ValidateSkipBtnTest()
    {
        Assert.assertTrue(homePage.validationSkip());
    }



}
