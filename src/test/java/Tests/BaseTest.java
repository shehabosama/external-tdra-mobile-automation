package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterClass;
import utilities.readers.PropertiesReader;

import java.net.URL;



public class BaseTest {

    public AppiumDriver driver;


    public void setUp() throws Exception {
        try{

            if (PropertiesReader.getValue("Platform").equalsIgnoreCase("Android")) {
                MutableCapabilities capabilities = new UiAutomator2Options();
                capabilities.setCapability("app", "bs://e12e577da195f961bb8603d3e81bba2f4fb8b05f");
                capabilities.setCapability("build","jenkins-ext-tdra-automation-pipeline-124");
                capabilities.setCapability("platformName","android");
                capabilities.setCapability("deviceName","Samsung Galaxy S22 Ultra");
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            } else {
                MutableCapabilities capabilities = new XCUITestOptions();
                capabilities.setCapability("app","bs://sample.app");
                capabilities.setCapability("platformName","ios");
                capabilities.setCapability("deviceName","iPhone XS");
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        //driver.quit();
    }
}