package com.api.test;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class LoginAPI3 {

    @Test(description ="Verify login works")
    public void loginTest() {

        RestAssured.baseURI = "http://64.227.160.186:8080";

        RestAssured
        .given()
            .header("Content-Type","application/json")
            .body("{\n" +
                    "  \"username\": \"uday123\",\n" +
                    "  \"password\": \"uday123\"\n" +
                    "}")
        .when()
            .post("/api/auth/login")
        .then()
            .log().all();

    }
}