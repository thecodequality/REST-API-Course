package test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.RandomValues;
import files.payloadData;
import files.reUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class libraryApi {
	
	@Test(dataProvider = "BookData")
	public void addBook(String isbn, String aisle) {
		//1.Dynamically build JSON pay load with external data inputs
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		//Add book
		String response = given().header("Content-Type","text/plain")
						.body(payloadData.addBookPayload(isbn,aisle))
						.when().post("/Library/Addbook.php")
						.then().statusCode(200)
						.extract().response().asString();
		JsonPath addbook = reUsableMethods.rawtoJson(response);
		String bookId = addbook.getString("ID");
		System.out.println("Book ID created is : "+bookId);
		
		
		//Delete book
		String deleteBook = given().header("Content-Type","text/plain")
						.body(payloadData.deleteBookPayload(bookId))
						.when().delete("/Library/DeleteBook.php")
						.then().statusCode(200)
						.extract().response().asString();
		JsonPath deletebook = reUsableMethods.rawtoJson(deleteBook);
		System.out.println(deletebook.getString("msg")+" for book with ID : "+bookId);
	}
	
	@DataProvider(name = "BookData")
	public Object[][] dataSet() {
		//array = collection of elements
		//multidimensional array = collection of arrays
		
		return new Object[][] {{RandomValues.generateRandomString(3),RandomValues.generateRandomNumber(4)}, 
			{RandomValues.generateRandomString(3),RandomValues.generateRandomNumber(4)},
			{RandomValues.generateRandomString(3),RandomValues.generateRandomNumber(4)}};
	}
	
}
