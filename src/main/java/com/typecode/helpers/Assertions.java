package com.typecode.helpers;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;

public class Assertions {

    @Step("Проверка тела ответа")
    public static void assertResponseBody(ValidatableResponse response, String title, String body, int userId) {
        response.body("title", equalTo(title))
                .body("body", equalTo(body))
                .body("userId", equalTo(userId));
    }

    @Step("Проверка ID в теле ответа")
    public static void assertResponseId(ValidatableResponse response, int expectedId) {
        response.body("id", equalTo(expectedId));
    }

    @Step("Проверка обновленного тела ответа")
    public static void assertUpdatedResponse(ValidatableResponse response, String title, String body) {
        response.body("title", equalTo(title))
                .body("body", equalTo(body));
    }
}
