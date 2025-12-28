package Ecommerce;

import static io.restassured.RestAssured.given;

import files.GlobalData;
import files.SpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginApi {
	public static LoginResponse loginResponse;
	
	public static void performLogin() {
		
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail(GlobalData.userEmail);
		loginRequest.setUserPassword(GlobalData.userPassword);
		
		 System.out.println("Login...............................");
		RequestSpecification requestLogin = given()
											.relaxedHTTPSValidation()
											.log().all()
											.spec(SpecBuilder.loginRequestSpec())
											.body(loginRequest);
		
		Response response = requestLogin
							.when().post("/api/ecom/auth/login")
							.then().spec(SpecBuilder.buildResponseSpec())
							.extract().response();
		
		System.out.println(response.asPrettyString());
		
		loginResponse = response.as(LoginResponse.class);
		
		GlobalData.authorizationToken = loginResponse.getToken();
		GlobalData.userId = loginResponse.getUserId();
		
		System.out.println(loginResponse.getMessage());
		
		System.out.println("Login completed.....................................");
		 
		System.out.println("************************************************************");
	}
}
