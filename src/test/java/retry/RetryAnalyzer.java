package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int currentRetryCount = 0;

    private static final int MAX_RETRY_COUNT = 2;

    @Override
    public boolean retry(ITestResult result) {

        if (currentRetryCount < MAX_RETRY_COUNT) {

            currentRetryCount++;

            System.out.println("Retrying Test : " + result.getName() + " Retry Count : " + currentRetryCount);
            System.out.println("Retrying because test failed");
            return true;
        }

        return false;
    }
}
