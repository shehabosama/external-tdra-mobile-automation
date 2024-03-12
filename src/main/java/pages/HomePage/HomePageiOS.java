package pages.HomePage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePageiOS extends HomePageAbstract{

    public HomePageiOS(AppiumDriver driver)
    {
        super(driver);
        SkipBtn = By.id("");
    }
}
