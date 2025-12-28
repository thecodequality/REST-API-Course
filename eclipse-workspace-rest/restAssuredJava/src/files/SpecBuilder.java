package files;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	
	public static RequestSpecification buildRequestSpec(String placeId) {
	    return new RequestSpecBuilder()
	            .setBaseUri("https://rahulshettyacademy.com")
	            .addQueryParam("key", "qaclick123")
	            .addQueryParam("place_id", placeId)
	            .setContentType(ContentType.JSON)
	            .build();
	}

	
	public static ResponseSpecification buildResponseSpec() {
		return new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
	}
	
	public static RequestSpecification loginRequestSpec() {
		return new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON)
				.build();
	}
	
	public static RequestSpecification authorizationSpec() {
		return new RequestSpecBuilder()
				.setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", GlobalData.authorizationToken)
				.build();
	}
}
