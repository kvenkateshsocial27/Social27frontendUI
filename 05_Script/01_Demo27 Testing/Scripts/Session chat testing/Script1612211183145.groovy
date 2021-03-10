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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://events1.social27.com/dailyrun/auth')

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_DailyQA Event/div_Email address'))

WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/div_Email address'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_DailyQA Event/div_Password'))

WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/div_Password'))

WebUI.setText(findTestObject('Object Repository/Page_DailyQA Event/input_Sign Up_mat-input-0'), 'kvenkatesh@social27.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_DailyQA Event/input_Email address_mat-input-1'), 'Vv4Pvs8Czl5pIkR2pWLj1w==')

WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/button_Login'))

WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/small_Session'))

WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/mat-icon_play_circle_outline'))

WebUI.setText(findTestObject('Object Repository/Page_DailyQA Event/textarea_QA Tester_chat-textarea no-border _44ae7c'), 
    'hi')

WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/button_send'))

WebUI.verifyElementVisible(findTestObject(null))

WebUI.click(findTestObject('Object Repository/Page_DailyQA Event/p_hi'))

