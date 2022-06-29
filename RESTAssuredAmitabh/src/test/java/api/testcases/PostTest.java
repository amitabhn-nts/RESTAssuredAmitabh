package api.testcases;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;

import io.restassured.response.Response;
import utils.CommonOperations;

public class PostTest extends BaseClass {
	
	@Test
	public void createPostRequest() throws IOException {
		
		String endPoint = CommonOperations.apiConfig.getProperty("endPointPost");
		String body = Files.readString(Path.of(System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\CreateUserJsonBody.json"), StandardCharsets.US_ASCII);
		
		Response response = CommonOperations.postRequest(endPoint, body);
		
		String id =  response.getBody().jsonPath().getJsonObject("id").toString();
		System.out.println(id);
		
		String name =  response.getBody().jsonPath().getJsonObject("name").toString();
        String job =  response.getBody().jsonPath().getJsonObject("job").toString();
        
        System.out.println(name);
        System.out.println(job);
        
        JsonMapper mapper = new JsonMapper();
        JsonNode node = mapper.readValue(body, JsonNode.class);
        
        Assert.assertEquals(name, node.get("name").asText(),"name mismatch");
        Assert.assertEquals(job, node.get("job").asText(),"job mismatch");
        
        //this is to make the assertion fail
//        Assert.assertEquals("Rani", node.get("name").asText(),"name mismatch");
        
        
        
	}

}
