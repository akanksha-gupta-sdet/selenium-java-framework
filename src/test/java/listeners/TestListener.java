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

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return test.get();
    }

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getTestClass().getRealClass().getSimpleName() + " :: " + result.getMethod().getMethodName();

        ExtentTest extentTest = extent.createTest(testName);
        test.set(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        if (test.get() != null) {
            test.get().fail(result.getThrowable());
        }

        if (result.getInstance() instanceof BaseTest) {

            BaseTest baseTest = (BaseTest) result.getInstance();

            WebDriver driver = baseTest.getDriver();

            if (driver != null) {

                try {

                    String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());

                    test.get().addScreenCaptureFromPath(screenshotPath);

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
