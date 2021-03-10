package com.kf

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable

public class verifymenu {

	@Keyword
	def checkaccess (String Menu, String Access, String url, String GlobalOutputfile, int Rowno, int columnstart) {
		WebUI.refresh()
		String actualurl, expectedurl
		int Executionsheetno = 0
		switch (Menu) {
			case "Signin":
				switch (Access) {

					case Access = "Y":
					if(WebUI.verifyElementPresent(findTestObject('Menu/Signin'), 30,FailureHandling.OPTIONAL)) {
						WebUI.click(findTestObject('Menu/Signin'),FailureHandling.OPTIONAL)
						actualurl = WebUI.getUrl()
						expectedurl = "https://events1.social27.com/"+ url + "/auth"
						if(actualurl.equalsIgnoreCase(expectedurl)) {
							new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Sign in menu is displayed')
						}
						else {
							new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Sign in menu is not displayed')
						}
					}
					else {
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Sign in link not redirecting to Signinpage')
					}
					break // Menu

					case Access = "N":
					if(WebUI.verifyElementNotPresent(findTestObject('Menu/Signin'), 30,FailureHandling.OPTIONAL))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Sign in menu is not displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Sign in menu is displayed')
					}
					break
				}
				break

			case "Signup":
				switch (Access)
				{

					case Access = "Y":
					if(WebUI.verifyElementPresent(findTestObject('Menu/Signup'), 30,FailureHandling.OPTIONAL))
					{
						WebUI.click(findTestObject('Menu/Signup'),FailureHandling.OPTIONAL)
						WebUI.waitForPageLoad(60)
						//Thread.sleep(10000)

						actualurl = WebUI.getUrl()
						expectedurl = "https://events1.social27.com/"+ url + "/auth/register"
						if(actualurl.equalsIgnoreCase(expectedurl))
						{
							new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Signup menu is displayed')
						}
						else
						{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Signup link not redirecting to Register page')
						}
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Signup menu is not displayed')
					}
					break // Menu

					case Access = "N":
					if(WebUI.verifyElementNotPresent(findTestObject('Menu/Signup'), 30,FailureHandling.OPTIONAL))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Signup menu is not displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Signup menu is displayed')
					}
					break
				}
				break

			/*** End of Signup ***/

			/*** Home ***/

			case "Home":
				switch (Access)
				{

					case Access = "Y":
					if(WebUI.verifyElementPresent(findTestObject('Menu/Home'), 30,FailureHandling.OPTIONAL))
					{
						WebUI.click(findTestObject('Menu/Home'),FailureHandling.OPTIONAL)
						WebUI.waitForPageLoad(60)
						
						Thread.sleep(10000)
						actualurl = WebUI.getUrl()
						expectedurl = "https://events1.social27.com/"+ url + "/home"
						if(actualurl.equalsIgnoreCase(expectedurl))
						{
							new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Home menu is displayed')
						}
						else
						{
							new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Home menu is not displayed')
						}
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Home link not redirecting to Home page')

					}
					break // Menu

					case Access = "N":
					if(WebUI.verifyElementNotPresent(findTestObject('Menu/Home'), 30,FailureHandling.OPTIONAL))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Home menu is not displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Home menu is displayed')
					}
					break
				}
				break

			/*** Sessions ***/

			case "Sessions":
				switch (Access)
				{

					case Access = "Y":
					if(WebUI.verifyElementPresent(findTestObject('Menu/Session'), 30,FailureHandling.OPTIONAL))
					{
						WebUI.click(findTestObject('Menu/Session'),FailureHandling.OPTIONAL)
						WebUI.waitForPageLoad(60)
						
						Thread.sleep(10000)
						actualurl = WebUI.getUrl()
						expectedurl = "https://events1.social27.com/"+ url + "/agenda"
						if(actualurl.equalsIgnoreCase(expectedurl))
						{
							new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Sessions menu is displayed')
						}
						else
						{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Session link not redirecting to Session page')
						}
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Sessions menu is not displayed')
					}
					break // Menu

					case Access = "N":
					if(WebUI.verifyElementNotPresent(findTestObject('Menu/Session'), 30,FailureHandling.OPTIONAL))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Sessions menu is not displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Sessions menu is displayed')
					}
					break
				}
				break

			/*** Speakers ***/

			case "Speakers":
				switch (Access)
				{

					case Access = "Y":
					if(WebUI.verifyElementPresent(findTestObject('Menu/Speakers'), 30,FailureHandling.OPTIONAL))
					{
						WebUI.click(findTestObject('Menu/Speakers'),FailureHandling.OPTIONAL)
						WebUI.waitForPageLoad(60)
						
						Thread.sleep(10000)

						actualurl = WebUI.getUrl()
						expectedurl = "https://events1.social27.com/"+ url + "/speakers"
						if(actualurl.equalsIgnoreCase(expectedurl))
						{
							new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Speakers menu is displayed')
						}
						else
						{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Speakers link not redirecting to Speaker page')
						}
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Speakers menu is not displayed')
					}
					break // Menu

					case Access = "N":
					if(WebUI.verifyElementNotPresent(findTestObject('Menu/Speakers'), 30,FailureHandling.OPTIONAL))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Speakers menu is not displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Speakers menu is displayed')
					}
					break
				}
				break


			case "Sponsors":
				switch (Access)
				{

					case Access = "Y":
					if(WebUI.verifyElementPresent(findTestObject('Menu/ExpoHall'), 30,FailureHandling.OPTIONAL))
					{
						WebUI.click(findTestObject('Menu/ExpoHall'),FailureHandling.OPTIONAL)
						WebUI.waitForPageLoad(60)
						
						Thread.sleep(10000)

							
						actualurl = WebUI.getUrl()
						expectedurl = "https://events1.social27.com/"+ url + "/expohall"
						if(actualurl.equalsIgnoreCase(expectedurl))
						{
							new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Sponsors menu is displayed')
						}
						else
						{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Sponsors link not redirecting to Sponsor page')
						}
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Sponsors menu is not displayed')
					}
					break // Menu

					case Access = "N":
					if(WebUI.verifyElementNotPresent(findTestObject('Menu/ExpoHall'), 30,FailureHandling.OPTIONAL))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Sponsors menu is not displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Sponsors menu is displayed')
					}
					break
				}
				break

			case "Networking":
				switch (Access)
				{

					case Access = "Y":
					if(WebUI.verifyElementPresent(findTestObject('Menu/Networkinglounge'), 30,FailureHandling.OPTIONAL))
					{
						WebUI.click(findTestObject('Menu/Networkinglounge'),FailureHandling.OPTIONAL)
						WebUI.waitForPageLoad(60)
						
						Thread.sleep(10000)

						actualurl = WebUI.getUrl()
						expectedurl = "https://events1.social27.com/"+ url + "/networkinglounge"
						if(actualurl.equalsIgnoreCase(expectedurl))
						{
							new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Networking menu is displayed')
						}
						else
						{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Networking link not redirecting to Networking page')
						}
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Networking menu is not displayed')
					}
					break // Menu

					case Access = "N":
					if(WebUI.verifyElementNotPresent(findTestObject('Menu/Networkinglounge'), 30,FailureHandling.OPTIONAL))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Networking menu is not displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Networking menu is displayed')
					}
					break
				}
				break

			case "Roundtables":
				switch (Access)
				{

					case Access = "Y":
					if(WebUI.verifyElementPresent(findTestObject('Menu/Roundtable'), 30,FailureHandling.OPTIONAL) == true)
					{
						WebUI.click(findTestObject('Menu/Roundtable'),FailureHandling.OPTIONAL)
						WebUI.waitForPageLoad(60)
						
						Thread.sleep(10000)

						actualurl = WebUI.getUrl()
						expectedurl = "https://events1.social27.com/"+ url + "/roundtables"
						if(actualurl.equalsIgnoreCase(expectedurl))
						{
							new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Roundtables menu is displayed')
						}
						else
						{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Roundtables link not redirecting to Roundtables page')
						}
					}

					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Roundtables menu is not displayed')
					}
					break // Menu

					case Access = "N":
					if(WebUI.verifyElementNotPresent(findTestObject('Menu/Roundtable'), 30,FailureHandling.OPTIONAL))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Rountables menu is not displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Rountables menu is displayed')
					}
					break
				}
				break

			case "Logout":
				switch (Access)
				{

					case Access = "Y":
					if(WebUI.verifyElementPresent(findTestObject('Menu/Logout'), 30,FailureHandling.OPTIONAL))
					{
						WebUI.click(findTestObject('Menu/Logout'),FailureHandling.OPTIONAL)
						WebUI.waitForPageLoad(60)
						
						Thread.sleep(10000)

						actualurl = WebUI.getUrl()
						expectedurl = "https://events1.social27.com/"+ url + "/auth"
						if(actualurl.equalsIgnoreCase(expectedurl))
						{
							new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Logout menu is displayed')
						}
						else
						{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Logout link not redirecting to Logout page')
						}
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Logout menu is not displayed')
					}
					break // Menu

					case Access = "N":
					if(WebUI.verifyElementNotPresent(findTestObject('Menu/Logout'), 30,FailureHandling.OPTIONAL))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Logout menu is not displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Logout menu is displayed')
					}
					break
				}
				break


			case "Notifications":
				switch (Access)
				{

					case Access = "Y":
					if(WebUI.verifyElementPresent(findTestObject('Menu/Notification'), 30,FailureHandling.OPTIONAL))
					{
						WebUI.click(findTestObject('Menu/Notification'),FailureHandling.OPTIONAL)
						WebUI.waitForPageLoad(60)
						
						Thread.sleep(10000)

						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Notifications menu is displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Notifications menu is not displayed')

					}
					break // Menu

					case Access = "N":
					if(WebUI.verifyElementNotPresent(findTestObject('Menu/Notification'), 30,FailureHandling.OPTIONAL))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Notifications menu is not displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Notifications menu is displayed')
					}
					break
				}

				break

			case "Profile":
				switch (Access)
				{

					case Access = "Y":
					if(WebUI.verifyElementPresent(findTestObject('Menu/Myprofile'), 30,FailureHandling.OPTIONAL))
					{
						WebUI.click(findTestObject('Menu/Myprofile'),FailureHandling.OPTIONAL)
						WebUI.waitForPageLoad(60)
						
						Thread.sleep(10000)

						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - MyProfile menu is displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - MyProfile menu is not displayed')
					}
					break // Menu

					case Access = "N":
					if(WebUI.verifyElementNotPresent(findTestObject('Menu/Myprofile'), 30,FailureHandling.OPTIONAL))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - MyProfile menu is not displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - MyProfile menu is displayed')
					}
					break
				}
				break

			case "MyAgenda":
				switch (Access)
				{

					case Access = "Y":
					if(WebUI.verifyElementPresent(findTestObject('Menu/MyAgenda'), 30,FailureHandling.OPTIONAL))
					{
						WebUI.click(findTestObject('Menu/MyAgenda'),FailureHandling.OPTIONAL)
						WebUI.waitForPageLoad(60)
						
						Thread.sleep(10000)

						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - MyAgenda menu is displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - MyAgenda menu is not displayed')
					}
					break // Menu

					case Access = "N":
					if(WebUI.verifyElementNotPresent(findTestObject('Menu/MyAgenda'), 30,FailureHandling.OPTIONAL))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - MyAgenda menu is not displayed')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - MyAgenda menu is displayed')
					}
					break
				}
				break


			case "Landingpage":
				switch (Access)
				{

					case Access = "Personalized":
					WebUI.waitForPageLoad(60)
					
					Thread.sleep(20000)
					actualurl = WebUI.getUrl()
					expectedurl = "https://events1.social27.com/"+ url + "/personalized"
					if(actualurl.equalsIgnoreCase(expectedurl))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Personalized page is the landing page')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Personalized page is not the landing page')
					}
					break

					case Access = "Thankyou":
					WebUI.waitForPageLoad(60)
					
					Thread.sleep(20000)
					actualurl = WebUI.getUrl()
					expectedurl = "https://events1.social27.com/"+ url + "/auth/thankyou"
					if(actualurl.equalsIgnoreCase(expectedurl))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Thankyou page is the landing page')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Thankyou page is not the landing page')
					}
					break

					case Access = "Home":
					WebUI.waitForPageLoad(60)
					
					Thread.sleep(20000)
					actualurl = WebUI.getUrl()
					expectedurl = "https://events1.social27.com/"+ url + "/home"
					if(actualurl.equalsIgnoreCase(expectedurl))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Thankyou page is the landing page')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Thankyou page is not the landing page')
					}
					break

					case Access = "Presignup":
					WebUI.waitForPageLoad(60)
					
					Thread.sleep(20000)
					actualurl = WebUI.getUrl()
					expectedurl = "https://events1.social27.com/"+ url + "/page/pre-signup"
					if(actualurl.equalsIgnoreCase(expectedurl))
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'PASS - Thankyou page is the landing page')
					}
					else
					{
						new com.kf.Excel().writetoexcel_status(GlobalOutputfile, Executionsheetno, Rowno, columnstart,'FAIL - Thankyou page is not the landing page')
					}
					break


				}
				break

		}



	} // Menu

}
