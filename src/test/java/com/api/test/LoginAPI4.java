package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPI4 {

	@Test(description ="Verify login works")
	public void loginTest() {
		
		
		Response response = given()
				.baseUri("http://64.227.160.186:8080")
				.header("Content-Type","application/json")
				.body("{\r\n" + " \"username\": \"uday123\",\r\n" + " \"password\": \"uday123\"\r\n" + "}")
				.post("/api/auth/login"); 
		        System.out.println(response.asPrettyString()); 
				
				Assert.assertEquals(response.getStatusCode(), 200);

	}
}
