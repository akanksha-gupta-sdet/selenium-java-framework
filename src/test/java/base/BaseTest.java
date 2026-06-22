package base;

import com.akanksha.automation.factory.DriverFactory;
import com.akanksha.automation.utils.ConfigReader;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import listeners.TestListener;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public class BaseTest {

    @Getter
    protected WebDriver driver;
    public ConfigReader config;

    @BeforeMethod
    public void setup() throws InterruptedException {

        config = new ConfigReader();

        driver = DriverFactory.initializeDriver(
                config.getProperty("browser"));

        driver.manage().window().maximize();

        driver.get(config.getProperty("url"));

        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
