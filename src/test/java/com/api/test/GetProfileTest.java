package com.api.test;

import org.testng.annotations.Test;

import com.api.base.BaseService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileRespone;

import io.restassured.response.Response;

public class GetProfileTest {

	
	@Test
	public void getProfileTest() {
		
		AuthService authService = new AuthService();
		
		Response response = authService.login(new LoginRequest("tamil123", "tamil123"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		
		
		
		
	 UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
	  response =  userProfileManagementService.getProfile(loginResponse.getToken());
	  System.out.println(response.asPrettyString());
	  
	 UserProfileRespone profileRespone = response.as(UserProfileRespone.class);
	 String email = profileRespone.getEmail();
	 
	 System.out.println("your email id is "+email);
	}
}
