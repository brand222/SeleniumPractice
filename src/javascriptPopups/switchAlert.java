package javascriptPopups;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchAlert {

	private WebDriver driver;
	private String baseUrl;
	private String chromeDriverName = "webdriver.chrome.driver";
	private String chromeDriverPath = "src\\chromedriver.exe";
	@Before
	public void setUp() throws Exception {
		System.setProperty(chromeDriverName, chromeDriverPath);
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/p/practice";

		// maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void test1() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("brandon");
		//click the alert button
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(3000);
		//now we shift the focus to the javascript alert window
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void test2() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys("brandon");
		//click the alert button
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3000);
		//now we shift the focus to the javascript alert window
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(3000);
		driver.quit();
	}

	

}
