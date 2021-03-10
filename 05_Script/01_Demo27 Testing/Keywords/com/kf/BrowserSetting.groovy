package com.kf

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.RemoteKeyboard
import static org.openqa.selenium.remote.CapabilityType.LOGGING_PREFS;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;
import static org.openqa.selenium.remote.CapabilityType.SUPPORTS_JAVASCRIPT;
import static org.openqa.selenium.remote.CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR;
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.webui.driver.WebUIDriverType
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.firefox.FirefoxProfile
import org.openqa.selenium.Capabilities;
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


public class BrowserSetting {

	@Keyword

	def Chromebrowser(String downloadpathfromscript) {
		//String downloadPath = "D:\\KF_Automation\\04_DownloadFiles\\01_DashboardReports"
		String downloadPath = downloadpathfromscript

		Map<String, Object> chromePrefs = new HashMap<String, Object>()
		Map<String, Object> content_setting = new HashMap <>();

		chromePrefs.put("download.default_directory", downloadPath)
		chromePrefs.put("download.prompt_for_download", false)
		chromePrefs.put("profile.default_content_setting_values.automatic_downloads", 1)
		content_setting.put("multiple-automatic-downloads",1);
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1 );
		chromePrefs.put("profile.default_content_settings", content_setting);
		chromePrefs.put( "profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1 );
		chromePrefs.put( "profile.default_content_setting_values.automatic_downloads", 1 );

		System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
		ChromeOptions options = new ChromeOptions()
		options.setExperimentalOption("prefs", chromePrefs)
		WebDriver driver = new ChromeDriver(options)
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setJavascriptEnabled(true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		DriverFactory.changeWebDriver(driver)
		new com.stucred.db.Launchapp().comWait(5)
	}
}