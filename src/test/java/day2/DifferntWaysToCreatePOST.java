package day2;

import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
//1.Hashmap
//2.org.json
//3.POJO Class
//4.External Json File




public class DifferntWaysToCreatePOST {
	
	@Test
	void testPostUsingHash() {
		
		HashMap data = new HashMap();
		
		data.put("Name", "Scott");
		data.put("Location", "France");
		data.put("Phone", "5566999");
		
		String courseArr[]= {"Java","C++"};
		
		data.put("Course", courseArr);
		
		
		
		
		given()
		  .contentType("application/json")
		  .body(data)
		
		.when()
		  .post("http://localhost:3000/students")
		
		
		.then()
		.statusCode(201)
		.body("Name", equalTo("Scott"))
		.body("Location", equalTo("France"))
		.body("Phone", equalTo("123456"))
		.body("Courses", equalTo("Java"))
		.body("Courses", equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
		
	}
	 
	void testPostUsingJsonORG() {
		
        JSONObject data2 = new JSONObject();	
        data2.put("Name", "Scott");
		data2.put("Location", "France");
		data2.put("Phone", "5566999");
		
		String courseArr[]= {"Java","C++"};
		
		data2.put("Course", courseArr);
		
		given()
		  .contentType("application/json")
		  .body(data2)
		
		.when()
		  .post("http://localhost:3000/students")
		
		
		.then()
		.statusCode(201)
		.body("Name", equalTo("Scott"))
		.body("Location", equalTo("France"))
		.body("Phone", equalTo("123456"))
		.body("Courses", equalTo("Java"))
		.body("Courses", equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
		
	}
	
	
	
	
	
	
	

}
