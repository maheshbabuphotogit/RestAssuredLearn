package day4;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class JSONResponseDataValidation {
	
	
	@Test(enabled=false)
	void JSONData() {
		
		Response response = given()
		
		  .contentType(ContentType.JSON)

		
		.when()
		   .get("http://localhost:3000/people");
		
		   System.out.println(response.getBody().asString());
		   
		   response.then()
		   .statusCode(200)
		    .header("Content-Type","application/json; charset=utf-8")
		    .body("x[1].gender",equalTo("male"));
		    
		
	}
	
	
	
	void testJSONBody2() {
		
		
		
		Response res = given()
		
		  .contentType(ContentType.JSON)
		
		.when()
		  .get("http://localhost:3000/people");
		
		JSONObject js = new JSONObject(res.asString());
		
		
	}

}
