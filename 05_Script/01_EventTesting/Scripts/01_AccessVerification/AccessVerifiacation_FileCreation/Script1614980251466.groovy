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
import org.openqa.selenium.Keys as Keys
import java.io.Reader as Reader
import java.nio.file.Files as Files
import java.nio.file.Paths as Paths
import java.nio.file.FileSystems.DefaultFileSystemHolder
import org.apache.poi.poifs.filesystem.POIFSFileSystem as POIFSFileSystem
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.openqa.selenium.TakesScreenshot as TakesScreenshot
import org.openqa.selenium.OutputType as OutputType
import org.openqa.selenium.io.FileHandler as FileHandler
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.Row as Row
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import java.text.CalendarBuilder as CalendarBuilder
import java.text.DateFormatSymbols as DateFormatSymbols
import java.text.SimpleDateFormat as SimpleDateFormat
import org.openqa.selenium.Keys as Keys


	String Inputfileloc = "C:\\Social27_FrontendAuomation\\02_Expected Output\\"
	File clr_Fileloc1 = new File(Inputfileloc);
	String Filename
	String GSheet
	
	
	File Clr_downloadTestdir = new File('C:\\Social27_FrontendAuomation\\02_Expected Output\\')
	if (!Clr_downloadTestdir.exists()) {
		File dir1 = new File('C:\\Social27_FrontendAuomation\\02_Expected Output\\')
		dir1.mkdir()
	}
	else
	{
	FileUtils.cleanDirectory(Clr_downloadTestdir)
	}
	
	Filename = "EventsAccessTesting" + "_" +"Results"
	GSheet = 'C:\\Social27_FrontendAuomation\\01_GlobalSheet\\01_AccessVerification.xlsx'
	
	FileUtils.cleanDirectory(clr_Fileloc1)
	DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
	DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
	
	Date date = new Date();
	String date1= dateFormat.format(date);
	String date2= dateFormat1.format(date);
	String Outputfile = Inputfileloc +  Filename + "_" + date1 + "_"+ date2 + ".xlsx"
	String OPfilename = Outputfile
	
	CustomKeywords.'com.stucred.db.DBNewCases.createexcel'(Outputfile)

	File CopyOutputfile = new File(Outputfile)	
	file = new FileInputStream(GSheet)
	workbookinput = new XSSFWorkbook(file)
	XSSFWorkbook workbookoutput = workbookinput
	FileOutputStream out = new FileOutputStream(CopyOutputfile)
	workbookoutput.write(out)
	out.close()
	int i = 1
	CustomKeywords.'com.kf.Excel.writetoexcel_status'(GSheet, i, i-1, i-1, OPfilename )
	