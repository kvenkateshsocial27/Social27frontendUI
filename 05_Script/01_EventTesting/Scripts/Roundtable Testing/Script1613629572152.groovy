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


WebUI.callTestCase(findTestCase('Login Page Testing'), [('Username') : 'kvenkatesh@social27.com', ('Password') : 'social27'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Verify Roundtable Testing'), [:], FailureHandling.STOP_ON_FAILURE)

