package com.typecode.tests;

import com.typecode.specifications.Specifications;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    protected static RequestSpecification spec;

    @BeforeAll
    public static void setup() {
        spec = Specifications.requestSpecification("https://jsonplaceholder.typicode.com");
    }
}
