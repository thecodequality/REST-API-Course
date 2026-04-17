import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class libraryExcel {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//1.Dynamically build JSON pay load with external data inputs
				RestAssured.baseURI = "https://rahulshettyacademy.com";
				
				
				ArrayList data=DataDriven.getExcelData("RestAssured", "RestAddBook");
				//HashMap
				Map<String, Object> jsonAsMap = new HashMap<>();
				jsonAsMap.put("name", data.get(1));
				jsonAsMap.put("isbn", data.get(2));
				jsonAsMap.put("aisle", data.get(3));
				jsonAsMap.put("author", data.get(4));
				
				
				//Add book
				String response = given().header("Content-Type","application/json")
								.body(jsonAsMap)
								.when().post("/Library/Addbook.php")
								.then().statusCode(200)
								.extract().response().asString();
				JsonPath addbook = reUsableMethods.rawtoJson(response);
				String bookId = addbook.getString("ID");
				System.out.println(response);
				System.out.println("Book ID created is : "+bookId);

	}

}
