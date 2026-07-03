package reporting;

import com.aventstack.extentreports.ExtentTest;
import listeners.TestListener;

public class ExtentLogger {

    public static void info(String message) {

        ExtentTest test = TestListener.getTest();

        if (test != null) {
            test.info(message);
        }
    }

    public static void pass(String message) {

        ExtentTest test = TestListener.getTest();

        if (test != null) {
            test.pass(message);
        }
    }

    public static void fail(String message) {

        ExtentTest test = TestListener.getTest();

        if (test != null) {
            test.fail(message);
        }
    }

    public static void warning(String message) {

        ExtentTest test = TestListener.getTest();

        if (test != null) {
            test.warning(message);
        }
    }
}
