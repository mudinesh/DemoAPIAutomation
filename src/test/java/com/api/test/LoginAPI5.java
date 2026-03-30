package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


@Listeners(com.api.listeners.TestListener.class)
public class LoginAPI5 {

	
	@Test(description = "Verify login")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("uday123", "uday123");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		System.out.println("ID = "+loginResponse.getId());
		
		Assert.assertEquals(loginResponse.getEmail(), "vicky@gmail.com");
		
	}
}
