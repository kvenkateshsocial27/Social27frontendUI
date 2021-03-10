package com.stucred.db

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import java.lang.Object
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.util.KeywordUtil

public class Launchapp {

	KeywordUtil keyword = new KeywordUtil()

	@Keyword
	def navigateurl(String URL){
		try {
			WebUI.openBrowser(URL)

			System.out.println('Launch of the app is Successful - '+URL)
		}
		catch (Exception e) {
			System.out.println('Launch of the app is Unsuccessful - '+URL)
			e.printStackTrace()
		}
	}

	@Keyword
	def logincredentials(String Username, String Password){

		try {

			'- Login to the UAT-'
			WebUI.waitForElementPresent(findTestObject('Stucred BE Environment/Login/Login to Account'), 120)
			WebUI.comment('Entering Username')

			'- Enter username to login to the app-'
			WebUI.verifyElementPresent(findTestObject('Stucred BE Environment/Login/Username'), 10)
			WebUI.clearText(findTestObject('Stucred BE Environment/Login/Username'))
			WebUI.setText(findTestObject('Stucred BE Environment/Login/Username'), Username)

			'- Enter password to login to the app-'
			WebUI.clearText(findTestObject('Stucred BE Environment/Login/Password'))
			WebUI.comment('Entering Password')
			WebUI.setText(findTestObject('Stucred BE Environment/Login/Password'), Password)

			'- Tap the login button-'
			WebUI.click(findTestObject('Stucred BE Environment/Login/Login button'))

			'- Tap the login button-'
			System.out.println('LOGIN TO THE ACCOUNT step successfully executed' )
		}

		catch (Exception e) {
			System.out.println('LOGIN TO THE ACCOUNT step got failed : please refer the log ')
			e.printStackTrace()
		}
	}

	@Keyword
	def closeUAT(){
		try{

			WebUI.closeBrowser()
			System.out.println('CLOSE THE BROWSER step successfully executed' )
		}
		catch (Exception e) {
			System.out.println('CLOSE THE BROWSER step got failed  : please refer the log ' )
			e.printStackTrace()
		}
	}


	@Keyword
	def clickUsingJS(TestObject to, int timeout) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = WebUiCommonHelper.findWebElement(to, timeout)
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		executor.executeScript('arguments[0].click()', element)
	}

	@Keyword
	def doubleclickUsingJS(TestObject to, int timeout) {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = WebUiCommonHelper.findWebElement(to, timeout)
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		executor.executeScript("var evt = document.createEvent('MouseEvents');"+
				"evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"+
				"arguments[0].dispatchEvent(evt);", element);
	}

	@Keyword
	def comWait(def intWaitTime = null){
		if(intWaitTime == null) {
			intWaitTime = GlobalVariable.intShortWait
		}
		int intWaitTimeMillie = intWaitTime * 1000
		sleep(intWaitTimeMillie)
	}

	@Keyword
	def comparevalue(int BEvalue, int FEvalue, String resultdesc){
		if (BEvalue == FEvalue) {
			System.out.println('Total Number of Records MATCHES with the database for ' +resultdesc)
			System.out.println('Total Number of Records in the database  -  ' + BEvalue)
			System.out.println('Total Number of Records displayed in the Front end - ' + FEvalue)
			keyword.markPassed('Total Number of Records MATCHES with the database for ' +resultdesc)
			keyword.markPassed('Total Number of Records in the database  -  ' + BEvalue)
			keyword.markPassed('Total Number of Records displayed in the Front end - ' + FEvalue)
		} else {
			System.out.println('Total Number of Records DO NOT MATCH with the database  , REVISIT THE CASE AGAIN  MANUALLY' +resultdesc)
			System.out.println('Total Number of Records in the database  -  ' + BEvalue)
			System.out.println('Total Number of Records displayed in the Front end - ' + FEvalue)
			keyword.markFailed('Total Number of Records DO NOT MATCH with the database  , REVISIT THE CASE AGAIN  MANUALLY' +resultdesc)
			keyword.markFailed('Total Number of Records in the database  -  ' + BEvalue)
			keyword.markFailed('Total Number of Records displayed in the Front end - ' + FEvalue)
		}
	}
}
