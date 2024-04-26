package pages.HomePage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageAbstract {

    public By skipBtn;
    public By homePageNavBtn;
    public By servicesPageBtn;
    public By mediaBtn;
    public By mystreyShopperBtn;
    //service_item_name  |Test:Inquiry
    public By seeAllservicesBtn;
    AppiumDriver driver;

    public HomePageAbstract(AppiumDriver driver) {
        this.driver = driver;
    }
    //Skip Button
    public boolean validationSkip() {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(skipBtn)).isDisplayed();
        driver.findElement(skipBtn).click();
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(skipBtn)).isDisplayed();
    }

    //See all services in home page Button
    public boolean validationSeeAllServices() {
        driver.findElement(seeAllservicesBtn).click();
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(servicesPageBtn)).isDisplayed();
        return new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(servicesPageBtn)).isDisplayed();
    }

    //Media Btn in home page as a guest
    public boolean validationMediaBtn() {
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.invisibilityOfElementLocated(skipBtn));
        driver.findElement(mediaBtn).click();
        return new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(mediaBtn)).isDisplayed();
    }



    //Mystery Shopper Button
    public boolean validationMystreyShopper() {
        driver.findElement(mystreyShopperBtn).click();
        driver.close();
        driver.getCapabilities();
        return new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(mystreyShopperBtn)).isDisplayed();
    }


}
