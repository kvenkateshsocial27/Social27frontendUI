import java.util.logging.Level

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.kms.katalon.core.configuration.RunConfiguration

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

System.setProperty('webdriver.chrome.driver', DriverFactory.getChromeDriverPath())
DesiredCapabilities caps = DesiredCapabilities.chrome();
LoggingPreferences logPrefs = new LoggingPreferences();
logPrefs.enable(LogType.BROWSER, Level.ALL);
caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
WebDriver driver = new ChromeDriver(caps);
driver.get('https://events1.social27.com/CUNAGAC2021/auth/')
LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

for (LogEntry entry : logEntries) {
	System.out.println(">>> " + new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
	//do something useful with the data
}

driver.quit();
