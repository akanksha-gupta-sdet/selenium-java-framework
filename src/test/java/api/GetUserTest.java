package api;

import base.BaseApiTest;
import com.akanksha.automation.api.ApiClient;
import com.akanksha.automation.api.ApiEndpoints;
import com.akanksha.automation.api.ApiResponseSpec;
import com.akanksha.automation.utils.SchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import reporting.ApiReportLogger;

public class GetUserTest extends BaseApiTest {

    @Test
    public void verifyGetPostApi() {

        Response response = ApiClient.get(requestSpec, ApiEndpoints.SINGLE_POST);

        response.then().spec(ApiResponseSpec.getSuccessResponseSpec(200));

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200);
        response.then().spec(ApiResponseSpec.getSuccessResponseSpec(200));

        SchemaValidator.validateSchema(response.then(), "post-schema.json");

        Assert.assertEquals(response.jsonPath().getInt("id"), 1);

        Assert.assertEquals(response.jsonPath().getInt("userId"), 1);
    }
}
