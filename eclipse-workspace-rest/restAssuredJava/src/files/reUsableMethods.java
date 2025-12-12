package files;

import io.restassured.path.json.JsonPath;

public class reUsableMethods {
	
	public static JsonPath rawtoJson(String response) {
		JsonPath jsonResponse = new JsonPath(response);
		return jsonResponse;
	}

}
