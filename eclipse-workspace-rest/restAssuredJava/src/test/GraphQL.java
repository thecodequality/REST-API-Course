package test;

import static io.restassured.RestAssured.given;

import files.payloadData;
import io.restassured.path.json.JsonPath;

public class GraphQL {
	public static void main(String[] args) {
		//Mutation
		String locationName = "Japan";
		String characterName = "Bruno";
		String episodeName = "One Last Time";
		
		String mutationResponse = given()
				.log().all()
				.header("Content-Type", "application/json")
				.body(payloadData.graphQLMutationPayload(locationName, characterName, episodeName))
				.when().post("https://rahulshettyacademy.com/gq/graphql")
				.then().extract().response().asPrettyString();
		
		JsonPath jsMutation = new JsonPath(mutationResponse);
		int locationId = jsMutation.getInt("data.createLocation.id");
		int characterId = jsMutation.getInt("data.createCharacter.id");
		int episodeId = jsMutation.getInt("data.createEpisode.id");
		
		//Query
		
		String queryResponse = given()
							.log().all()
							.header("Content-Type", "application/json")
							.body(payloadData.graphQLQueryPayload(locationId,characterId,episodeId))
							.when().post("https://rahulshettyacademy.com/gq/graphql")
							.then().extract().response().asPrettyString();
		
		System.out.println(queryResponse);
		
		JsonPath js =new JsonPath(queryResponse);
		String name = js.get("data.location.name");
		System.out.println(name);
	}

}
