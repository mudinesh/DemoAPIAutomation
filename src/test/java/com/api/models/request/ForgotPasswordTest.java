package com.api.models.request;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.test.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test
	public void forgotPasswordTest() {
		
		AuthService authService = new AuthService();
		
		Response respone = authService.forgotPassword("decikeh697@devlug.com");
		
		System.out.println(respone.asPrettyString());
		
		

}
	
}



