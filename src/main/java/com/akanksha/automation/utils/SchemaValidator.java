package com.akanksha.automation.utils;

import io.restassured.response.ValidatableResponse;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidator {

    public static void validateSchema(ValidatableResponse response, String schemaName) {

        response.body(matchesJsonSchemaInClasspath("schemas/" + schemaName));
    }
}
