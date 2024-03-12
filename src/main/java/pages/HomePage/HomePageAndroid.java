package pages.HomePage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePageAndroid extends HomePageAbstract {


    public HomePageAndroid(AppiumDriver driver)
    {
        super(driver);
        SkipBtn = By.id("continue_as_guest");

    }
}
