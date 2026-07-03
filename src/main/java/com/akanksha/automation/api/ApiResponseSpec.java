package com.akanksha.automation.api;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class ApiResponseSpec {

    public static ResponseSpecification getSuccessResponseSpec(int statusCode) {

        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(50000L))
                .build();
    }

}