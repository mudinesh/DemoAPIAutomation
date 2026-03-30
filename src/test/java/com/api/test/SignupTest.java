package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;

public class SignupTest {
	
	@Test
	public void signupTest() {
		//Builder design patter - when we have more parameters in constructor, we will 
		//use this, improve readability, avoids parameter confusion
		SignupRequest req = new SignupRequest.Builder()
		        .username("DevTester")
		        .password("passw!1331")
		        .email("decikeh697@devlug.com")
		        .firstName("DevTest")
		        .lastName("M")
		        .mobileNumber("1986754123")
		        .build();
		
		//SignupRequest signupRequest = new SignupRequest("dnze11", "pass1231145", "dqqnz@gml.com", "dn1ze", "oke", "9876543213");
		AuthService authService = new AuthService();
		
		Response respone = authService.signup(req);
		
		System.out.println(respone.asPrettyString());
		
		Assert.assertEquals(respone.statusCode(), 200);

}
	
}
