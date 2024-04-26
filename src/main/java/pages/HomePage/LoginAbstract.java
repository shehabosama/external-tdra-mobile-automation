package pages.HomePage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class LoginAbstract {
    public By loginBtn;
    public By emailTxt;
    public By passwordTxt;
    public By submitBtn;
    public By homePageNavBtn;
    public By servicesPageBtn;
    //service_item_name  |Test:Inquiry
    public By seeAllservicesBtn;
    public By requestsBtn;
    AppiumDriver driver;

    public LoginAbstract(AppiumDriver driver) {
        this.driver = driver;
    }

    //Login Button with username and password
    public boolean validationLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).isDisplayed();
        driver.findElement(loginBtn).click();
      driver.findElement(emailTxt).click();
       // new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(emailTxt)).clear();
        driver.navigate().back();
        new Actions(driver)
                .sendKeys(driver.findElement(emailTxt),"test3@bnsights.com")
                .perform();
        driver.findElement(passwordTxt).click();
        new Actions(driver)
                .sendKeys(driver.findElement(emailTxt),"P@ssw0rd")
                .perform();
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(submitBtn)).isEnabled();
        driver.findElement(submitBtn).click();
      return   new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(homePageNavBtn)).isDisplayed();

    }

    //View Requets list
    public boolean validationOfRequestsList() {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(homePageNavBtn));
        driver.findElement(requestsBtn).click();
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(homePageNavBtn)).isDisplayed();
    }
}
