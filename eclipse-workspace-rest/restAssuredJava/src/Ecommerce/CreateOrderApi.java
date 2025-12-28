package Ecommerce;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import files.GlobalData;
import files.SpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateOrderApi {
	
	public static CreateOrderResponse createOrderResponse;
	public static void createOrder() {
		System.out.println("Create Order.................................");
		Orders orders = new Orders();
		orders.setCountry("India");
		orders.setProductOrderedId(GlobalData.productId);
		
		List<Orders> orderList = new ArrayList<Orders>();
		orderList.add(orders);
		
		CreateOrderRequest createOrderRequest = new CreateOrderRequest();
		createOrderRequest.setOrders(orderList);
		
		RequestSpecification createOrder = given()
											.log().all()
											.spec(SpecBuilder.authorizationSpec())
											.contentType(ContentType.JSON) 
											.body(createOrderRequest);
		
		Response response = createOrder
							.when().post("/api/ecom/order/create-order")
							.then().statusCode(201)
							.extract().response();
		
		System.out.println(response.asPrettyString());
		
		createOrderResponse = response.as(CreateOrderResponse.class);
		
		GlobalData.ordersId = createOrderResponse.getOrders();
		GlobalData.productOrderId = createOrderResponse.getProductOrderId();
		
		System.out.println(createOrderResponse.getMessage());
		
		System.out.println("Create Order completed.....................................");
		 
		System.out.println("************************************************************");
		
	}
}
