package com.typecode.specifications;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Specifications {

    private static final AllureRestAssured FILTER = new AllureRestAssured()
            .setRequestTemplate("request.ftl")
            .setResponseTemplate("response.ftl");

    public static RequestSpecification requestSpecification(String baseUrl) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType("application/json")
                .addFilter(FILTER)
                .build();
    }
}
