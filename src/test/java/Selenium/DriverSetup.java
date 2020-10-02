package Selenium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverSetup {
protected static WebDriver driver;
	
	@Before
	public void browserOpen()
	{
		// setup Chrome Driver
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();		
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		
		// disable save password
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver(options);
		
		// Browser size
		//Dimension d = new Dimension(1280, 1050);
		//driver.manage().window().setSize(d);
		
		driver.manage().window().maximize();	// maximize browser window
		
		// implicit wait for 15 seconds before timing out
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//TEST URL
		driver.get("https://www.google.com/");	// loading URL in browser
		
		//PRODUCTION URL
		//driver.get("https://wnagencies.wnins.com/");
	}

	
	@After
	public void browserClose() 
	{
		driver.quit();	//.close();
	}
	

}
