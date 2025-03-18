package day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	@Test(priority=2)
	void updateuser(ITestContext context) {
		
		 Faker fake = new Faker();
		    JSONObject data = new JSONObject();

		    // ✅ Correct field names (case-sensitive!)
		    data.put("name", fake.name().firstName());
		    data.put("gender", "female");
		    data.put("email", fake.internet().emailAddress());
		    data.put("status", "active");

		    String BearerToken = "74ec401457d0e2f5ef24188d54b7369b68a74f4b2a96c23c05e1f0b5098715aa";

		    // ✅ Send request and extract id directly
		    int id =(int) context.getAttribute("user_id");
		        given()
		            .header("Authorization", "Bearer " + BearerToken)
		            .contentType("application/json")
		            .pathParam("id",id)
		            .body(data.toString())
		        .when()
		            .put("https://gorest.co.in/public/v2/users/{id}")
		        .then()
		            .log().all() // Log full response (for debugging)
		            .statusCode(200) // Validate successful creation
		            .extract()
		            .path("id"); // ✅ Direct extraction here

		    System.out.println("Generated ID is: " + id);
		
	}

}
