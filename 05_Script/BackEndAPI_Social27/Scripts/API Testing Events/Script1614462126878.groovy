import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

    String Base_URL = "https://e27api1.social27.com/api/v1.0/";
    String pass;
    String userId;
	Response response;
	RequestSpecification httpRequest;
    String eventId = "4270";
    String login = "kvenkatesh@social27.com";
    String Password = "social27";
    String neweventname = "CUNA GAC 2021";
	String userid = "798382";
	int statusCode
	String responseBody;
	String s1
	String HttpReq = HttpRequest
	String EndPoint = EndPoint
		//get_token
	
        RestAssured.baseURI = Base_URL;
		JSONObject requestParams = new JSONObject();
        
		RequestSpecification request = RestAssured.given();
        
        requestParams.put("eventId", eventId);
        requestParams.put("login", login);
        requestParams.put("password", Password);
        request.header("Content-Type", "application/json");
        request.body(requestParams.toString());
        response = request.post("/authorization/login-extend");

        String loginresponse = response.getBody().asString();
        System.out.println("Response Body is =>  " + loginresponse);
		statusCode = response.getStatusCode();

        JsonPath jsonPathEvaluator = response.jsonPath();
        JSONObject Success = new JSONObject(loginresponse);
        JSONObject messsage = Success.getJSONObject("entity");

        pass = messsage.getString("token");
        userId = messsage.getInt("userId");
		CustomKeywords.'sample.Excelwrite.write'(0, 0, "Event Name");
		CustomKeywords.'sample.Excelwrite.write'(0, 1, neweventname);
			
					CustomKeywords.'sample.Excelwrite.write'(2, 0, "S.No");
					CustomKeywords.'sample.Excelwrite.write'(2, 1, "End Point");
					CustomKeywords.'sample.Excelwrite.write'(2, 2, "Status Code");
					CustomKeywords.'sample.Excelwrite.write'(2, 3, "Response");
					
					///get_activity_notifications
					
					httpRequest = RestAssured.given();
					httpRequest.header("Authorization", "Bearer " + pass);
					response = httpRequest.get("activity-notifications/count");
					responseBody = response.getBody().asString();
					System.out.println("Response Body is =>  " + responseBody);
					s1 = Integer.toString(statusCode);
					Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
					CustomKeywords.'sample.Excelwrite.write'(3, 0, "1");
					CustomKeywords.'sample.Excelwrite.write'(3, 1, EndPoint);
					CustomKeywords.'sample.Excelwrite.write'(3, 2, s1);
					CustomKeywords.'sample.Excelwrite.write'(3, 3, responseBody);
			
					//
					
