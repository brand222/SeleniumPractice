package actionsClass;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class sliderActions {


	private WebDriver driver;
	private String baseURL;
	private String chromeDriverName = "webdriver.chrome.driver";
	private String chromeDriverPath = "src\\chromedriver.exe";
	JavascriptExecutor jse;
	@Before
	public void setUp() throws Exception {
		
		System.setProperty(chromeDriverName, chromeDriverPath);
		driver = new ChromeDriver();
		baseURL = "https://jqueryui.com/slider/";

		// maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@Test
	public void test() throws InterruptedException {
	Thread.sleep(2000);
	driver.switchTo().frame(0);
	//here we create our slider object
	WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
	Actions action = new Actions(driver);
	Thread.sleep(2000);
	//here is the method for interacting with a slider web element
	action.dragAndDropBy(slider, 100, 0).perform();
	
	
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}



}