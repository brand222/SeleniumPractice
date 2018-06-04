package keypressEvents;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressDemo1 {


	private WebDriver driver;
	private String baseURL;
	private String chromeDriverName = "webdriver.chrome.driver";
	private String chromeDriverPath = "src\\chromedriver.exe";
	JavascriptExecutor jse;
	@Before
	public void setUp() throws Exception {
		
		System.setProperty(chromeDriverName, chromeDriverPath);
		driver = new ChromeDriver();
		baseURL = "http://letskodeit.teachable.com/p/practice";

		// maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@Test
	public void test() throws InterruptedException {
		//click the sign in button
		driver.findElement(By.xpath("//a[contains(@href, 'sign_in')]")).click();
		//enter username
		driver.findElement(By.xpath("//*[@id='user_email']")).sendKeys("blah@blah.com");
		Thread.sleep(2000);
		//here is an example of using the 'TAB' key to move to the next field
		driver.findElement(By.xpath("//*[@id='user_email']")).sendKeys(Keys.TAB);
		//enter password
		driver.findElement(By.xpath("//div/input[@id='user_password']")).sendKeys("sl);djfa;lsfd");
		Thread.sleep(2000);
		//here we are hitting the 'ENTER' key to the Log In button
		driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
		
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}



}
