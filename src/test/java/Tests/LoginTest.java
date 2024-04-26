package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage.*;
import utilities.readers.PropertiesReader;

public class LoginTest extends BaseTest {


    LoginAbstract loginPage;

    public LoginTest() throws Exception {
        setUp();
        if (PropertiesReader.getValue("Platform").equalsIgnoreCase("Android")) {
            loginPage = new LoginPageAndroid(driver);
        } else {
            loginPage = new LoginPageIOS(driver);
        }
    }

    @Test(priority = 1)

    public void ValidateLoginTest() {
        Assert.assertTrue(loginPage.validationLogin());
    }
@Test(priority = 2)
public void ValidateRequestsTest() {
    Assert.assertTrue(loginPage.validationOfRequestsList());
}
}



