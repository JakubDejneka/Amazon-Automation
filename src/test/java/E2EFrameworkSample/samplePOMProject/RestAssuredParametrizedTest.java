package E2EFrameworkSample.samplePOMProject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import resources.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;


public class RestAssuredParametrizedTest extends Base{
	
	public static Logger log = LogManager.getLogger(RestAssuredParametrizedTest.class.getName());
			
			
	@Test(dataProvider = "DataForPost")
	public void examplePostUsingJsonSimpleLibrary(String name, String job) {
				
			
		JSONObject request2 = new JSONObject();			
		request2.put("name", name);
		request2.put("job", job);
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
	
			
		
}
