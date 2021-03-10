import java.util.List;
import java.util.Map;

import org.junit.Assert;
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.commons.io.IOUtils;
import org.apache.poi.sl.draw.geom.PathCommand
import org.openqa.selenium.io.FileHandler;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

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
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import org.apache.commons.io.FileUtils;

    String Base_URL = "https://e27api1.social27.com/api/v1.0/";
    String pass;
    String userId;
	Response response;
	RequestSpecification httpRequest;
    String eventId = EventID;
    String login = Username;	
    String Password = Password;
    String neweventname = EventName;
	String userid = "798382";
	int statusCode
	String responseBody;
	String s1
	
	String Inputfileloc = "C:\\Social27_FrontendAuomation\\03_API Run\\"
	String Filename = EventName + "_" + EventID
	File clr_Fileloc1 = new File(Inputfileloc);
	FileUtils.cleanDirectory(clr_Fileloc1)
	DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
	DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");	
	
	Date date = new Date();
	String date1= dateFormat.format(date);
	String date2= dateFormat1.format(date);
	String Outputfile = Inputfileloc +  Filename + "_" + date1 + "_"+ date2 + ".xlsx"	
	CustomKeywords.'sample.Excelwrite.createexcel'(Outputfile)
	
		//get_token    
		CustomKeywords.'sample.Excelwrite.write'(0, 0, "Event Name",Outputfile);
		CustomKeywords.'sample.Excelwrite.write'(0, 1, neweventname,Outputfile);
			
					CustomKeywords.'sample.Excelwrite.write'(2, 0, "S.No",Outputfile);
					CustomKeywords.'sample.Excelwrite.write'(2, 1, "End Point",Outputfile);
					CustomKeywords.'sample.Excelwrite.write'(2, 2, "Status Code",Outputfile);
					CustomKeywords.'sample.Excelwrite.write'(2, 3, "Response",Outputfile);
					
					///get_activity_notifications
					String Runfile = "C:\\Social27_FrontendAuomation\\01_GlobalSheet\\EndPointsRun.xlsx"				
					int intFilter_rowcount = CustomKeywords.'sample.ExcelRead.readexcel_getlastnonblankrowno'(Runfile, 0)
					String Filter_rowcount = String.valueOf(intFilter_rowcount)
					
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
					System.out.println(pass)
					System.out.println(userId)

					for (int row = 1; row < Filter_rowcount-1; row++)
					{
						System.out.println(pass)
						System.out.println(userId)

						String EP = CustomKeywords.'sample.ExcelRead.readexcel_cellvalue'(Runfile, 0,row,1)
						httpRequest = RestAssured.given();
						httpRequest.header("Authorization", "Bearer " + pass);
	
					switch (EP) 
					{
						case 'get_activity_notifications':
						response = httpRequest.get("activity-notifications/count");
						break
						
						case 'get_user_info':
						response = httpRequest.get("events/userprofile");
													
						case "get_agenda_sessions":
						response = httpRequest.get("events/" + eventId + "/users/" + userId + "/agenda/sessions");
						
						
						case "get_speaker_details":
						response = httpRequest.get("events/" + eventId + "/speakers/details");
						
						case "get_attendee_directory":
						response = httpRequest.get("events/" + eventId + "/attendee-directory?userId=" + userId + "&sortBy=3");
						
					}
					
	
					responseBody = response.getBody().asString();
					System.out.println("Response Body is =>  " + responseBody);
					s1 = Integer.toString(statusCode);
					Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
					CustomKeywords.'sample.Excelwrite.write'(row+2, 0, "1",Outputfile);
					CustomKeywords.'sample.Excelwrite.write'(row+2, 1, EP,Outputfile);
					CustomKeywords.'sample.Excelwrite.write'(row+2, 2, s1,Outputfile);
					CustomKeywords.'sample.Excelwrite.write'(row+2, 3, responseBody,Outputfile);
					}
					//
					
