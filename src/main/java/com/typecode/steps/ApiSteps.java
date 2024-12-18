package com.typecode.steps;

import io.restassured.specification.RequestSpecification;
import io.restassured.response.ValidatableResponse;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

import com.typecode.helpers.LoggerHelper;

public class ApiSteps {

    @Step("Создание нового поста")
    public static ValidatableResponse createPost(RequestSpecification spec, String body) {
        var response = given()
                .spec(spec)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        LoggerHelper.logResponse(response.extract().body().asString(), "Создан новый пост");
        return response;
    }

    @Step("Получение поста по ID: {0}")
    public static ValidatableResponse getPostById(RequestSpecification spec, int id) {
        var response = given()
                .spec(spec)
                .when()
                .get("/posts/" + id)
                .then()
                .statusCode(200);

        LoggerHelper.logResponse(response.extract().body().asString(), "Получен пост с ID: " + id);
        return response;
    }

    @Step("Обновление поста с ID: {0}")
    public static ValidatableResponse updatePost(RequestSpecification spec, int id, String body) {
        var response = given()
                .spec(spec)
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put("/posts/" + id)
                .then()
                .statusCode(200);

        LoggerHelper.logResponse(response.extract().body().asString(), "Обновлен пост с ID: " + id);
        return response;
    }

    @Step("Удаление поста с ID: {0}")
    public static ValidatableResponse deletePost(RequestSpecification spec, int id) {
        var response = given()
                .spec(spec)
                .when()
                .delete("/posts/" + id)
                .then()
                .statusCode(200);

        LoggerHelper.logResponse(response.extract().body().asString(), "Удален пост с ID: " + id);
        return response;
    }

    @Step("Получение всех постов в виде строки с логированием топ-10 слов")
    public static String getAllPostsBody(RequestSpecification spec) {
        var response = given()
                .spec(spec)
                .when()
                .get("/posts")
                .then()
                .statusCode(200);

        String responseBody = response.extract().body().asString();
        LoggerHelper.logResponse(responseBody, "Получены все посты (тело ответа как строка)");
        LoggerHelper.logTop10Words(responseBody, "Топ 10 слов в ответе");

        return responseBody;
    }
}
