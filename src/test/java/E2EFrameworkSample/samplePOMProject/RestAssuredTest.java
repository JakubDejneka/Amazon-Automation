package E2EFrameworkSample.samplePOMProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import resources.Base;

import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class RestAssuredTest extends Base{
	
	public static Logger log = LogManager.getLogger(RestAssuredTest.class.getName());
	
	//@Test
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
	
	//@Test
	public void anotherGet() {
		
		//other get usage with help of static import
		given()
			.header("Content-type", "application/json")
			.get("https://reqres.in/api/users?page=2")			
		.then()
			.body("data.id[0]", equalTo(7))
			.body("data.first_name", hasItems("Michael", "Lindsay"))
			.statusCode(200);
	
	}
	
	//@Test
	public void examplePostUsingJsonSimpleLibrary() {
				
		
		//Usage of HashMap or json simple library below		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Jakub");
//		map.put("job", "Software Tester");
//		map.toString();		
//		System.out.println(map);		
//		JSONObject request = new JSONObject(map);
//		System.out.println(request.toJSONString());		
		
		JSONObject request2 = new JSONObject();			
		request2.put("name", "Jakub");
		request2.put("job", "Software Tester");
		System.out.println(request2.toJSONString());		
		
		given().
		header("Content-type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
			body(request2.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
		statusCode(201).log().all();		
				
	}
	
	
	//@Test
	public void examplePutRequest() {

		
		JSONObject request2 = new JSONObject();			
		request2.put("name", "Jakub");
		request2.put("job", "Software Tester");
		
		System.out.println(request2.toJSONString());		
		
		given().
		header("Content-type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
			body(request2.toJSONString()).
		when().
			put("https://reqres.in/api/users2").
		then().
		statusCode(200).log().all();		
				
	}

	
	//@Test
	public void examplePatchRequest() {
		
		JSONObject request2 = new JSONObject();			
		request2.put("name", "Jakub");
		request2.put("job", "Software Tester");
		
		System.out.println(request2.toJSONString());		
		
		given().
		header("Content-type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
			body(request2.toJSONString()).
		when().
			patch("https://reqres.in/api/users2").  
		then().
		statusCode(200).log().all();		
				
	}
	
	
	//@Test
		public void exampleDeleteRequest() {

			
			when().
				delete("https://reqres.in/api/users2").
			then().
				statusCode(204).log().all();		
					
		}
		
		
}
