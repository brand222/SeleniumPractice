package SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementState {

	WebDriver driver;
	String baseURL, driverName, driverPath;
	
	// opening the browser, maximizing window, setting up driver object
	@Before
	public void setUp() throws Exception {
		driverName = "webdriver.chrome.driver";
		driverPath = "src\\chromedriver.exe";
		System.setProperty(driverName, driverPath);
		driver = new ChromeDriver();
		baseURL = "https://www.google.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws InterruptedException {
	WebElement el = driver.findElement(By.id("gs_htif0"));
	el.sendKeys("Brandon McDonald");
	
	
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}



}
