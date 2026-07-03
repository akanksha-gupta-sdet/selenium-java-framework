package base;

import com.akanksha.automation.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import reporting.ExtentApiFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseApiTest {

    protected RequestSpecification requestSpec;
    private static final Logger logger = LogManager.getLogger(BaseApiTest.class);

    @BeforeClass
    public void setupAPI() {

        logger.info("========== BaseApiTest Started ==========");

        ConfigReader config = new ConfigReader();

        RestAssured.baseURI = config.getProperty("baseUrl");

        logger.info("Base URI : {}", RestAssured.baseURI);

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .setContentType(ContentType.JSON)
                .addFilter(new ExtentApiFilter())
                .log(LogDetail.ALL)
                .build();

        logger.info("Request Spec Created : {}" , requestSpec);
    }
}

