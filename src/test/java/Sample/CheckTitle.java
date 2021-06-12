package Sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckTitle {
	
	WebDriver driver;
	
	@Parameters("Browser")
	@Test
	public void checkTitle(String browserName) {
		System.out.println("The browser Name is "+browserName);
		 
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,10);
		Assert.assertTrue(wait.until(ExpectedConditions.titleContains("Google")),"Yes, the title matches");
	}
	
	@AfterMethod
	public void close() {
	driver.quit();
	}
}





