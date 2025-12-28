package Ecommerce;

import static io.restassured.RestAssured.given;

import files.GlobalData;
import files.SpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteProduct {
	public static DeleteOrderResponse deleteOrderResponse;
	public static void deleteProduct() {
		
		System.out.println("Delete Product ...............................................");
		RequestSpecification deleteProductRequest = given()
													.spec(SpecBuilder.authorizationSpec())
													.log().all()
													.pathParam("productId", GlobalData.productId);
		
		Response response = deleteProductRequest
							.when().delete("/api/ecom/product/delete-product/{productId}")
							.then().statusCode(200)
							.extract().response();
		
		System.out.println(response.asPrettyString());
		
		deleteOrderResponse = response.as(DeleteOrderResponse.class);
		
		System.out.println(deleteOrderResponse.getMessage());
		
		System.out.println("Delete Product completed.....................................");
		 
		System.out.println("************************************************************");
	}
}
