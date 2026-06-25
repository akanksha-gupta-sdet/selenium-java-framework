package listeners;

import base.BaseTest;
import com.akanksha.automation.utils.ExtentManager;
import com.akanksha.automation.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private ExtentReports extent = ExtentManager.getInstance();

    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        BaseTest baseTest = (BaseTest) result.getInstance();

        WebDriver driver = baseTest.getDriver();

        if (driver != null) {
            try {
                String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());

                test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
