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

/*
WebUI.openBrowser('')
WebDriver driver = DriverFactory.getWebDriver()
WebUI.navigateToUrl('https://creator.social27.com/auth/logins')
CustomKeywords.'com.kf.Actions.consolelog'()
String url = WebUI.getUrl()
*/

driver.get("www.xyz.com");
List<WebElement> linksize = driver.findElements(By.tagName("a"));
linksCount = linksize.size();
System.out.println("Total no of links Available: "+linksCount);
links= new String[linksCount];
System.out.println("List of links Available: ");
// print all the links from webpage
for(int i=0;i<linksCount;i++)
{
links[i] = linksize.get(i).getAttribute("href");
System.out.println(all_links_webpage.get(i).getAttribute("href"));
}
// navigate to each Link on the webpage
for(int i=0;i<linksCount;i++)
{
driver.navigate().to(links[i]);
Thread.sleep(3000);
}

int brokenLinks = 0
WebUI.navigateToUrl("https://events1.social27.com/sugarcrm/home")
WebUI.verifyAllLinksOnCurrentPageAccessible(true, [])
WebUI.verifyLinksAccessible("https://events1.social27.com/sugarcrm/home")

CustomKeywords.'com.kf.Actions.consolelog'()

WebUI.navigateToUrl("https://events1.social27.com/sugarcrm/agenda")
CustomKeywords.'com.kf.Actions.consolelog'()

WebUI.navigateToUrl("https://events1.social27.com/sugarcrm/speakers")
CustomKeywords.'com.kf.Actions.consolelog'()


/*
brokenLinks += WebUI.callTestCase(findTestCase("Event BrokenLink Checker"),	["pageUrl": "https://creator.social27.com/auth/login"])
if (brokenLinks > 0) {
	KeywordUtil.markFailed("one or more broken links are found")}
	list = WebUI.getAllLinksOnCurrentPage(true, [])
	System.out.println(list)
brokenLinks += WebUI.callTestCase(findTestCase("Event BrokenLink Checker"),	["pageUrl": "https://creator.social27.com/events/list"])
if (brokenLinks > 0) {
	KeywordUtil.markFailed("one or more broken links are found")}
	*/
/*
brokenLinks += WebUI.callTestCase(findTestCase("Event BrokenLink Checker"),	["pageUrl": "https://events1.social27.com/sugarcrm/home"])
if (brokenLinks > 0) {
	KeywordUtil.markFailed("one or more broken links are found")}
brokenLinks += WebUI.callTestCase(findTestCase("Event BrokenLink Checker"),	["pageUrl": "https://events1.social27.com/sugarcrm/agenda"])
if (brokenLinks > 0) {
	KeywordUtil.markFailed("one or more broken links are found")}
brokenLinks += WebUI.callTestCase(findTestCase("Event BrokenLink Checker"),	["pageUrl": "https://events1.social27.com/sugarcrm/speakers"])
if (brokenLinks > 0) {
	KeywordUtil.markFailed("one or more broken links are found")}
brokenLinks += WebUI.callTestCase(findTestCase("Event BrokenLink Checker"),	["pageUrl": "https://events1.social27.com/sugarcrm/expohall"])
if (brokenLinks > 0) {
	KeywordUtil.markFailed("one or more broken links are found")}
brokenLinks += WebUI.callTestCase(findTestCase("Event BrokenLink Checker"),	["pageUrl": "https://events1.social27.com/sugarcrm/roundtables"])
if (brokenLinks > 0) {
	KeywordUtil.markFailed("one or more broken links are found")}

//CustomKeywords.'com.kf.Actions.consolelog'()
*/
CustomKeywords.'com.kf.Actions.consolelog'()
