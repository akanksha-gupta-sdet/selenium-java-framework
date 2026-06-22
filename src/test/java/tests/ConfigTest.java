package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.akanksha.automation.utils.ConfigReader;

public class ConfigTest {

    @Test
    public void readConfig() {

        ConfigReader config = new ConfigReader();
        System.out.println(config.getProperty("browser"));
        System.out.println(config.getProperty("url"));
        Assert.assertNotNull(config.getProperty("browser"),"Browser value is missing");
        Assert.assertNotNull(config.getProperty("url"),"Url value is missing");
    }
}
