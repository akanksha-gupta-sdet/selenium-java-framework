package base;

import com.akanksha.automation.factory.DriverFactory;
import com.akanksha.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Listeners(TestListener.class)
public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    public ConfigReader config;

    @BeforeMethod
    public void setup() {

        config = new ConfigReader();

        WebDriver webDriver = DriverFactory.initializeDriver(config.getProperty("browser"));

        logger.info("Browser Started");

        DriverFactory.setDriver(webDriver);

        DriverFactory.getDriver().get(config.getProperty("url"));

        logger.info("Thread ID : {}" , Thread.currentThread().getId());
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown() {

        if (DriverFactory.getDriver() != null) {

            DriverFactory.getDriver().quit();

            DriverFactory.unload();
        }
    }
}
