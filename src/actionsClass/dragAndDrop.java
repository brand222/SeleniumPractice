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

public class dragAndDrop {


	private WebDriver driver;
	private String baseURL;
	private String chromeDriverName = "webdriver.chrome.driver";
	private String chromeDriverPath = "src\\chromedriver.exe";
	JavascriptExecutor jse;
	@Before
	public void setUp() throws Exception {
		
		System.setProperty(chromeDriverName, chromeDriverPath);
		driver = new ChromeDriver();
		baseURL = "https://jqueryui.com/droppable/";

		// maximize the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@Test
	public void test() throws InterruptedException {
	driver.switchTo().frame(0);
	
	WebElement fromElement = driver.findElement(By.id("draggable"));
	WebElement toElement = driver.findElement(By.id("droppable"));
	
	Actions action = new Actions(driver);
	Thread.sleep(2000);
	//here is where we use the 'drag-and-drop' function
	//action.dragAndDrop(fromElement, toElement).build().perform();
	
	//you can also use 'click and hold' to move the element, release, build, and perform
	action.clickAndHold(fromElement).moveToElement(toElement).release().build().perform();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}



}
