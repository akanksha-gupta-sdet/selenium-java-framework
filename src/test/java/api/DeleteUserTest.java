package api;

import base.BaseApiTest;
import com.akanksha.automation.api.ApiClient;
import com.akanksha.automation.api.ApiEndpoints;
import com.akanksha.automation.api.ApiResponseSpec;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import reporting.ApiReportLogger;

public class DeleteUserTest extends BaseApiTest {

    @Test
    public void verifyDeleteUserApi() {

        Response response = ApiClient.delete(requestSpec, ApiEndpoints.SINGLE_POST);

        System.out.println("Status Code : " + response.getStatusCode());

       response.then().spec(ApiResponseSpec.getSuccessResponseSpec(200));
    }
}