package com.typecode.data;

public class TestData {
    public static final String CREATE_POST_BODY = """
            {
                "title": "Test Title",
                "body": "Test Body",
                "userId": 1
            }
            """;

    public static final String UPDATE_POST_BODY = """
            {
                "id": 1,
                "title": "Updated Title",
                "body": "Updated Body",
                "userId": 1
            }
            """;
}
