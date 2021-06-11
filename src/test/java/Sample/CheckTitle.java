package Sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckTitle {
	
	WebDriver driver;
	
	@BeforeTest
	public void signin() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void checkTitle() {
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println("The title is "+title);
		Assert.assertEquals(title, "Google");
	}

	
}
