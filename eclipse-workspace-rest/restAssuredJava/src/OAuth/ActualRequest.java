package OAuth;

import io.restassured.RestAssured;

public class ActualRequest {
	public static void performActualRequest(String accessToken) {
		String response = RestAssured.given()
						  .queryParam("access_token", accessToken)
						  .when().get("https://rahulshettyacademy.com/getCourse.php")
						  .asPrettyString();
		System.out.println(response);
	}
}
