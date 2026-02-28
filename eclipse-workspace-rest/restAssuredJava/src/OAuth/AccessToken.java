package OAuth;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AccessToken {
	static String clientId = "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com";
	static String clientSecretId = "erZOWM9g3UtwNRj340YYaK_W";
	static String redirectUri = "https://rahulshettyacademy.com/getCourse.php";
	public static String getAccessToken(String code) {
		String accessTokenResponse = RestAssured.given()
									.urlEncodingEnabled(false)
									.queryParam("code", code)
									.queryParam("client_id", clientId)
									.queryParam("client_secret", clientSecretId)
									.queryParam("redirect_uri", redirectUri)
									.queryParam("grant_type", "authorization_code")
									.when().log().all()
									.post("https://www.googleapis.com/oauth2/v4/token")
									.asPrettyString();
		System.out.println(accessTokenResponse);
		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		return accessToken;
		
	}
	
	public static String getCode(String url) {
		String code = url.split("code=")[1].split("&")[0];
		return code;
		
	}
}
