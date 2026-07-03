package reporting;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class ExtentApiFilter implements Filter {

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {

        // ===========================
        // REQUEST
        // ===========================

        ExtentLogger.info("======================================");
        ExtentLogger.info("API REQUEST");
        ExtentLogger.info("======================================");

        ExtentLogger.info("Method : " + requestSpec.getMethod());

        ExtentLogger.info("URI : " + requestSpec.getURI());

        if (!requestSpec.getHeaders().asList().isEmpty()) {

            StringBuilder headers = new StringBuilder();

            for (Header header : requestSpec.getHeaders()) {

                headers.append(header.getName())
                        .append(" : ")
                        .append(header.getValue())
                        .append("\n");
            }

            ExtentLogger.info(
                    "<details><summary><b>Headers</b></summary><pre>"
                            + headers
                            + "</pre></details>");
        }

        if (requestSpec.getBody() != null) {

            ExtentLogger.info(
                    "<details><summary><b>Request Body</b></summary><pre>"
                            + requestSpec.getBody()
                            + "</pre></details>");
        }

        long startTime = System.currentTimeMillis();

        Response response = ctx.next(requestSpec, responseSpec);

        long endTime = System.currentTimeMillis();

        // ===========================
        // RESPONSE
        // ===========================

        ExtentLogger.info(" ");

        ExtentLogger.info("======================================");
        ExtentLogger.info("API RESPONSE");
        ExtentLogger.info("======================================");

        ExtentLogger.info("Status Code : " + response.getStatusCode());

        ExtentLogger.info("Response Time : "
                + (endTime - startTime)
                + " ms");

        ExtentLogger.info(
                "<details><summary><b>Response Body</b></summary><pre>"
                        + response.asPrettyString()
                        + "</pre></details>");

        return response;
    }
}