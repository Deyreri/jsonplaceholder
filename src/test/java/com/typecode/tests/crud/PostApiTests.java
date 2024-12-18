package com.typecode.tests.crud;

import com.typecode.data.ExpectedData;
import com.typecode.data.TestData;
import com.typecode.helpers.Assertions;
import com.typecode.steps.ApiSteps;
import com.typecode.tests.BaseApiTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class PostApiTests extends BaseApiTest {

    @Test
    @Description("Создание нового поста с валидными данными")
    public void testCreatePost() {
        var response = ApiSteps.createPost(spec, TestData.CREATE_POST_BODY);
        Assertions.assertResponseBody(response, ExpectedData.POST_TITLE, ExpectedData.POST_BODY, ExpectedData.POST_USER_ID);
    }

    @Test
    @Description("Получение существующего поста по ID")
    public void testGetPostById() {
        var response = ApiSteps.getPostById(spec, ExpectedData.POST_ID);
        Assertions.assertResponseId(response, ExpectedData.POST_ID);
    }

    @Test
    @Description("Обновление существующего поста")
    public void testUpdatePost() {
        var response = ApiSteps.updatePost(spec, ExpectedData.POST_ID, TestData.UPDATE_POST_BODY);
        Assertions.assertUpdatedResponse(response, ExpectedData.UPDATED_POST_TITLE, ExpectedData.UPDATED_POST_BODY);
    }

    @Test
    @Description("Удаление поста по ID")
    public void testDeletePost() {
        ApiSteps.deletePost(spec, ExpectedData.POST_ID);
    }
}
