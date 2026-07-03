package reporting;

import io.restassured.response.Response;

public class ApiReportLogger {

    public static void logGet(String endpoint, Response response) {

        ExtentLogger.info("========================================");
        ExtentLogger.info("API REQUEST");
        ExtentLogger.info("========================================");

        ExtentLogger.info("HTTP Method : GET");
        ExtentLogger.info("Endpoint    : " + endpoint);

        ExtentLogger.info(" ");

        ExtentLogger.info("========================================");
        ExtentLogger.info("API RESPONSE");
        ExtentLogger.info("========================================");

        ExtentLogger.info("Status Code  : " + response.getStatusCode());
        ExtentLogger.info("Response Time: " + response.getTime() + " ms");

        ExtentLogger.info("<details><summary><b>Response Body</b></summary><pre>"
                + response.asPrettyString()
                + "</pre></details>");
    }

    public static void logPost(String endpoint, Object requestBody, Response response) {

        ExtentLogger.info("========================================");
        ExtentLogger.info("API REQUEST");
        ExtentLogger.info("========================================");

        ExtentLogger.info("HTTP Method : POST");
        ExtentLogger.info("Endpoint    : " + endpoint);

        ExtentLogger.info("<details><summary><b>Request Body</b></summary><pre>"
                + requestBody
                + "</pre></details>");

        ExtentLogger.info(" ");

        ExtentLogger.info("========================================");
        ExtentLogger.info("API RESPONSE");
        ExtentLogger.info("========================================");

        ExtentLogger.info("Status Code  : " + response.getStatusCode());
        ExtentLogger.info("Response Time: " + response.getTime() + " ms");

        ExtentLogger.info("<details><summary><b>Response Body</b></summary><pre>"
                + response.asPrettyString()
                + "</pre></details>");
    }

    public static void logDelete(String endpoint, Response response) {

        ExtentLogger.info("========================================");
        ExtentLogger.info("API REQUEST");
        ExtentLogger.info("========================================");

        ExtentLogger.info("HTTP Method : DELETE");
        ExtentLogger.info("Endpoint    : " + endpoint);

        ExtentLogger.info(" ");

        ExtentLogger.info("========================================");
        ExtentLogger.info("API RESPONSE");
        ExtentLogger.info("========================================");

        ExtentLogger.info("Status Code  : " + response.getStatusCode());
        ExtentLogger.info("Response Time: " + response.getTime() + " ms");
    }
}