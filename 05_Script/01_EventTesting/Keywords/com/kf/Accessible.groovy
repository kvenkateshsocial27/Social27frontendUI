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

public class Accessible {

	@Keyword
	List<String> getElementContentsAsList(String xpath4elements) {
		WebDriver webDriver = DriverFactory.getWebDriver()
		List<WebElement> elements = webDriver.findElements(By.xpath(xpath4elements))
		def contents = new ArrayList<String>()
		for (WebElement el : elements) {
			def content = el.getText()
			if (content != null) {
				contents.add(content)
			} else {
				contents.add('')
			}
		}
		return contents
	}

	@Keyword
	List<String> getAttributeValuesAsList(String xpath4elements, String attributeName) {
		WebDriver webDriver = DriverFactory.getWebDriver()
		List<WebElement> elements = webDriver.findElements(By.xpath(xpath4elements))
		def values = new ArrayList<String>()
		for (WebElement el : elements) {
			def value = el.getAttribute(attributeName)
			if (value != null) {
				values.add(value)
			} else {
				values.add('')
			}
		}
		return values
	}

	@Keyword
	List<WebElement> getWebElementsAsList(String xpath4elements) {
		WebDriver webDriver = DriverFactory.getWebDriver()
		List<WebElement> elements = webDriver.findElements(By.xpath(xpath4elements))
		return elements
	}
}

