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
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;


//WebUI.openBrowser('')
WebDriver driver = DriverFactory.getWebDriver()
driver.get("https://events1.social27.com/sugarcrm/expohall")

LogEntries logs = driver.manage().logs().get("browser")
for (LogEntry entry : logs) {
println entry.getMessage()
}
	

driver.get("https://events1.social27.com/sugarcrm/expohall/booths/Aspen");
List<WebElement> linksize = driver.findElements(By.tagName("a"));
linksCount = linksize.size();
System.out.println("Total no of links Available: "+linksCount);
links= new String[linksCount];
System.out.println("List of links Available: ");
// print all the links from webpage
for(int i=0;i<linksCount;i++)
{
links[i] = linksize.get(i).getAttribute("href");
System.out.println(links[i]);
}
/*
// navigate to each Link on the webpage
for(int i=0;i<linksCount;i++)
{
driver.navigate().to(links[i]);
Thread.sleep(3000);
}
*/