import org.testng.Assert;

import files.payloadData;
import files.reUsableMethods;
import io.restassured.path.json.JsonPath;

public class complexJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		JsonPath courseDetails = reUsableMethods.rawtoJson(payloadData.courseDetails());
		
		//1. Print No of courses returned by API
		//Note: courses.size() method will only on arrays
		int count = courseDetails.getInt("courses.size()");
		System.out.println("Number of courses : "+count);
		
		
		//2.Print Purchase Amount
		System.out.println("Purchase amount : "+courseDetails.getInt("dashboard.purchaseAmount"));
		
		//3. Print Title of the first course
		//Note: get() method used to retrieve the string
		System.out.println("Title of 1st course : "+courseDetails.get("courses[0].title"));
		
		//4. Print All course titles and their respective Prices
		
		for(int index = 0; index < count; index++) {
			System.out.println("Price of course "+courseDetails.get("courses["+index+"].title")+" is -> "+courseDetails.getInt("courses["+index+"].price"));
		}
		
		//5. Print no of copies sold by RPA Course
		for(int index = 0; index < count; index++) {
			if(courseDetails.get("courses["+index+"].title").equals("RPA")) {
				System.out.println("Number of copies sold for course "+courseDetails.get("courses["+index+"].title")+" is : "+courseDetails.getInt("courses["+index+"].copies"));
				break;
			}
			String title = courseDetails.get("courses["+index+"].title");
			if(title.equalsIgnoreCase("RPA")) {
				System.out.println("Number of copies sold for course "+courseDetails.get("courses["+index+"].title")+" is : "+courseDetails.getInt("courses["+index+"].copies"));
				break;
			}
		}
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		int totalAmount = 0;
		for(int index = 0; index < count; index++) {
			
			totalAmount = totalAmount + (courseDetails.getInt("courses["+index+"].price") * courseDetails.getInt("courses["+index+"].copies"));
		}
		System.out.println("Actual total amount : "+totalAmount);
		Assert.assertEquals(totalAmount, courseDetails.getInt("dashboard.purchaseAmount"));
		
		
	}

}
