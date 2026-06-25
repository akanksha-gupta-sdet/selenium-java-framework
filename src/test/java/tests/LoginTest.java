package tests;

import base.BaseTest;
import com.akanksha.automation.utils.ScreenshotUtil;
import dataproviders.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.akanksha.automation.pages.LoginPage;
import retry.RetryAnalyzer;


public class LoginTest extends BaseTest {


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyLogin() {

        try {
            //LoginPage loginPage = new LoginPage(driver);
            LoginPage loginPage = new LoginPage(getDriver());

            loginPage.login(config.getProperty("username"), config.getProperty("password")
            );

            String currentUrl = getDriver().getCurrentUrl();

            Assert.assertTrue(currentUrl.contains("dashboard"));

            System.out.println("Login Test Thread : " + Thread.currentThread().getId());

        } catch (Exception e) {
            ScreenshotUtil.captureScreenshot(getDriver(), "verifyLogin");
            throw e;
        }
    }

    @Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void verifyLoginDataProvider(String username, String password) {
        //LoginPage loginPage = new LoginPage(driver);
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(username, password);
        System.out.println("Executing for user : " + username);
    }
}
