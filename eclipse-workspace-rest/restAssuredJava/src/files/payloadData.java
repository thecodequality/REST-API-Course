package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class payloadData {
	public static String uploadBody() {
		
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}";
	}
	
	public static String updatePayload() {
		return "{\r\n"
				+ "\"place_id\":\"bcc7df3f06f5f36cb39d56c8ce9ca4c2\",\r\n"
				+ "\"address\":\"70 winter walk, TSR\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}";
	}
	
	public static String courseDetails() {
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 910,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"courses\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		
	}
	
	public static String addBookPayload(String isbn, String aisle) {
		
		return "{\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foer\"\r\n"
				+ "}";
	}
	
	public static String deleteBookPayload(String ID) {
		return "{\r\n"
				+ "    \"ID\": \""+ID+"\"\r\n"
				+ "}";
		
	}
	
	public static String readFileFromJson(String filePath) throws IOException {
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}

	public static String JiraCreateIssuePayload() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static String graphQLQueryPayload(int locationId, int characterId, int episodeId) {
		return "{\"query\":\"query ($locationId: Int!, $characterId: Int!, $episodeId: Int!) {\\n  location(locationId: $locationId) {\\n    name\\n    type\\n    dimension\\n  }\\n  character(characterId: $characterId) {\\n    name\\n    type\\n    status\\n    species\\n    gender\\n    origin {\\n      id\\n      name\\n      type\\n      dimension\\n    }\\n    location {\\n      name\\n      type\\n      dimension\\n    }\\n    episodes {\\n      id\\n      name\\n      air_date\\n      episode\\n    }\\n  }\\n  episode(episodeId: $episodeId) {\\n    name\\n    air_date\\n  }\\n}\\n\",\"variables\":{\"locationId\":"+locationId+",\"characterId\":"+characterId+",\"episodeId\":"+episodeId+"}}";
	}
	
	public static String graphQLMutationPayload(String locationName, String characterName, String episodeName) {
		return "{\"query\":\"mutation ($locationName: String!, $characterName: String!, $episodeName: String!) {\\n  createLocation(location: {name: $locationName, type: \\\"SouthZone\\\", dimension: \\\"123\\\"}) {\\n    id\\n  }\\n  createCharacter(character: {name: $characterName, type: \\\"Main\\\", status: \\\"Alive\\\", species: \\\"Man\\\", gender: \\\"Male\\\", image: \\\"https://dummyimage.com/200\\\", originId: 28527, locationId: 28527}) {\\n    id\\n  }\\n  createEpisode(episode: {name: $episodeName, air_date: \\\"12-12-2022\\\", episode: \\\"12\\\"}) {\\n    id\\n  }\\n}\\n\",\"variables\":{\"locationName\":\""+locationName+"\",\"characterName\":\""+characterName+"\",\"episodeName\":\""+episodeName+"\"}}";
	}

}
