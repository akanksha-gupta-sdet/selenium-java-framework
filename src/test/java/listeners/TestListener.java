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

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());

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

        BaseTest baseTest = (BaseTest) result.getInstance();

        WebDriver driver = baseTest.getDriver();

        if (driver != null) {
            try {
                String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());

                if (test.get() != null) {
                    test.get().addScreenCaptureFromPath(screenshotPath);
                } else if (test.get() == null) {
                    System.out.println("ExtentTest object is null for : " + result.getMethod().getMethodName());
                }
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
