package Ecommerce;

import static io.restassured.RestAssured.given;

import files.GlobalData;
import files.SpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteOrderApi {
	public static DeleteOrderResponse deleteOrderResponse;
	public static void deleteOrder() {
		int size = GlobalData.productOrderId.size();
		System.out.println("Delete Order...........................................");
		if(size != 0) {
			for(String productOrderId : GlobalData.ordersId) {
				orderDelete(productOrderId);
			}
		}
		System.out.println("Delete Order completed.....................................");
		 
		System.out.println("************************************************************");
	}
	
	public static void orderDelete(String productOrderId) {
		RequestSpecification deleteOrderRequest = given()
				.spec(SpecBuilder.authorizationSpec())
				.log().all()
				.pathParam("productOrderId", productOrderId);
		
		Response response = deleteOrderRequest
							.when().delete("/api/ecom/order/delete-order/{productOrderId}")
							.then().statusCode(200)
							.extract().response();
		System.out.println(response.asPrettyString());
		
		deleteOrderResponse = response.as(DeleteOrderResponse.class);
		
		System.out.println(deleteOrderResponse.getMessage());
		
	}
}
