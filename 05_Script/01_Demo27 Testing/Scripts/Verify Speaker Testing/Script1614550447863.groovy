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

int Execution_Sheetnum = 1

int Filter_rowcount = CustomKeywords.'com.kf.Excel.readexcel_getlastnonblankrowno'(GlobalOutputFile, Execution_Sheetnum)
System.out.println(Filter_rowcount)
int TCrun

String TCID_Value
String Exestatus_Value

//WebUI.callTestCase(findTestCase('Login Page Testing'), [('Username') : 'kvenkatesh@social27.com', ('Password') : 'social27'],	FailureHandling.STOP_ON_FAILURE)
WebUI.refresh()


//CustomKeywords.'com.kf.Excel.writetoexcel'(Outputfile, getSheetNo, fieldrow, getrefresheddate_cellno,LastRefreshedDate)
for (int row = 1; row <= Filter_rowcount; row++) 
	{
    TCID_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, row, 1)
    /******Logo Check *******************/
    if (TCID_Value.equalsIgnoreCase('Verify user can able to click the speakers from the menu')) {
        TCrun = row
        //break
        Exestatus_Value = CustomKeywords.'com.kf.Excel.readexcel_cellvalue'(GlobalOutputFile, Execution_Sheetnum, TCrun, 
            2)

        if (Exestatus_Value.equalsIgnoreCase('Y')) {
			// check if speakers in the menu is present
            if (WebUI.verifyElementPresent(findTestObject('Menu/Speakers'), 15, FailureHandling.OPTIONAL)) 
			{
				// Yes -> Click the Speakers
				WebUI.click(findTestObject('Menu/Speakers'))
				// log the action
				CustomKeywords.'com.kf.Actions.consolelog'()
				// After clicking the speakers -> verify the speakers redirected to the speaker page (this is verified using speaker card) 
				if (WebUI.verifyElementPresent(findTestObject('Speaker/Speakercard'), 15, FailureHandling.OPTIONAL)) 
				{
                CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'PASS')
				}
             else // if the speaker card is not present - fail is reported
				{
                CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
			 	}
            }// if the speaker menu is not present - Fail is reported
			else
			{
				CustomKeywords.'com.kf.Excel.writetoexcel_status'(GlobalOutputFile, Execution_Sheetnum, TCrun, 3, 'FAIL')
			}	 
        }
    }
    
}