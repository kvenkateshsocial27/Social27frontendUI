import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.exception.StepErrorException as StepErrorException
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.logging.ErrorCollector as ErrorCollector
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import com.kms.katalon.core.logging.LogLevel as LogLevel
import com.kms.katalon.core.util.internal.ExceptionsUtil as ExceptionsUtil
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.util.FileUtil as FileUtil
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
//import org.apache.commons.io.FileUtilsCleanDirectoryTestCase as FileUtilsCleanDirectoryTestCase
import org.apache.commons.io.FileUtils as FileUtils
import java.io.*
import org.openqa.selenium.Keys as Keys
import org.junit.After as After
import org.openqa.selenium.By as By

import java.util.*
import java.text.DateFormat as DateFormat
import java.util.Date as Date
import java.util.Calendar as Calendar
import java.util.TimeZone as TimeZone
import java.util.List as List
import java.util.Iterator as Iterator
import java.util.Set as Set
import java.util.Arrays as Arrays
import java.util.ArrayList as ArrayList
import java.util.concurrent.TimeUnit as TimeUnit
import java.io.IOException as IOException
import java.text.CalendarBuilder as CalendarBuilder
import java.text.DateFormatSymbols as DateFormatSymbols
import java.text.SimpleDateFormat as SimpleDateFormat
import org.apache.poi.xssf.usermodel.XSSFSheet as XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook as XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFRow as XSSFRow
import org.apache.poi.xssf.usermodel.XSSFCell as XSSFCell
import org.apache.poi.ss.usermodel.Cell as Cell
import org.apache.poi.ss.usermodel.Row as Row
import org.apache.commons.io.IOUtils as IOUtils
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogEntry
import org.openqa.selenium.WebDriver
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogEntry
import java.lang.Integer as Integer
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.logging.LogEntries
import org.openqa.selenium.logging.LogEntry

KeywordUtil keyword = new KeywordUtil()

String GlobalOutputFile = 'C:\\Social27_FrontendAuomation\\01_GlobalSheet\\CUNA_Event_TestSheet.xlsx'

int Execution_Sheetnum = 3
int Filter_rowcount = CustomKeywords.'com.kf.Excel.readexcel_getlastnonblankrowno'(GlobalOutputFile, Execution_Sheetnum)
int TCrun

String TCID_Value

String Exestatus_Value

WebUI.refresh()
WebUI.click(findTestObject('Menu/Roundtable'))
CustomKeywords.'com.kf.Actions.consolelog'()

WebUI.click(findTestObject('Menu/Create Meeting'))
CustomKeywords.'com.kf.Actions.consolelog'()

WebUI.click(findTestObject('Menu/Social27'))
CustomKeywords.'com.kf.Actions.consolelog'()

//CustomKeywords.'com.kf.Excel.writetoexcel'(Outputfile, getSheetNo, fieldrow, getrefresheddate_cellno,LastRefreshedDate)
for (int row = 1; row <= Filter_rowcount; row++) {
    TCID_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, row, 1)

    /******Logo Check *******************/
    if (TCID_Value.equalsIgnoreCase('Verify Logo -> Social27')) {
        TCrun = row

        //break
        Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 
            2)

        if (Exestatus_Value.equalsIgnoreCase('Y')) {
            if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Social27 Logo'), 15, FailureHandling.OPTIONAL)) {
                CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
            } else {
                CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
            }
        }
    }
    
    /***** Header -> New meeting powered by Social27.com *************************/
    if (TCID_Value.equalsIgnoreCase('Verify "Header -> New meeting powered by Social27.com"')) {
        TCrun = row

        //break
        Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 
            2)
		System.out.println(WebUI.getText(findTestObject('CreateMeeting/Headercheck')))
			
        if (Exestatus_Value.equalsIgnoreCase('Y')) {
            if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Headercheck'), 15, FailureHandling.OPTIONAL)) {
				if (WebUI.getText(findTestObject('CreateMeeting/Headercheck')) == "New meeting powered by Social27.com")
				{
                CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
				} 
				else {
                CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Text "New meeting powered by Social27.com" is not displayed in the title')
				}}
			else
			{
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Element "New meeting powered by Social27.com" not Found')
			}	
        }
    }
	
	/ *****Verify the type - "Verify Meeting Type - Roundtables" *************************/
	if (TCID_Value.equalsIgnoreCase('Verify the type - "Choose Meeting Type - Roundtables"')) {
		TCrun = row

	Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun,
		2)
			
	if (Exestatus_Value.equalsIgnoreCase('Y')) 
		{
			if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Roundtable'), 15, FailureHandling.OPTIONAL)) 
			{
			CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
			}
			else {
			CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
			CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Roundtable Element not displayed')
			}
		}
	else
	{
		if (WebUI.verifyElementNotPresent(findTestObject('CreateMeeting/Roundtable'), 15, FailureHandling.OPTIONAL))
			{
			CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
			}
			else {
			CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
			CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Roundtable is displayed')
			}

	}	
}

/ *****Verify the type - "Verify Meeting Type - Boardrooms" *************************/
if (TCID_Value.equalsIgnoreCase('Verify the type - "Choose Meeting Type - Boardrooms"')) {
	TCrun = row

Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun,
	2)
		
if (Exestatus_Value.equalsIgnoreCase('Y'))
	{
		if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Boardroom'), 15, FailureHandling.OPTIONAL))
		{
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
		}
		else {
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Roundtable Element not displayed')
		}
	}
else
{
	if (WebUI.verifyElementNotPresent(findTestObject('CreateMeeting/Boardroom'), 15, FailureHandling.OPTIONAL))
		{
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
		}
		else {
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Roundtable is displayed')
		}

}
}

/ *****Verify the type - "Verify Roundtable Access - Private" *************************/
if (TCID_Value.equalsIgnoreCase('Verify the Roundtable Access - "Choose Roundtable Access - Private"')) {
	TCrun = row

Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun,
	2)
		
if (Exestatus_Value.equalsIgnoreCase('Y'))
	{
		if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Verify-private'), 15, FailureHandling.OPTIONAL))
		{
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
		}
		else {
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Roundtable Element not displayed')
		}
	}
else
{
	if (WebUI.verifyElementNotPresent(findTestObject('CreateMeeting/Verify-private'), 15, FailureHandling.OPTIONAL))
		{
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
		}
		else {
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Roundtable is displayed')
		}

}
}

/*****Verify the type - "Verify Roundtable Access - Public" *************************/
if (TCID_Value.equalsIgnoreCase('Verify the Roundtable Access - "Choose Roundtable Access - Public"')) {
	TCrun = row

Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun,
	2)
		
if (Exestatus_Value.equalsIgnoreCase('Y'))
	{
		if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Verify-public'), 15, FailureHandling.OPTIONAL))
		{
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
		}
		else {
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Roundtable Element not displayed')
		}
	}
else
{
	if (WebUI.verifyElementNotPresent(findTestObject('CreateMeeting/Verify-public'), 15, FailureHandling.OPTIONAL))
		{
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
		}
		else {
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
		CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Roundtable is displayed')
		}
}
}

/*****Verify the type - "Verify Attendees Restrictions - Roundtables" *************************/

if (TCID_Value.equalsIgnoreCase('Verify invitie Attendees Text for Roundables - "Invite up to 5 attendees"')) {
	TCrun = row

Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun,
	2)
		
if (Exestatus_Value.equalsIgnoreCase('Y'))
	{
		WebUI.click(findTestObject('CreateMeeting/Roundtable'))		
		if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/VerifyRT-attendeenumbers'), 15, FailureHandling.OPTIONAL))
		{
				if (WebUI.getText(findTestObject('CreateMeeting/VerifyRT-attendeenumbers')) == "Invite up to 5 attendees")
				{
                CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
				} 
				else {
                CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Text "Invite up to 5 attendees" is not displayed Correctly')
				}}
				else
					{
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Element not Found')
					}	
	}
}

/*****Verify the type - "Verify Attendees Restrictions - Boardrooms" *************************/

if (TCID_Value.equalsIgnoreCase('Verify invitie Attendees Text for Boardrooms - "Invite up to 15 attendees"')) {
	TCrun = row
Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun,
	2)
		
if (Exestatus_Value.equalsIgnoreCase('Y'))
	{
		WebUI.click(findTestObject('CreateMeeting/Boardroom'))
		if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/VerifyBR-attendeenumbers'), 15, FailureHandling.OPTIONAL))
		{
				if (WebUI.getText(findTestObject('CreateMeeting/VerifyBR-attendeenumbers')) == "Invite up to 15 attendees")
				{
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
				}
				else {
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Text "Invite up to 5 attendees" is not displayed Correctly')
				}}
				else
					{
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Element not Found')
					}
	}
}

/*****Verify user can able to select Start Date *************************/

if (TCID_Value.equalsIgnoreCase('Verify whether user can able to select a Start Date')) 
	{
	TCrun = row
	Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 2)
		
	if (Exestatus_Value.equalsIgnoreCase('Y'))
	{
		if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Opencalendar'), 15, FailureHandling.OPTIONAL))
		{
			WebUI.click(findTestObject('CreateMeeting/Opencalendar'))
			//WebUI.sendKeys(findTestObject('CreateMeeting/Startdate'), Keys.chord(Keys.ENTER))
			WebUI.click(findTestObject('CreateMeeting/Startdate'))
			CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
		}
				else {
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'User could not able to select Start Date')
				}
}
}

/*****Verify user can able to select Start Time *************************/

if (TCID_Value.equalsIgnoreCase('Verify whether user can able to select a Start Time'))
	{
	TCrun = row
	Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 2)
		
	if (Exestatus_Value.equalsIgnoreCase('Y'))
	{
		if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Choosetime'), 15, FailureHandling.OPTIONAL))
		{
			WebUI.click(findTestObject('CreateMeeting/Choosetime'))
			if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Choosetimefromlist'), 15, FailureHandling.OPTIONAL))
				{
				WebUI.click(findTestObject('CreateMeeting/Choosetimefromlist'))
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
				
				//WebUI.selectOptionByIndex(findTestObject('CreateMeeting/Choosetimefromlist'), 3)
				}
				else
				{
					WebUI.click(findTestObject('CreateMeeting/Choosetimefromlist1'))
					CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
					
				}	
		}
				else {
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'User could not able to select Start Time')
				}
}
}

/*****Verify user can able to select Duration *************************/

if (TCID_Value.equalsIgnoreCase('Verify whether user can able to select Duration'))
	{
	TCrun = row
	Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 2)
		
	if (Exestatus_Value.equalsIgnoreCase('Y'))
	{
		if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/ChooseDuration'), 15, FailureHandling.OPTIONAL))
		{
			WebUI.click(findTestObject('CreateMeeting/ChooseDuration'))
			WebUI.click(findTestObject('CreateMeeting/select15duration'))
			
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
		}
				else {
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'User could not able to select Durations')
				}
}
}

/*****Verify user can able to select Duration *************************/

if (TCID_Value.equalsIgnoreCase('Verify the field - Add Topic'))
	{
	TCrun = row
	Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 2)
		
	if (Exestatus_Value.equalsIgnoreCase('Y'))
	{
		if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Topic'), 15, FailureHandling.OPTIONAL))
		{
			WebUI.click(findTestObject('CreateMeeting/Topic'))
			WebUI.setText(findTestObject('CreateMeeting/Topic'), "Automation Roundtable Topic - Part 1")		
			CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
		}
				else {
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'User could not able to set the Text in the Topic Field')
				}
}
}


if (TCID_Value.equalsIgnoreCase('Verify the field  - Description'))
	{
	TCrun = row
	Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 2)
		
	if (Exestatus_Value.equalsIgnoreCase('Y'))
	{
		if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Description'), 15, FailureHandling.OPTIONAL))
		{
			WebUI.click(findTestObject('CreateMeeting/Description'))
			WebUI.setText(findTestObject('CreateMeeting/Description'), "Automation Roundtable Description - Part 1")
			CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
		}
				else {
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'User could not able to set the Text in the Description Field')
				}
}


	}
	
	
	if (TCID_Value.equalsIgnoreCase('Verify Area of Interest in Roundtable'))
		{
		TCrun = row
		Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 2)
		System.out.println(Exestatus_Value)
		if (Exestatus_Value.equalsIgnoreCase('Y'))
		{
			if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Areaofinterest'), 15, FailureHandling.OPTIONAL))
			{
				String customcolumnmdata =  CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 5)
				String[] arrSplitcolumns = customcolumnmdata.split(', ')
				columnlength = arrSplitcolumns.length
				for (int i = 0; i < 5; i++)	
			//	for (int i = 0; i < columnlength; i++) 
					{
					WebUI.click(findTestObject('CreateMeeting/Areaofinterest'))	
					String Datavalue1 = arrSplitcolumns[i]
					WebUI.sendKeys(findTestObject('CreateMeeting/Areaofinterest'), Datavalue1)	
					WebUI.sendKeys(findTestObject('CreateMeeting/Areaofinterest'), Keys.chord(Keys.DOWN))
					WebUI.sendKeys(findTestObject('CreateMeeting/Areaofinterest'), Keys.chord(Keys.ENTER))		
					Thread.sleep(30)
						/*
						Actions builder = new Actions(driver)
						Action howerAndClick = builder.moveToElement("the web element").click().build()
						*/
				}
						
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
			}
					else {
					CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
					CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'User could not able to set the Text in the Description Field')
					}
		}
	}

	if (TCID_Value.equalsIgnoreCase('Select Area of Interest more than Expected AOI in Roundtable'))
		{
		TCrun = row
		Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 2)
		if (Exestatus_Value.equalsIgnoreCase('Y'))
		{
			if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/Areaofinterest'), 15, FailureHandling.OPTIONAL))
			{
				String customcolumnmdata =  CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 5)
				String[] arrSplitcolumns = customcolumnmdata.split(', ')			
				columnlength = arrSplitcolumns.length
				int int_Data = Integer.valueOf(arrSplitcolumns[0]) + 1
				
				for(int j = 0; j < 5; j++)
				{
				WebUI.sendKeys(findTestObject('CreateMeeting/Areaofinterest'), Keys.chord(Keys.BACK_SPACE))
				}
				System.out.println(int_Data)	
				for (int i = 1 ; i <= int_Data + 1; i++)
				{
					WebUI.click(findTestObject('CreateMeeting/Areaofinterest'))
					String Datavalue1 = arrSplitcolumns[i]
					WebUI.sendKeys(findTestObject('CreateMeeting/Areaofinterest'), Datavalue1)
					WebUI.sendKeys(findTestObject('CreateMeeting/Areaofinterest'), Keys.chord(Keys.DOWN))
					WebUI.sendKeys(findTestObject('CreateMeeting/Areaofinterest'), Keys.chord(Keys.ENTER))
					Thread.sleep(30)
						/*
						Actions builder = new Actions(driver)
						Action howerAndClick = builder.moveToElement("the web element").click().build()
						*/
					if(i == int_Data)
					{
						if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/ToastContainer'), 15, FailureHandling.OPTIONAL))
							{
								System.out.println(WebUI.getText(findTestObject('CreateMeeting/ToastContainer')))
								CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
							}
							else {
								CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
								CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'User could not able to set the Text in the Description Field')
								}
			
						} // End of if
				} //End of For
						
			}
		}
	}

	if (TCID_Value.equalsIgnoreCase('Validate the button in Create Roundtable when the meeting type is Roundtable'))
		{
		TCrun = row
		WebUI.click(findTestObject('CreateMeeting/Roundtable'))	
		Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 2)
		if (Exestatus_Value.equalsIgnoreCase('Y'))
		{
			if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/CreateRoundtable'), 15, FailureHandling.OPTIONAL))
			{						
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
			}
					else {
					CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
					CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Invalid Text name')
					}
		}
	}

	if (TCID_Value.equalsIgnoreCase('Validate the button in Create Boardroom when the meeting type is Boardrooms'))
		{
		TCrun = row
		WebUI.click(findTestObject('CreateMeeting/Boardroom'))		
		Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 2)
		if (Exestatus_Value.equalsIgnoreCase('Y'))
		{
			if (WebUI.verifyElementPresent(findTestObject('CreateMeeting/CreateRoundtable'), 15, FailureHandling.OPTIONAL))
			{
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
			}
					else {
					CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
					CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 4, 'Invalid Text name')
					}
		}
	}

}