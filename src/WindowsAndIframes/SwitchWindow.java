package WindowsAndIframes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {

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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() {
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();
		
		WebElement txtField = driver.findElement(By.id("search-courses"));
		txtField.sendKeys("python");
		
		// get the handle
		
		// find open window button

		// get all handles

		// switch between handles

		// switch back to parent window
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
