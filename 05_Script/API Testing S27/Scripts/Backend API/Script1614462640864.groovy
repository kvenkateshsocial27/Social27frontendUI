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

	String Settingsfile = "C:\\Social27_FrontendAuomation\\01_GlobalSheet\\EndPointsRun.xlsx"

    String Base_URL = "https://e27api1.social27.com/api/v1.0/";
    String pass;
    String userId;
    String eventId = EventID;
    String login = Username;	
    String Password = Password;
    String neweventname = EventName;
	String userid = "798382";
	int statusCode
	String responseBody;
	String s1
	
	boothid = boothid
	sponsor = sponsor
	sessionId = sessionId
	
	
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
						Response response;
						RequestSpecification httpRequest;
						String boothid
						String playlist
						String sponsor
						String sessionId
						
					for (int row = 1; row < intFilter_rowcount-1; row++)
					{
	
						String EP = CustomKeywords.'sample.ExcelRead.readexcel_cellvalue'(Runfile, 0,row,1)	
						httpRequest = RestAssured.given();
						httpRequest.header("Authorization", "Bearer " + pass);
						
					switch (EP) 
					{
						case 'get_activity_notifications':
						response = httpRequest.get("activity-notifications/count");
						responseBody = response.getBody().asString();
						break
						
						case 'get_user_info':
						response = httpRequest.get("events/userprofile");
						responseBody = response.getBody().asString();
						break
						
						case "get_agenda_sessions":
						response = httpRequest.get("events/" + eventId + "/users/" + userId + "/agenda/sessions");
						//responseBody = response.getBody().asString();
						break
						
						case "get_speaker_details":
						response = httpRequest.get("events/" + eventId + "/speakers/details");
						//responseBody = response.getBody().asString();
						break
						
						case "get_attendee_directory":
						response = httpRequest.get("events/" + eventId + "/attendee-directory?userId=" + userId + "&sortBy=3");
						//responseBody = response.getBody().asString();
						break
						
						case "get_SpeakerFilters":
						response = httpRequest.get("events/" + eventId + "/SpeakerFilters");
						responseBody = response.getBody().asString();
						break
						
						case "get_my_plan":
						response = httpRequest.get("events/" + eventId + "/users/" + userId + "/sessions/my-plans?page=0&total=0");				
						responseBody = response.getBody().asString();
						break
						
						case "get_my_videos":
						response = httpRequest.get("events/users/" + userId + "/my-videos");
						responseBody = response.getBody().asString();
						break
						case "get_my_badges":
						response = httpRequest.get("events/" + eventId + "/users/" + userId + "/badges");
						responseBody = response.getBody().asString();
						break
						case "get_interlocutors_count":
						response = httpRequest.get("events/chat/interlocutors/count");				
						responseBody = response.getBody().asString();
						break
						case "get_swagbag":
						response = httpRequest.get("events/chat/interlocutors/count");
						responseBody = response.getBody().asString();
						break
						// Home page - Speakers
						case "get_speaker_count":
						response = httpRequest.get("events/" + eventId + "/speakers?count=6");
						responseBody = response.getBody().asString();
						break
						case "get_tags":
						response = httpRequest.get("events/" + eventId + "/tags?sectionId=4&SectionBasedId=" + eventId);				
						responseBody = response.getBody().asString();
						break
						case "get_topicpod":
						response = httpRequest.get("events/" + eventId + "/topicpod");				
						responseBody = response.getBody().asString();
						break
						case "get_public_roundtables":
						response = httpRequest.get("events/" + eventId + "/users/" + eventId + "/roundtables/public?page=1&total=8&type=1");				
						responseBody = response.getBody().asString();
						break
						case "get_sponsored_roundtables":
						response = httpRequest.get("events/sponsored-roundtables?page=1&total=8&type=2");				
						responseBody = response.getBody().asString();
						break
						case "get_user_roundtables":
						response = httpRequest.get("events/" + eventId + "/users/" + eventId + "/roundtables?page=1&total=8&tagId=0&inviteStatus=-1&roundTableName=&type=1");
						responseBody = response.getBody().asString();
						break
						case "get_user_notifications":
						response = httpRequest.get("events/" + eventId + "/activity-notifications?userId=141180&pageNumber=1&recordPerPage=10&status=2");				
						responseBody = response.getBody().asString();
						break
						case "get_session_info":
						response = httpRequest.get("events/" + eventId + "/users/" + userId + "/sessions/89841/info");
						responseBody = response.getBody().asString();
						break
						case "get_forms":
						response = httpRequest.get("forms?sectionBasedId=89841&sectionId=13");				
						responseBody = response.getBody().asString();
						break
						case "get_chat":
						response = httpRequest.get("events/" + eventId + "/chat?sectionBasedId=89841&sectionId=13&pageNumber=1&recordPerPage=20&approved=true&isModeratedQnA=false");				
						responseBody = response.getBody().asString();
						break
						case "get_post_custom_modules":
						response = httpRequest.post("page/custom-modules");
						responseBody = response.getBody().asString();
						break
						case "get_post_validate_with_settings":
						response = httpRequest.post("events/validate-with-settings");				
						responseBody = response.getBody().asString();
						break
						case "get_resources":
						response = httpRequest.post("events/4219/get-resources");
						responseBody = response.getBody().asString();
						break
						case "get_event_sessions":
						response = httpRequest.post("events/4219/sessions/89841");
						responseBody = response.getBody().asString();
						break
						case "post_custommdoules":
						response = httpRequest.post("events/4219/sessions/89841");
						responseBody = response.getBody().asString();
						break
						case "personalized_tagid":
						response = httpRequest.get("events/" + eventId + "/users/" + userId + "/tags?sectionId=1&sectionBaseId=" + userId);						
						responseBody = response.getBody().asString();
						break
						case "hello_world":
						response = httpRequest.get("events/" + eventId + "/users/" + userId + "/hello-world");
						responseBody = response.getBody().asString();
						break
						case "soap_box":
						response = httpRequest.get("events/" + eventId + "/users/" + userId + "/hello-world");
						responseBody = response.getBody().asString();
						break
						case "my_ranking":
						response = httpRequest.get("my-rankings");
						responseBody = response.getBody().asString();
						break
						//Session - Submiform
						case "post_submitform":
						response = httpRequest.get("forms/submitForm");
						responseBody = response.getBody().asString();
						break
						//Stats
						case "get_stats":
						response = httpRequest.get(eventId + "/stats");
						responseBody = response.getBody().asString();
						break
						//lock status
						case "get_locked":
						response = httpRequest.get("sessions/locked");
						responseBody = response.getBody().asString();
						break
						
						case "add_plan":
						httpRequest.get("events/" + eventId + "/users/" + userId + "/agenda/sessions");
						response = httpRequest.get("events/" + eventId + "/users/" + userId + "/sessions/" + sessionId + "/add-to-plan");											
						responseBody = response.getBody().asString();						
						break
						
						case "remove_plan":
						response = httpRequest.get("events/" + eventId + "/users/" + userId + "/sessions/" + sessionId + "/remove-plan");
						responseBody = response.getBody().asString();
						break
						
						case "All_Speakers":
						response = httpRequest.get("events/" + eventId + "/AllSpeakers");
						responseBody = response.getBody().asString();
						break

						case "Expohall":
						response = httpRequest.get("events/" + eventId + "/expo");
						responseBody = response.getBody().asString();
						break

						case "Sponsors":
						response = httpRequest.get("events/" + eventId + "/sponsors/" + sponsor);
						responseBody = response.getBody().asString();
						break
						
						case "BoothRep":
						response = httpRequest.get("events/" + eventId + "/booths/"+ boothid +"/rep?userId=" + userId);
						responseBody = response.getBody().asString();
						break

						case "Playlist":
						response = httpRequest.get("events/" + eventId + "/sponsors/"+ boothid +"/playlist");
						responseBody = response.getBody().asString();
						break
						
						case "moderatorQna":
						response = httpRequest.get("events/" + eventId + "/chat?sectionBasedId=" + userId +"&sectionId=2&pageNumber=1&recordPerPage=20&approved=true&isModeratedQnA=false");
						responseBody = response.getBody().asString();
						break

						case "Resource":
						response = httpRequest.get("events/" + eventId + "/sponsors/"+ boothid +"/Resources");
						responseBody = response.getBody().asString();
						break
						
						//Booth
						case "get_repuser":
						response = httpRequest.get("events/" + eventId + "/booths"/ + boothid + "/rep?userId=" + userId );
						responseBody = response.getBody().asString();
						break
						
						//Booth - Tags
						case "get_boothtag":
						response = httpRequest.get("events/" + eventId + "/tags?sectionId=4&SectionBasedId=" + eventId);
						responseBody = response.getBody().asString();
						break
						
						//booth - Roundtable
						case "get_sponsoredRT":
						response = httpRequest.get("events/sponsored-roundtables?boothId=" + boothid + "&page=1&total=40&type=1");
						responseBody = response.getBody().asString();
						break
						
						//booth - Boardroom
						case "get_sponsoredBR":
						response = httpRequest.get("events/sponsored-roundtables?boothId=" + boothid + "&page=1&total=40&type=2");
						responseBody = response.getBody().asString();
						break

						//booth - Public
						case "get_public":
						response = httpRequest.get("events/roundtables/public?page=1&total=40&type=2");
						responseBody = response.getBody().asString();
						break

						//booth - Visitors
						case "get_visitors":
						response = httpRequest.get("events/booths/"+ boothid +"/visitors?sectionId=2&recordsPerPage=12&pageNumber=1&search=&sortBy=3");
						responseBody = response.getBody().asString();
						break

						}
						
	
					System.out.println("Response Body is =>  " + responseBody);
					s1 = Integer.toString(statusCode);
					Assert.assertEquals(statusCode, 200 , "Correct status code returned");
					CustomKeywords.'sample.Excelwrite.write'(row+2, 0,String.valueOf(row),Outputfile);
					CustomKeywords.'sample.Excelwrite.write'(row+2, 1, EP,Outputfile);
					CustomKeywords.'sample.Excelwrite.write'(row+2, 2, s1,Outputfile);
					CustomKeywords.'sample.Excelwrite.write'(row+2, 3, responseBody,Outputfile);
					}
