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

public class mouseHoverActions {


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
	WebElement btnHoverOver = driver.findElement(By.xpath("//*[@id='mousehover']"));
	
	//here we create an object of type Actions (where we access the actions methods)
	Actions action = new Actions(driver);
	//here is where we move the mouse to the element we specify
	action.moveToElement(btnHoverOver).perform();
	Thread.sleep(2000);
	//here is our subelement in the hover-over list that we are selecting
	WebElement subElement = driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
	//here we are hovering over the item in the list, and clicking it.
	action.moveToElement(subElement).click().perform();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}



}
