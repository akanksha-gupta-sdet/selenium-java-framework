package com.akanksha.automation.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {

    public static Response get(RequestSpecification requestSpec, String endpoint) {

        return RestAssured
                .given(requestSpec)
                .when()
                .get(endpoint);
    }

    public static Response delete(RequestSpecification requestSpec, String endpoint) {

        return RestAssured
                .given(requestSpec)
                .when()
                .delete(endpoint);
    }

    public static Response post(RequestSpecification requestSpec, String endpoint, Object requestBody) {

        return RestAssured
                .given(requestSpec)
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    public static Response put(RequestSpecification requestSpec, String endpoint, Object requestBody) {

        return RestAssured
                .given(requestSpec)
                .body(requestBody)
                .when()
                .put(endpoint);
    }
}