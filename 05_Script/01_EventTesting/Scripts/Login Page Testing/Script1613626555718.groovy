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


WebUI.openBrowser('')
WebDriver driver = DriverFactory.getWebDriver()
WebUI.navigateToUrl('https://events1.social27.com/fia/auth')
CustomKeywords.'com.kf.Actions.consolelog'()
String url = WebUI.getUrl()

/*
int brokenLinks = 0
brokenLinks += WebUI.callTestCase(findTestCase("Event BrokenLink Checker"),	["pageUrl": "https://events1.social27.com/sugarcrm/auth"])
if (brokenLinks > 0) {
	KeywordUtil.markFailed("one or more broken links are found")}
	list = WebUI.getAllLinksOnCurrentPage(true, [])
	System.out.println(list)
/*
AxeResult results = driver.Analyze();

AXE.inject(driver, scriptUrl);
JSONObject responseJSON = new AXE.Builder(driver,    scriptUrl).analyze();
JSONArray violations = responseJSON.getJSONArray("violations");
sif (violations.length() == 0)
{
   Assert.assertTrue(true, "No violations found");
}
else {
   AXE.writeResults("path & name of the file you want to save the  report"), responseJSON);
   Assert.assertTrue(false, AXE.report(violations));
}

*/

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_DailyQA Event/div_Email address'))
WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/div_Email address'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_DailyQA Event/div_Password'))
WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/div_Password'))
WebUI.setText(findTestObject('Object Repository/Page_DailyQA Event/input_Sign Up_mat-input-0'), Username)
WebUI.setText(findTestObject('Object Repository/Page_DailyQA Event/input_Email address_mat-input-1'), Password)
WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/button_Login'))
/*
brokenLinks += WebUI.callTestCase(findTestCase("Event BrokenLink Checker"),	["pageUrl": "https://events1.social27.com/sugarcrm/home"])
if (brokenLinks > 0) {
	KeywordUtil.markFailed("one or more broken links are found")}
*/
CustomKeywords.'com.kf.Actions.consolelog'()
