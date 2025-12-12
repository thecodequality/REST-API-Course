package test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ClientCredentialsOAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Base URI
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String accessTokenResponse = given()
									 .formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
									 .formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
									 .formParam("grant_type", "client_credentials")
									 .formParam("scope", "trust")
									 .when().post("/oauthapi/oauth2/resourceOwner/token")
									 .then().log().all()
									 .extract().response().asPrettyString();
		
		JsonPath accessTokeResponse = new JsonPath(accessTokenResponse);
		String accessToken = accessTokeResponse.getString("access_token");
		System.out.println("Access Token : "+accessToken);
		
		String courseDetailsResponse = given()
									   .queryParam("access_token",accessToken)
									   .when().get("/oauthapi/getCourseDetails")
									   .then().log().all()
									   .extract().response().asPrettyString();
		
	    System.out.println(courseDetailsResponse);  
		
	}

}
