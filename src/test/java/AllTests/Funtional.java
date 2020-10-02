package AllTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import Selenium.DriverSetup;

public class Funtional extends DriverSetup {
	
	
	@Test
	public void enterTextOnSearchTextbox() {
		driver.findElement(By.className("gLFyf")).sendKeys("This is a test.");
		driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
	}
	
	

}
