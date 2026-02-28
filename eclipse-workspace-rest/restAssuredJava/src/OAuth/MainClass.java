package OAuth;

public class MainClass {
	static String url = "https://rahulshettyacademy.com/getCourse.php?iss=https%3A%2F%2Faccounts.google.com&code=4%2F0AfrIepBdeVvFzwocXDlgW1wsfKgI61Zwbox3s4OBpDeYGcThLudY-HqjTazbbgO0RZuPXg&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";
	public static void main(String[] args) {
		String code = AccessToken.getCode(url);
		System.out.println(code);
		String accessToken = AccessToken.getAccessToken(code);
		System.out.println("Is: "+accessToken);
		ActualRequest.performActualRequest(accessToken);
	}
}
