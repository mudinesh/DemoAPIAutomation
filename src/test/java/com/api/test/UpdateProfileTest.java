package com.api.test;

import org.testng.annotations.Test;

import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test
	public void updateProfileTest() {
	AuthService authService = new AuthService();
	
	Response response = authService.login(new LoginRequest("tamil123", "tamil123"));
	LoginResponse loginResponse = response.as(LoginResponse.class);
	
	System.out.println(loginResponse.getToken());	
	
	UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
	ProfileRequest profileRequest = new ProfileRequest.Builder()
			.firstName("MrTamilan")
			.lastName("M")
			.email("MrTamil@abq.com")
			.mobileNumber("1122334455")
			.build();
	response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
	System.out.println(response.asPrettyString());
	}

}
