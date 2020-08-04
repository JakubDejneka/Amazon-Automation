package E2EFrameworkSample.samplePOMProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import resources.Base;

import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class RestAssuredTest extends Base{
	
	public static Logger log = LogManager.getLogger(RestAssuredTest.class.getName());
	
	@Test
	public void simpleGet() {
		
		Response response = get("https://reqres.in/api/users?page=2");		
		
		System.out.println(response.getBody().asString());
		log.info("Response has been printed!");
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();		
		Assert.assertEquals(statusCode, 200);
										
	}
	
	@Test
	public void anotherGet() {
		
		//other get usage with help of static import
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.body("data.id[0]", equalTo(7))
			.statusCode(200);
	
	}

}
