package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonOperations {
	
	public static Properties apiConfig;
    public static RequestSpecification request;
    public static Response response;
    
    public static void readAPIConfigs() throws IOException {
    	apiConfig = new Properties();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\apiConfig.properties");
        apiConfig.load(objfile);
    }
    
    public static void setBaseURI() throws IOException {
        //RestAssured.baseURI = "https://gorest.co.in/public/v2";
       RestAssured.baseURI =apiConfig.getProperty("baseURI");
    }
    
    public static RequestSpecification createRequest() {
        response = null;
        request = null;
        request = RestAssured.given().filter(new AllureRestAssured());
        return request;
    }
    
    public static Response getRequest(String endpoint){
        request = createRequest();
        request.header("Content-Type", "application/json");
      //  request.body(formdata);
        response =request.get(endpoint);
        return response;
    }
    
    public static Response postRequest(String endpoint, String body){
        request = createRequest();
        request.header("Content-Type", "application/json");
        request.body(body);
        response =request.post(endpoint);
        return response;
    }
    
    public static Response putRequest(String endpoint, String formdata){
        request = createRequest();
        request.header("Content-Type", "application/json");
        request.body(formdata);
        response =request.put(endpoint);
        return response;
    }

}
