package tests;

import base.BaseTest;
import com.akanksha.automation.utils.ScreenshotUtil;
import org.testng.annotations.Test;

public class ScreenshotTest extends BaseTest {

    @Test
    public void takeScreenshotTest() {

        String filePath = ScreenshotUtil.captureScreenshot(driver, "HomePage");
        System.out.println(filePath);
    }
}
