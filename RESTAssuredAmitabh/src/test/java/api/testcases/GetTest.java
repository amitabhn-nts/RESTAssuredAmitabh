package api.testcases;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import utils.CommonOperations;

public class GetTest extends BaseClass {

	@Test
	public void createGetRequest() {
		
		String endPoint = CommonOperations.apiConfig.getProperty("endPointGet");
		
		Response response = CommonOperations.getRequest(endPoint);
		
		response.then().statusCode(200);
		response.then().body("data.first_name", equalTo("Janet"));
		response.then().body("data.last_name", equalTo("Weaver"));
		//doubt : why getting failed when using hasItems
//		response.then().body("data.last_name", hasItems("Weaver"));
	}
	
	
}
