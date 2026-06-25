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



    public ConfigReader config;

//    @BeforeMethod
//    public void setup() throws InterruptedException {
//
//        config = new ConfigReader();
//
//        driver = DriverFactory.initializeDriver(
//                config.getProperty("browser"));
//
//        driver.manage().window().maximize();
//
//        driver.get(config.getProperty("url"));
//
//        Thread.sleep(5000);
//    }

    @BeforeMethod
    public void setup() {

         config = new ConfigReader();

        WebDriver webDriver = DriverFactory.initializeDriver(config.getProperty("browser"));

        DriverFactory.setDriver(webDriver);

        DriverFactory.getDriver().get(config.getProperty("url"));

        System.out.println("Thread ID : " + Thread.currentThread().getId());
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }

    @AfterMethod
    public void tearDown() {

        if (DriverFactory.getDriver() != null) {

            DriverFactory.getDriver().quit();

            DriverFactory.unload();
        }
    }
}
