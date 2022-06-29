package demo;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo {
	
	@Test
	public void testDemo() {
		
//		Response res = get("https://reqres.in/api/users/2");
//		
//		System.out.println("body =========>>>>>>>>> "+res.body().asString());
//		System.out.println("body =========>>>>>>>>> "+res.getBody());
//		System.out.println(res.getStatusCode());
	}
	
	@Test
	public void testDemo2() {
		
		baseURI="https://reqres.in";
		Response res = given().get("api/users/2");
		
		System.out.println("body =========>>>>>>>>> "+res.body().asString());
		System.out.println("body =========>>>>>>>>> "+res.getBody());
		System.out.println(res.getStatusCode());
	}
	
	@Test
	public void testDemo3() {
		RequestSpecification testObj = given().filter(new AllureRestAssured());
	}
	
	

}
