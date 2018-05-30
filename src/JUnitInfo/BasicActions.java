package JUnitInfo;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
//java by default does not know what WebDriver is, we must import
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicActions {
	WebDriver driver;
	String baseURL, driverName, driverPath;
	
	// opening the browser, maximizing window, setting up driver object
	@Before
	public void setUp() throws Exception {
		driverName = "webdriver.chrome.driver";
		driverPath = "C:\\Users\\Brandon Mc\\git\\SeleniumPractice\\SeleniumFramework\\libs\\chromedriver.exe";
		System.setProperty(driverName, driverPath);
		driver = new ChromeDriver();
		baseURL = "http://letskodeit.teachable.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		driver.get(baseURL);
		driver.findElement(By.xpath("//*[@id='navbar']/div/div/div/ul/li[3]/a")).click();
		System.out.println("clicked the button");
		driver.findElement(By.xpath("//div/input[@name='user[name]']")).sendKeys("Brandon");
		driver.findElement(By.xpath("//div/input[@name='user[email]']")).sendKeys("blah@blah.com");
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	

}
