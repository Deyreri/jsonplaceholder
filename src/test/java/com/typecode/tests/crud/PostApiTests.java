package com.typecode.tests.crud;

import com.typecode.data.TestData;
import com.typecode.helpers.Assertions;
import com.typecode.steps.ApiSteps;
import com.typecode.tests.BaseApiTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class PostApiTests extends BaseApiTest {

    private final int postId = TestData.POST_ID;

    @Test
    @Description("Создание нового поста с валидными данными")
    public void testCreatePost() {
        var response = ApiSteps.createPost(spec, TestData.CREATE_POST);
        Assertions.assertResponseBody(response, TestData.CREATE_POST.getTitle(), TestData.CREATE_POST.getBody(), TestData.CREATE_POST.getUserId());
    }

    @Test
    @Description("Получение существующего поста по ID")
    public void testGetPostById() {
        var response = ApiSteps.getPostById(spec, postId);
        Assertions.assertResponseId(response, postId);
    }

    @Test
    @Description("Обновление существующего поста")
    public void testUpdatePost() {
        var response = ApiSteps.updatePost(spec, postId, TestData.UPDATE_POST);
        Assertions.assertUpdatedResponse(response, TestData.UPDATE_POST.getTitle(), TestData.UPDATE_POST.getBody());
    }

    @Test
    @Description("Удаление поста по ID")
    public void testDeletePost() {
        ApiSteps.deletePost(spec, postId);
    }
}
