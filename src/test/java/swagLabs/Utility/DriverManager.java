package swagLabs.Utility;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			
			//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();

			// Disable password save and autofill
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
			prefs.put("profile.default_content_setting_values.popups", 2);
			options.setExperimentalOption("prefs", prefs);

			// Disable automation flags
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			options.setExperimentalOption("useAutomationExtension", false);

			// Other common anti-detection flags
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--disable-infobars");
			options.addArguments("--start-maximized");
			options.addArguments("--incognito");

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			// driver.quit();
			driver = null;
		}
	}
}
