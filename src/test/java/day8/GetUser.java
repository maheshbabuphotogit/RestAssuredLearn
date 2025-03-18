package day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

	
	@Test(priority=1)
	
	
	void getUser(ITestContext context) {
		String BearerToken = "74ec401457d0e2f5ef24188d54b7369b68a74f4b2a96c23c05e1f0b5098715aa";
		int id =(int) context.getAttribute("user_id");
		
		given()
		  .headers("Authorization","Bearer"+BearerToken)
		   .pathParam("id",id)
		
		.when()
		   .get("https://gorest.co.in/public/v2/users/{id}")
		   
		
		.then()
		   .statusCode(200)
		    .log().all();
	}    
}
