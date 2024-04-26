package pages.HomePage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPageAndroid extends LoginAbstract {
    public LoginPageAndroid(AppiumDriver driver) {
        super(driver);
        homePageNavBtn = By.id("home");
        servicesPageBtn = By.id("services");
        loginBtn = By.id("continue_with_email_btn");
        emailTxt = By.id("email_input");
        passwordTxt = By.id("password_input");
        submitBtn = By.id("buttonText");
        seeAllservicesBtn = By.id("see_all_some_services_tv");
        requestsBtn = By.id("see_all_requests_tv");
    }
}