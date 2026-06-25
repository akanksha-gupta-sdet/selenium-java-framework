package dataproviders;

import com.akanksha.automation.utils.ExcelUtils;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "loginData")
    public static Object[][] loginData() {
        return ExcelUtils.getTestData("testdata/LoginData.xlsx", "LoginData");
    }
}
