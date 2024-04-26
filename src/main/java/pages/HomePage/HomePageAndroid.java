package pages.HomePage;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomePageAndroid extends HomePageAbstract {


    public HomePageAndroid(AppiumDriver driver)
    {
        super(driver);
        skipBtn = By.id("continue_as_guest");
        homePageNavBtn=By.id("home");
        servicesPageBtn=By.id("services");
        seeAllservicesBtn=By.id("see_all_some_services_tv");
        mediaBtn=By.id("see_all_happening");
        mystreyShopperBtn=By.id("iv_mystrey_shopper");

    }
}
