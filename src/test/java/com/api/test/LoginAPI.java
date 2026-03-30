package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPI {

	@Test(description ="Verify login works")
	public void loginTest() {
		
		RestAssured.baseURI = "http://64.227.160.186:8080";
		
		RequestSpecification rs = RestAssured.given();
		RequestSpecification y = rs.header("Content-Type","application/json");
		
		RequestSpecification z = y.body("{\r\n"
				+ "  \"username\": \"uday123\",\r\n"
				+ "  \"password\": \"uday123\"\r\n"
				+ "}");
		
		Response response = z.post("/api/auth/login");
		
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 201);
	}
}
