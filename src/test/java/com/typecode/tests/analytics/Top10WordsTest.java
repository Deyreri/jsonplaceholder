package com.typecode.tests.analytics;

import com.typecode.helpers.PostWordFrequencyHelper;
import com.typecode.steps.ApiSteps;
import com.typecode.tests.BaseApiTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;


public class Top10WordsTest extends BaseApiTest {

    @Test
    @Description("Анализ топ 10 слов в теле постов")
    public void testTop10MostFrequentWords() {
        var responseBody = ApiSteps.getAllPostsBody(spec);

        PostWordFrequencyHelper.getTop10Words(responseBody);
    }
}