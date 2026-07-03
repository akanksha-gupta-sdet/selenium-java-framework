package api;

import base.BaseApiTest;
import com.akanksha.automation.api.ApiClient;
import com.akanksha.automation.api.ApiEndpoints;
import com.akanksha.automation.api.ApiResponseSpec;
import com.akanksha.automation.pojo.CreatePostRequest;
import com.akanksha.automation.pojo.CreatePostResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest extends BaseApiTest {

    @Test
    public void verifyCreateUserApi() {

        CreatePostRequest request = new CreatePostRequest();

        request.setTitle("SDET Framework");

        request.setBody("Created using Rest Assured");

        request.setUserId(1);

        Response response = ApiClient.post(requestSpec, ApiEndpoints.POSTS, request);

        response.prettyPrint();

        //Deserialize Response
        CreatePostResponse responseBody = response.as(CreatePostResponse.class);
        response.then().spec(ApiResponseSpec.getSuccessResponseSpec(201));
        Assert.assertEquals(responseBody.getTitle(), "SDET Framework");
        Assert.assertEquals(responseBody.getUserId(), 1);

        System.out.println("Created Post ID : " + responseBody.getId());
    }
}
