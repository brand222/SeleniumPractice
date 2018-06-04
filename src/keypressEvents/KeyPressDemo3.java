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

public class KeyPressDemo3 {

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
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		//here is an additional way to creating combo key press
		//notice we are using the actions class
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
		

	}
	// @After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
