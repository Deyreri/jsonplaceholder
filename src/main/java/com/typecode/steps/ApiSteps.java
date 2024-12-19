package com.typecode.steps;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.qameta.allure.Step;

import static io.restassured.RestAssured.given;

import com.typecode.data.PostDto;
import com.typecode.helpers.LoggerHelper;

public class ApiSteps {

    @Step("Создание нового поста: {post.title}")
    public static ValidatableResponse createPost(RequestSpecification spec, PostDto post) {
        var response = given()
                .spec(spec)
                .header("Content-Type", "application/json")
                .body(post)
                .when()
                .post("/posts")
                .then()
                .statusCode(201);

        LoggerHelper.logResponse(response.extract().body().asString(), "Создан новый пост: " + post.getTitle());
        return response;
    }

    @Step("Получение поста по ID: {id}")
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

    @Step("Обновление поста с ID: {id}, заголовок: {post.title}")
    public static ValidatableResponse updatePost(RequestSpecification spec, int id, PostDto post) {
        var response = given()
                .spec(spec)
                .header("Content-Type", "application/json")
                .body(post)
                .when()
                .put("/posts/" + id)
                .then()
                .statusCode(200);

        LoggerHelper.logResponse(response.extract().body().asString(), "Обновлен пост с ID: " + id + ", заголовок: " + post.getTitle());
        return response;
    }

    @Step("Удаление поста с ID: {id}")
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

    @Step("Получение всех постов")
    public static String getAllPostsBody(RequestSpecification spec) {
        var response = given()
                .spec(spec)
                .when()
                .get("/posts")
                .then()
                .statusCode(200);

        String responseBody = response.extract().body().asString();
        LoggerHelper.logResponse(responseBody, "Получены все посты");
        LoggerHelper.logTop10Words(responseBody, "Топ 10 слов в ответе");

        return responseBody;
    }
}
