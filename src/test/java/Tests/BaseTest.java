package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.readers.PropertiesReader;

import java.net.URL;

public class BaseTest {

    public AppiumDriver driver;


    public void setUp() throws Exception {

        if (PropertiesReader.getValue("Platform").equalsIgnoreCase("Android")) {
            MutableCapabilities capabilities = new UiAutomator2Options();
            capabilities.setCapability("app","bs://4f460a8dcf4e324616b5c3561f4a29dd76e8629b");
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
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}