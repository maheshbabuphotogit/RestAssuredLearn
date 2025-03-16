package day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;

public class FileUplaodandDownload {
	
	
	void uploadSingle() {
		
		File f1 = new File("");
		File f2 = new File("");
		
		File Farray[]= {f1,f2};
		
		given()
		   .multiPart("Files",Farray)
		   .contentType("multipart/form-data")
		   
		.when()
		
		   .post("")
		.then()
		   .statusCode(200)
		    .body("",equalTo("txt"))
		    .log().all();
		
	}       
}
