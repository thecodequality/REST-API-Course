package Ecommerce;

import static io.restassured.RestAssured.given;

import java.io.File;

import files.GlobalData;
import files.SpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddProductApi {
	
	public static AddProductResponse addProductResponse;
	
	public static void addProduct() {
		System.out.println("Add Product...............................");
		
		RequestSpecification addProductRequest = given()
												 .log().all()
												 .spec(SpecBuilder.authorizationSpec())
												 .param("productName", "Laptop")
												 .param("productAddedBy", GlobalData.userId)
												 .param("productCategory", "fashion")
												 .param("productSubCategory", "shirts")
												 .param("productPrice", "11500")
												 .param("productDescription", "Lenova")
												 .param("productFor", "men")
												 .multiPart("productImage", new File("C://Users\\Administrator//Downloads//Lucid_Origin_A_cute_intelligent_cat_mascot_named_CodeCat_sitti_1.jpg"));
		
		Response response = addProductRequest
							.when().post("/api/ecom/product/add-product")
							.then().statusCode(201)
							.extract().response();
		
		System.out.println(response.asPrettyString());
		
		addProductResponse = response.as(AddProductResponse.class);
		
		GlobalData.productId = addProductResponse.getProductId();
		
		System.out.println(addProductResponse.getMessage());
		
		System.out.println("Add Product completed.....................................");
		 
		System.out.println("************************************************************");
	}

}
