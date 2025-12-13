package POJO;

import static io.restassured.RestAssured.given;

import files.SpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetPlaceRequest {

	public static void main(String[] args) {
		 System.out.println("Get place started...");
	
		 
		 String placeId = "2f51c26716cbf5b4b8b84f12893bcad0";
		 RequestSpecification request = given()
				 						.spec(SpecBuilder.buildRequestSpec(placeId));
		 
		 			Response response = request
				 						.when().get("/maps/api/place/get/json")
				 						.then().spec(SpecBuilder.buildResponseSpec())
				 						.extract().response();
		 
		 System.out.println(response.asPrettyString());
		 
		 GetPlaceResponse getPlaceResponse = response.as(GetPlaceResponse.class);
		 
		 System.out.println("Address : "+getPlaceResponse.getAddress());
		 
		 System.out.println("Get place finished...");
		 
		 
		 System.out.println("************************************************************");

	}

}
