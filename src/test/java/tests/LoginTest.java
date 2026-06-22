package tests;

import base.BaseTest;
import com.akanksha.automation.utils.ScreenshotUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.akanksha.automation.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLogin() {

        try {
            LoginPage loginPage = new LoginPage(driver);

            loginPage.login(
                    config.getProperty("username"),
                    config.getProperty("password")
            );

            String currentUrl = driver.getCurrentUrl();

            Assert.assertTrue(currentUrl.contains("dashboard"));
            Assert.assertTrue(false);
        } catch (Exception e) {
            ScreenshotUtil.captureScreenshot(driver, "verifyLogin");
            throw e;
        }
    }
}
