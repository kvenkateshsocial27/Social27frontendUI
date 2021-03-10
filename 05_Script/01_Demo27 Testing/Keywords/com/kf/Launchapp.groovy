package com.kf

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
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
import java.awt.event.InputEvent;
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
	def opentab(){
		try {
			int currentTab = WebUI.getWindowIndex()
			WebDriver driver = DriverFactory.getWebDriver()
			JavascriptExecutor js = ((driver) as JavascriptExecutor)
			js.executeScript("window.open();")
			WebUI.switchToWindowIndex(currentTab+1)
		}
		catch (Exception e) {
			System.out.println('Could not able to Open New tab, Please check')
			e.printStackTrace()
		}
	}

	@Keyword
	def botaction(){
		WebUI.delay(1)
		Robot bot = new Robot();
		bot.mouseMove(0, 0);
		bot.mouseMove(310, 100);
		bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		bot.keyPress(KeyEvent.VK_ENTER)
		WebUI.delay(1)

		bot.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(2)
	}

	@Keyword
	def botaction2(){

		Robot bot = new Robot();
		Robot robot = new Robot();
		bot.keyPress(KeyEvent.VK_ALT)
		bot.keyPress(KeyEvent.VK_D)
		bot.keyRelease(KeyEvent.VK_D)
		bot.keyRelease(KeyEvent.VK_ALT)
		WebUI.delay(1)
		bot.keyPress(KeyEvent.VK_HOME)
		robot.keyRelease(KeyEvent.VK_HOME);
		WebUI.delay(1)
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		WebUI.delay(1)
		bot.keyRelease(KeyEvent.VK_TAB);
		bot.keyRelease(KeyEvent.VK_SHIFT);
		WebUI.delay(1)
		bot.keyPress(KeyEvent.VK_ENTER)
		bot.keyRelease(KeyEvent.VK_ENTER);
		WebUI.delay(1)
		bot.keyPress(KeyEvent.VK_TAB)
		bot.keyRelease(KeyEvent.VK_TAB)
		WebUI.delay(1)
		bot.keyPress(KeyEvent.VK_TAB)
		bot.keyRelease(KeyEvent.VK_TAB)
		WebUI.delay(1)
		bot.keyPress(KeyEvent.VK_TAB)
		bot.keyRelease(KeyEvent.VK_TAB)
		WebUI.delay(1)
		bot.keyPress(KeyEvent.VK_PAGE_DOWN)
		bot.keyRelease(KeyEvent.VK_PAGE_DOWN)
		WebUI.delay(1)
		bot.keyPress(KeyEvent.VK_ENTER)
		bot.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(2)
		bot.keyPress(KeyEvent.VK_ENTER)
		bot.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(2)
		bot.keyPress(KeyEvent.VK_DOWN)
		bot.keyRelease(KeyEvent.VK_DOWN)
		WebUI.delay(1)
		bot.keyPress(KeyEvent.VK_ENTER)
		bot.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(2)
		WebUI.refresh()
	}
	@Keyword
	def botaction1(){
		Robot bot = new Robot();
		WebUI.delay(1)
		bot.mouseMove(0, 0);
		bot.mouseMove(20, 20);
		bot.mouseMove(710, 80);
		bot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		bot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		bot.keyRelease(KeyEvent.VK_ENTER)
		WebUI.delay(1)
		bot.keyPress(KeyEvent.VK_ENTER)
		WebUI.delay(1)
	}

	@Keyword
	def logincredentials(String Username, String Password){

		try {

			'- Login to the UAT-'
			WebUI.waitForElementPresent(findTestObject('Dataknownfactors/01_Login/Username'), 120)
			'- Enter username to login to the app-'
			WebUI.clearText(findTestObject('Dataknownfactors/01_Login/Username'))
			WebUI.setText(findTestObject('Dataknownfactors/01_Login/Username'), Username)
			WebUI.comment('User enters data in the Username Field')

			WebUI.verifyElementPresent(findTestObject('Dataknownfactors/01_Login/Password'), 10)

			'- Enter password to login to the app-'
			WebUI.clearText(findTestObject('Dataknownfactors/01_Login/Password'))
			WebUI.comment('User enters data in the Password Field')
			WebUI.setText(findTestObject('Dataknownfactors/01_Login/Password'), Password)
			WebUI.delay(5)

			'- Tap the login button-'
			WebUI.click(findTestObject('Dataknownfactors/01_Login/Loginbtn'))

			'- Tap the login button-'
			System.out.println('USER LOGGING INTO THE APPLICATION')
		}

		catch (Exception e) {
			System.out.println('USER LOGGING INTO THE APPLICATION step got failed : PLEASE REFER THE LOG')
			e.printStackTrace()
		}
	}

	@Keyword
	def closeUAT(){
		try{

			WebUI.closeBrowser()
			System.out.println('CLOSING THE BROWSER step successfully executed' )
		}
		catch (Exception e) {
			System.out.println('CLOSING THE BROWSER step got failed  : PLEASE REFER THE LOG' )
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
