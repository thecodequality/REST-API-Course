package test;

import static io.restassured.RestAssured.given;

import java.io.File;

import files.payloadData;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class JiraCreateIssueApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Base URI
		RestAssured.baseURI = "https://jarvisonboard136.atlassian.net";
		
		//Create an issue
		String createIssueResponse = given()
				.header("Content-Type", "application/json")
				.header("Authorization", "Basic amFydmlzb25ib2FyZDEzNkBnbWFpbC5jb206QVRBVFQzeEZmR0YwTXNTYUpxNzRqN0tRR2lIVERjRHRvTXdZQ0tTQVVJdlZESWhTOW5VNEs5X05KTGVSbVlkMTlJUDcxRjc5ZHY0SUVYamZvb1dJV3UzUk4tT1dLMHYybnJzMkJZOGw5eEl3ZEFyWENob2hLZnlXMmJ6VUJJb0tpTFVYX01WRm1YRmFxZkYxNVJEcURQUERBdDNrQlJfTUh1d3lONEx4M3pNZVkwQVF6QlVONXdZPTVGNDg1MDVC")
				.body(payloadData.JiraCreateIssuePayload())
				.when().post("/rest/api/3/issue")
				.then().log().all()
				.statusCode(201)
				.extract().response().asString();
		
		JsonPath createIssue= new JsonPath(createIssueResponse);
		String issueId = createIssue.getString("id");
		System.out.println("Issue ID : "+issueId);
		
		String addAttachmentResponse = given().pathParam("issueId", issueId)
				.header("X-Atlassian-Token", "no-check")
				.header("Authorization", "Basic amFydmlzb25ib2FyZDEzNkBnbWFpbC5jb206QVRBVFQzeEZmR0YwTXNTYUpxNzRqN0tRR2lIVERjRHRvTXdZQ0tTQVVJdlZESWhTOW5VNEs5X05KTGVSbVlkMTlJUDcxRjc5ZHY0SUVYamZvb1dJV3UzUk4tT1dLMHYybnJzMkJZOGw5eEl3ZEFyWENob2hLZnlXMmJ6VUJJb0tpTFVYX01WRm1YRmFxZkYxNVJEcURQUERBdDNrQlJfTUh1d3lONEx4M3pNZVkwQVF6QlVONXdZPTVGNDg1MDVC")
				.multiPart("file", new File("C:/Users/Administrator/Downloads/pngegg (2).png"))
				.when().post("/rest/api/3/issue/{issueId}/attachments")
				.then().log().all()
				.statusCode(200)
				.extract().response().asString();
		
		JsonPath addAttachment = new JsonPath(addAttachmentResponse);
		String fileName = addAttachment.getString("filename");
		System.out.println("File Name  : "+fileName);

	}

}
