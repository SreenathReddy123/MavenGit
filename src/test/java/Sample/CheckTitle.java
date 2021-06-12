package Sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
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
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println("The title is "+title);
		Assert.assertEquals(title, "Google");
	}
	
	@AfterMethod
	public void close() {
	driver.quit();
	}
}





