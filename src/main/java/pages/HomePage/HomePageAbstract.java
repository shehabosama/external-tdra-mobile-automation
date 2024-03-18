package pages.HomePage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageAbstract {

    public By SkipBtn;

    AppiumDriver driver;

    public HomePageAbstract(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean validationSkip() {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(SkipBtn)).isDisplayed();


    }

}
