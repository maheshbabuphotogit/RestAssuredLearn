package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class CookiesAndHeader {
	
	@Test
	void cookiesAndHeader(){
		
		Response res =given()
		
		
		.when()

		.get("https://reqres.in/api/users?page=2&id=5");
		
//		String cook= res.getCookie("AEC");
//		System.out.println("value of cookie" + cook);
		
		Map<String,String> allCookies = res.getCookies();
		
		for (String K : allCookies.keySet()) {
			String allCookie =res.getCookie(K);
			System.out.println(K+"       " +allCookie);
			
		}

		
		
		
		
		
	}

}
