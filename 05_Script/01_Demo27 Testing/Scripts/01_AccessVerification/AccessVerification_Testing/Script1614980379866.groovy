import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogEntry
import static org.junit.Assert.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.net.URL;
import com.kms.katalon.core.util.KeywordUtil
import org.apache.commons.io.FileUtils;
import java.util.Arrays
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat as DateFormat
import java.util.Date as Date
import java.util.Calendar as Calendar
import java.util.TimeZone as TimeZone
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import org.apache.commons.io.IOUtils;
import org.apache.poi.sl.draw.geom.PathCommand
import org.openqa.selenium.io.FileHandler;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;


String URL
String Execution = ExecutionStatus
String GlobalOutputfile
int Rowno = Integer.parseInt(SNo)
Outputfile = 'C:\\Social27_FrontendAuomation\\01_GlobalSheet\\01_AccessVerification.xlsx'
 GlobalOutputfile = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(Outputfile, 1, 0, 0)
 int columnstart = 10
 
switch (Execution)
{
	case "Y":
	
WebUI.openBrowser('')
WebDriver driver = DriverFactory.getWebDriver()

if (ExecutionStatus == "Y")
{
	
String URLname = EventURL 
WebUI.navigateToUrl("https://events1.social27.com/" + URLname + "/auth")
CustomKeywords.'com.kf.Actions.consolelog'()
String url = WebUI.getUrl()
String Username = Username
String Password = Password
String BL_SignIn = BL_SignIn
String BL_Signup = BL_Signup
String BL_Home = BL_Home
String BL_Sessions = BL_Sessions
String BL_Speakers = BL_Speakers
String BL_Networking = BL_Networking
String BL_Sponsors = BL_Sponsors
String BL_Notifications = BL_Notifications
String BL_Roundtables = BL_Roundtables
String BL_MyProfile = BL_MyProfile
String BL_MyAgenda = BL_MyAgenda
String BL_Logout = BL_Logout


CustomKeywords.'com.kf.verifymenu.checkaccess'("Signin",  BL_SignIn, URLname, GlobalOutputfile, Rowno, columnstart)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Signup", BL_Signup, URLname, GlobalOutputfile, Rowno, columnstart+1)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Home", BL_Home, URLname, GlobalOutputfile, Rowno, columnstart+2)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Sessions", BL_Sessions, URLname, GlobalOutputfile, Rowno, columnstart+3)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Speakers",  BL_Speakers, URLname, GlobalOutputfile, Rowno, columnstart+4)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Sponsors", BL_Sponsors, URLname, GlobalOutputfile, Rowno, columnstart+5)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Networking", BL_Networking, URLname, GlobalOutputfile, Rowno, columnstart+6)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Notifications", BL_Notifications, URLname, GlobalOutputfile, Rowno, columnstart+7)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Roundtables", BL_Roundtables, URLname, GlobalOutputfile, Rowno, columnstart+8)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Profile", BL_MyProfile, URLname, GlobalOutputfile, Rowno, columnstart+9)
CustomKeywords.'com.kf.verifymenu.checkaccess'("MyAgenda", BL_MyAgenda, URLname, GlobalOutputfile, Rowno, columnstart+10)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Logout", BL_Logout, URLname, GlobalOutputfile, Rowno, columnstart+11)


String AL_SignIn = AL_SignIn
String AL_Signup = AL_Signup
String AL_Home = AL_Home
String AL_Sessions = AL_Sessions
String AL_Speakers = AL_Speakers
String AL_Networking = AL_Networking
String AL_Sponsors = AL_Sponsors
String AL_Notifications = AL_Notifications
String AL_Roundtables = AL_Roundtables
String AL_MyProfile = AL_MyProfile
String AL_MyAgenda = AL_MyAgenda
String AL_Logout = AL_Logout

WebUI.navigateToUrl("https://events1.social27.com/" + URLname + "/auth")
WebUI.waitForPageLoad(30)

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_DailyQA Event/div_Email address'))
WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/div_Email address'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_DailyQA Event/div_Password'))
WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/div_Password'))
WebUI.setText(findTestObject('Object Repository/Page_DailyQA Event/input_Sign Up_mat-input-0'), Username)
WebUI.setText(findTestObject('Object Repository/Page_DailyQA Event/input_Email address_mat-input-1'), Password)
WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/button_Login'))
Thread.sleep(10000)

String LandingPage = LandingPage

CustomKeywords.'com.kf.verifymenu.checkaccess'("LandingPage", LandingPage, URLname, GlobalOutputfile, Rowno, columnstart-1)

CustomKeywords.'com.kf.verifymenu.checkaccess'("Signin",  AL_SignIn, URLname, GlobalOutputfile, Rowno, columnstart+13)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Signup", AL_Signup, URLname, GlobalOutputfile, Rowno, columnstart+14)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Home", AL_Home, URLname, GlobalOutputfile, Rowno, columnstart+15)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Sessions", AL_Sessions, URLname, GlobalOutputfile, Rowno, columnstart+16)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Speakers",  AL_Speakers, URLname, GlobalOutputfile, Rowno, columnstart+17)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Sponsors",  AL_Sponsors, URLname, GlobalOutputfile, Rowno, columnstart+18)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Networking",  AL_Networking, URLname, GlobalOutputfile, Rowno, columnstart+19)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Notifications",  AL_Notifications, URLname, GlobalOutputfile, Rowno, columnstart+20)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Roundtables",  AL_Roundtables, URLname, GlobalOutputfile, Rowno, columnstart+21)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Profile",  AL_MyProfile, URLname, GlobalOutputfile, Rowno, columnstart+22)
CustomKeywords.'com.kf.verifymenu.checkaccess'("MyAgenda",  AL_MyAgenda, URLname, GlobalOutputfile, Rowno, columnstart+23)
CustomKeywords.'com.kf.verifymenu.checkaccess'("Logout",  AL_Logout, URLname, GlobalOutputfile, Rowno, columnstart+24)

WebUI.click(findTestObject('Menu/Logout'))
WebUI.closeBrowser()

}
break

case "N":
CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputfile, Rowno, columnstart, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'( GlobalOutputfile, Rowno, columnstart+1, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'( GlobalOutputfile, Rowno, columnstart+2, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+3, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+4, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'( GlobalOutputfile, Rowno, columnstart+5, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'( GlobalOutputfile, Rowno, columnstart+6, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+7, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+8, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+9, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+10, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+11, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart-1, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+13, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+14, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'( GlobalOutputfile, Rowno, columnstart+15, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+16, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+17, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'( GlobalOutputfile, Rowno, columnstart+18, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+19, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+20, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'( GlobalOutputfile, Rowno, columnstart+21, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+22, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+23, "Not Executed")
CustomKeywords.'com.kf.verifymenu.checkaccess'(GlobalOutputfile, Rowno, columnstart+24, "Not Executed")
break

}
